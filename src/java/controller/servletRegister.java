/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
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

/**
 *
 * @author Cy
 */
@WebServlet(name = "servletRegister", urlPatterns = {"/servletRegister"})
public class servletRegister extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            
            if (last_name == null){
                RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/register.jsp");
                req.include(request, response);
            
            return;
            }
// Check if fliends are empty, if so. the page return to initial state - and shows an error message            
            if(last_name.isEmpty() || first_name.isEmpty() || email.isEmpty() || 
				username.isEmpty() || password.isEmpty()){
                msg = "ERROR!!!!";
                request.setAttribute("msg", msg);
                request.setAttribute("last_name", last_name);
                request.setAttribute("first_name", first_name);
                request.setAttribute("email", email);
                request.setAttribute("username", username);                
                
                RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/register.jsp");
                req.include(request, response);
                
                
            }else{
// If form is ok, the newly registered customer gets send to his account page. 
               
               Customer customer = new Customer();
                
               customer.setCustomerLName(request.getParameter("last_name"));
               customer.setCustomerFName(request.getParameter("first_name"));
               customer.setCustomerUsername(request.getParameter("username"));
               customer.setCustomerEmail(request.getParameter("email"));
               customer.setCustomerPassword(request.getParameter("password"));
               
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
               
               
            RequestDispatcher req = request.getRequestDispatcher("/account.html");
            req.forward(request, response);
            }
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
