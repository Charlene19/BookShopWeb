/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.bean.beanEvent;
import model.bean.beanOrder;
import model.entity.Book;
import model.dao.PublisherDAO;
import model.dao.VatDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Charlène
 */
@WebServlet(name = "eventServlet", urlPatterns = {"/eventServlet"})
public class eventServlet extends HttpServlet {
String event;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet requests
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet eventServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet eventServlet at " + request.getContextPath() + "</h1>");  
            
            event = request.getParameter("event");
            beanEvent beanE = new beanEvent(); 
            
            List <Book> books = (List <Book>) beanE.returnlBook(event);
            Double remise = beanE.getDiscountPrice(event); 
            
            request.setAttribute("remise", remise); 
            request.setAttribute("book", books);
            this.getServletContext().getRequestDispatcher( "/jspEvent.jsp").include( request, response );
           
            out.println("</body>");
            out.println("</html>");
            
            ///WEB-INF/jspEvent.jsp
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
         event = request.getParameter("event");
            beanEvent beanE = new beanEvent(); 
            
            List <Book> books = (List <Book>) beanE.returnlBook(event);
            Double remise = beanE.getDiscountPrice(event); 
            
            request.setAttribute("remise", remise); 
            request.setAttribute("book", books);
            this.getServletContext().getRequestDispatcher( "/jspEvent.jsp").include( request, response );
    } catch (SQLException ex) {
        Logger.getLogger(eventServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NamingException ex) {
        Logger.getLogger(eventServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    } catch (SQLException ex) {
        Logger.getLogger(eventServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NamingException ex) {
        Logger.getLogger(eventServlet.class.getName()).log(Level.SEVERE, null, ex);
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
