package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.BookDAO;
import model.entity.Book;
import res.Values;

/**
 *
 * @author zvr
 */
@WebServlet(urlPatterns = {"/book"})
public class ServletBook extends HttpServlet {

    public final String JSP_HOME = "/WEB-INF/home.jsp";

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
            new BookDAO().getBestSales();
        } catch (NamingException ex) {
            Logger.getLogger(ServletBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServletBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // YOU MUST PROVIDE AN ISBN OR THE BOOK TO DISPLAY
        // in request

        // Attempts to retrieve the book from the request, if one was given
        Book book = (Book) request.getAttribute(Values.PARAM_BOOK);

        // If no book object was provided
        if (request.getAttribute(Values.PARAM_BOOK) == null) {

            // If an isbn has been given
            if (request.getParameter(Values.PARAM_ISBN) != null) {

                // Search for this book using the ISBN
                BookDAO bookDAO = new BookDAO();
                try {
                    book = bookDAO.getById(request.getParameter(Values.PARAM_ISBN));
                } catch (Exception ex) {
                    request.setAttribute(Values.PARAM_ERROR_MSG, ex.getMessage());
                    request.getRequestDispatcher(Values.JSP_ERROR).include(request, response);
                    return;
                }
            }

            // If there is still no book at this point
            if (book == null) {

                // Abort mission
                request.setAttribute(Values.PARAM_ERROR_MSG, Values.ERROR_NO_BOOK);
                request.getRequestDispatcher(Values.JSP_ERROR).include(request, response);
                return;
            }
        }

        // Updates the history
        updateLastVisited(request, book);
        
        // Book comments go inside this collection
        Collection<Object> comments = new ArrayList<>();

        // This contains the book to be displayed
        request.setAttribute(Values.PARAM_BOOK, book);
        

        // This contains the comments related to this books
        request.setAttribute(Values.PARAM_COMMENTS, comments);

        // Displays the book contents
        request.getRequestDispatcher(Values.JSP_BOOK_INFO_FULL).include(request, response);
    }

    private void updateLastVisited(HttpServletRequest request, Book book){
        
        HttpSession session = request.getSession();
        
        // Creates the array if needed
        Book[] lastVisitedBooks = (Book[]) session.getAttribute(Values.PARAM_LAST_SEEN_BOOKS);
        if(lastVisitedBooks == null){
            lastVisitedBooks = new Book[5];
            session.setAttribute(Values.PARAM_LAST_SEEN_BOOKS, lastVisitedBooks);
        }
        
        // Updates the history
        for(int i = lastVisitedBooks.length - 1; i > 0; i--){
           lastVisitedBooks[i] = lastVisitedBooks[i-1];
        }
        lastVisitedBooks[0] = book;
        
        // Debug code START
        System.out.print("[");
        for(Book b : lastVisitedBooks){
            if(b == null){
                System.out.print(" "+b);
            }
            else{
                System.out.print(" "+b.getTitle());
            }
        }
        System.out.print(" ]");
        // Debug code END
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
}