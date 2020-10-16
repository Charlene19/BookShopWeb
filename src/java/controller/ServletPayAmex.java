/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Loïc
 */
@WebServlet(name = "ServletPayAmex", urlPatterns = {"/ServletPayAmex"})
public class ServletPayAmex extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        /* TODO output your page here. You may use following sample code. */
        String digits = request.getParameter("digitsAmex");
        String secuAmex = request.getParameter("secuAmex");
        final String regexAmex = "^3[47][0-9]{13}$";
        final String regexSecuAmex = "^[0-9]{3,4}$";
        String messageAm;
        
        
       
            if (!digits.matches(regexAmex) || !secuAmex.matches(regexSecuAmex)) {
                messageAm = "Votre tentative de paiement a échoué.";
                request.setAttribute("messageAm", messageAm);
                /**/
                RequestDispatcher req = request.getRequestDispatcher("paymentInfoAmex.jsp");
                req.forward(request, response);/**/

            } else {
                RequestDispatcher req = request.getRequestDispatcher("validPay.jsp");
                req.forward(request, response);
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
