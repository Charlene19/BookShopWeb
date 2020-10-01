/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.beanOrder;
import classes.Book;
import classes.Order;
import dao.PublisherDAO;
import dao.VatDAO;
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import res.Values;

/**
 *
 * @author Charlène
 */
@WebServlet(name = "orderServlet", urlPatterns = {"/orderServlet"})
public class orderServlet extends HttpServlet {
  
    private String customId; 
    private final String bookRequest = "select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id in(\n" + "Select Order_id from [dbo].[ORDER] where [dbo].[ORDER].CUSTOMER_ID = "+ customId +")) ";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet orderServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet orderServlet at " + request.getContextPath() + "</h1>");
            
            HttpSession session= request.getSession();
            beanOrder Sessionbean= (beanOrder) session.getAttribute(Values.BEAN_LOGIN_NAME);
            
            if( Sessionbean==null) {
                out.println("<p> Aucune commande </p>");
            }else{
        
                customId =  (String) request.getAttribute("email");
               
               List<Book> lBook = new ArrayList();
        
         DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/Bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
                String query = bookRequest;
                
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                 Book book = null;

                while (rs.next()) {
                    book = new Book();
                            book.setIsbn(rs.getString("BOOK_ISBN"));
                            book.setTitle(rs.getString("Book_Title"));
                            book.setSubTitle(rs.getString("Book_Subtitle"));
                            book.setPrice((float) rs.getDouble("Book_HT_PROCE"));
                            book.setCoverURL(rs.getString("Book_Cover_Url") );
                    
                    lBook.add(book);        
                }
                
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jspOrder.jsp");
           requestDispatcher.include(request, response) ;
            
            out.println(lBook);
            out.println("</body>");
            out.println("</html>");
        }
    }
    }
    
    //récupere tous les livres d'un client : page html Order
     public List<Book> getList() throws SQLException, NamingException{
         
        List<Book> lBook = new ArrayList();
        
         DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/Bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
                String query = bookRequest;
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                 Book object = null;

                while (rs.next()) {
                    
                    
                    object = new Book();
                object.setIsbn(rs.getString(1));
                
                // Obtains the publisher matching the ID
                object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
                // Obtains the VAT matching the ID
                object.setVat(new VatDAO().get(rs.getInt(3)));
                object.setTitle(rs.getString(4));
                object.setSubTitle(rs.getString(5));
                object.setPrice(rs.getFloat(6));
                object.setCoverURL(rs.getString(7));
                object.setSummary(rs.getString(8));
                object.setQuantity(rs.getInt(9));
                object.setShelf(rs.getString(10));
                object.setPostIt(rs.getString(11));
                
               
                
                  lBook.add(object );
                   
                }
                

        
        
        return lBook;
    }

     
    public String getStatusOrder(Order orderCours) throws SQLException{
              String statut = "";
             DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/Bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
                String query = "Select [ORDER_STATUS_NAME] from [dbo].[ORDER_STATUS] where [ORDER_STATUS_ID] in (Select [ORDER_STATUS_ID] from [dbo].[ASSOC_STATUS_ORDER] where [ORDER_ID] = '" + orderCours.getId() +  "' ";
                       
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                 while (rs.next()){
                    statut = rs.getString("ORDER_STATUS_NAME");
                 }
                 return statut; 
    }
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
   
    @Override
    public String getServletInfo() {
        return "Servlet Order";
    }

}
