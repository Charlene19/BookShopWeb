
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.BookDAO;
import model.entity.Book;
import res.Values;


/**
 *
 * @author Cy
 */


/* 
    Servlet qui remplace et appele la page d'accueil!
    
    Ajoutez ici toutes les methodes necessaires pour modifier la HomePage!

*/

@WebServlet(name = "HomePage", urlPatterns = {"/HomePage"})
public class ServletHomePage extends HttpServlet {
    
/*
 *                          Method to name variables for JSPs
 */    
    
    private void initp() { 
                   
            
        getServletContext().setAttribute("result", res.Values.QUICK_SEARCH_CONTROLLER);
        getServletContext().setAttribute("account", res.Values.JSP_ACCOUNT);
        getServletContext().setAttribute("book_info", res.Values.JSP_BOOK_INFO);
        getServletContext().setAttribute("book_information", res.Values.JSP_BOOK_INFO_FULL);
        getServletContext().setAttribute("error", res.Values.JSP_ERROR);
        getServletContext().setAttribute("home", res.Values.JSP_HOME);
        getServletContext().setAttribute("login", res.Values.JSP_LOGIN);
        getServletContext().setAttribute("login_f", res.Values.JSP_LOGIN_FULL);
        getServletContext().setAttribute("notlog", res.Values.JSP_NOTLOG);
        getServletContext().setAttribute("register", res.Values.JSP_REGISTER);
        getServletContext().setAttribute("register_f", res.Values.JSP_REGISTER_FULL);
        getServletContext().setAttribute("cart", res.Values.JSP_SHOPPING_CART);
        getServletContext().setAttribute("cart_f", res.Values.JSP_SHOPPING_CART_FULL);

            
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = "homePageJsp.jsp";

// Call on method to set Attributes for the JPSs (here above):
            initp();
            
// Gets the last 5 books from DB
            ArrayList<Book> allBooks = (ArrayList<Book>) new BookDAO().getAll();
            List<Book> lastBooks = new ArrayList<Book>();
            for(int i = allBooks.size() - 1; i > allBooks.size() - 4; i--){
                lastBooks.add(allBooks.get(i));
            }
// Displays books
            for(Book book : lastBooks){
                System.out.println(book);
                
            }
// Gets the best sales from DB
            List<Book> bookSales = new BookDAO().getBestSales();
              
            request.setAttribute("books", lastBooks);
            request.setAttribute(Values.PARAM_BEST_SALES_BOOKS, bookSales);
                
            request.getRequestDispatcher("homePageJsp.jsp").include(request, response);   
            
        } catch (NamingException ex) {
            Logger.getLogger(ServletHomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletHomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServletHomePage.class.getName()).log(Level.SEVERE, null, ex);
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
