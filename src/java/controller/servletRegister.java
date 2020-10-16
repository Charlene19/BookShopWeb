package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CustomerDAO;
import model.entity.Customer;
import res.Values;
import util.HashUtil;

/**
 *
 * @author Cy
 */
@WebServlet(name = "servletRegister", urlPatterns = {"/servletRegister"})
public class servletRegister extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {      
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* Gets the info entered on the register.html page */
            String last_name = request.getParameter("last_name");
            String first_name = request.getParameter("first_name");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            // Variable 
            String msg;
            //email regex
            final String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

/*
            This part of code checks if the user is coming from outside of the page:
            */            

            if (last_name == null){
                RequestDispatcher req = request.getRequestDispatcher(Values.JSP_REGISTER_FULL);
                req.include(request, response);

            return;
            }
/*
            
            Check if fields are empty, if so. the page return to initial state -
            and shows an error message
            Also it leaves the inserted text into corresponding fields
*/
            if (email !=null){
                //check if email is in database:

//                Customer newCustomer = new Customer();
                CustomerDAO dao = new CustomerDAO();
                try{
                boolean emailFound = dao.getCheckEmail(email);

                if (emailFound == true){;
                // If Email exists in database
                msg ="Cet email est deja connu! Veuillez vous connecter!";
                request.setAttribute("msg", msg);
                request.setAttribute("last_name", last_name);
                request.setAttribute("first_name", first_name);
                request.setAttribute("email", email);
                request.setAttribute("username", username);                

                RequestDispatcher req = request.getRequestDispatcher(Values.JSP_REGISTER_FULL);
                req.include(request, response);
                return;
                }  
                } catch (NamingException ex) {
                    System.out.println("Naming exception: " + ex);
                    Logger.getLogger(servletRegister.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    System.out.println("SQLException: " + ex);
                    Logger.getLogger(servletRegister.class.getName()).log(Level.SEVERE, null, ex);
                }


            }              



            if(last_name.isEmpty() || first_name.isEmpty() || email.isEmpty() || 
				username.isEmpty() || password.isEmpty()){
                msg = "Veuillez remplir les champs manquants!!!";
                request.setAttribute("msg", msg);
                request.setAttribute("last_name", last_name);
                request.setAttribute("first_name", first_name);
                request.setAttribute("email", email);
                request.setAttribute("username", username);                

                RequestDispatcher req = request.getRequestDispatcher(Values.JSP_REGISTER_FULL);
                req.include(request, response);

//            }else if(request.getAttribute("email") == {

            }else{
                
                if (!email.matches(emailRegex)) {
                    
                    msg = "Veuillez entrer une adresse e-mail valide.";
                request.setAttribute("msg", msg);
                request.setAttribute("last_name", last_name);
                request.setAttribute("first_name", first_name);
                request.setAttribute("email", email);
                request.setAttribute("username", username);                

                RequestDispatcher req = request.getRequestDispatcher(Values.JSP_REGISTER_FULL);
                req.include(request, response);
                } else {
                    // If form is ok, the newly registered customer gets send to his account page. 

               Customer customer = new Customer();

               customer.setCustomerLName(request.getParameter("last_name"));
               customer.setCustomerFName(request.getParameter("first_name"));
               customer.setCustomerUsername(request.getParameter("username"));
               customer.setCustomerEmail(request.getParameter("email"));
// Hashes the password before its sent to DB
               customer.setCustomerPassword(new HashUtil().hashText(request.getParameter("password")));

               CustomerDAO newCustomer = new CustomerDAO();
                try {
                    newCustomer.add(customer);
                } catch (NamingException ex) {
                    System.out.println("Naming exception: " + ex);
                    Logger.getLogger(servletRegister.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    System.out.println("SQLException: " + ex);
                    Logger.getLogger(servletRegister.class.getName()).log(Level.SEVERE, null, ex);
                }

// Change this line to redirect new customer to desired page of website:               
            RequestDispatcher req = request.getRequestDispatcher(Values.SERVLET_HOME);
            req.forward(request, response);
                }
                

            }
// Hash related exceptions         
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(servletRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(servletRegister.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(servletRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(servletRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
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