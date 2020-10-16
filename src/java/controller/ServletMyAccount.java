package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.CustomerDAO;
import model.entity.Customer;
import res.Values;
import util.HashUtil;

/**
 *
 * @author Loïc
 */
@WebServlet(urlPatterns = {"/ServletMyAccount"})
public class ServletMyAccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html;charset=UTF-8");

            //
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");

            if (customer != null) {

                String lName = request.getParameter("lName");
                String fName = request.getParameter("fName");
                String pseudo = request.getParameter("pseudo");
                String newPassword = request.getParameter("newPassword");
                String newPasswordConf = request.getParameter("newPasswordConf");
                final String nameRegex = "(?!.*--)[\\u00C0-\\u017Fa-zA-Z-' ]+";
                String message;

                //Customer customer = new CustomerDAO().getByUsername("test", "2002");
                if (fName.isEmpty() || !fName.matches(nameRegex) || lName.isEmpty() || !lName.matches(nameRegex) || pseudo.isEmpty() || newPassword.isEmpty() || newPasswordConf.isEmpty()) {
                    message = "Veuillez compléter tous les champs avec des informations valides.";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("idModif.jsp").forward(request, response);
                } else {
                    if (lName.length() > 50 || fName.length() > 50 || pseudo.length()>20) {
                        message = "La taille maximale autorisée pour un nom ou un prénom est de 50 caractères. La taille maximale autorisée pour un pseudonymé est de 20 caractères.";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("idModif.jsp").forward(request, response);
                    } else {
                        if (!newPassword.equals(newPasswordConf)) {
                            message = "Les deux mots de passe doivent être identiques";
                            request.setAttribute("message", message);
                            request.getRequestDispatcher("idModif.jsp").forward(request, response);
                        } else {
                            customer.setCustomerFName(fName);
                            customer.setCustomerLName(lName);
                            customer.setCustomerUsername(pseudo);
                            customer.setCustomerPassword(new HashUtil().hashText(newPassword));
                            new CustomerDAO().update(customer);
                            request.getRequestDispatcher("jspModifConf.jsp").forward(request, response);
                        }
                    }

                }

            } else {
                request.getRequestDispatcher("login").forward(request, response);
            }

        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
