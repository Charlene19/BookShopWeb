/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.OrderDAO;
import model.entity.Book;
import model.entity.Customer;
import model.entity.Order;
import res.Values;

/**
 *
 * @author cda611
 */
@WebServlet(name = "orderStatusActive", urlPatterns = {"/orderStatusActive"})
public class orderStatusActive extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
           try {
           HttpSession session = request.getSession();

            if (session.getAttribute(Values.PARAM_CUSTOMER) == null){
                request.setAttribute(Values.PARAM_ERROR_MSG, Values.ERROR_NOT_LOGIN);
                request.getRequestDispatcher(Values.JSP_NOTLOG).include(request, response);
                return;     
            }else{
                
                Customer custid = (Customer) session.getAttribute(Values.PARAM_CUSTOMER);
                OrderDAO orderDAO = new OrderDAO(); 
                List<Order> order = new ArrayList();
                
                String id = String.valueOf(custid.getCustomerId());
                order = (List<Order>) orderDAO.getStatusOrder(id);
                
                request.setAttribute("list", order);
               
                
                /*request.setAttribute("date", order.getDateOrder());
                request.setAttribute("timeLimite", order.getDateLivraison());
                request.setAttribute("comment", order.getCommentaire());
                request.setAttribute("statut", order.getOrderStatus());*/
                
                 request.getRequestDispatcher("/orderStatus.jsp").include(request, response);
        
            }
            } catch (SQLException ex) {
                Logger.getLogger(QuickSearchController.class.getName()).log(Level.SEVERE, null, ex);
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
