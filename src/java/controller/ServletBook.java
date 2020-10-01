package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
 * @author zvr
 */
@WebServlet(urlPatterns = {"/book"})
public class ServletBook extends HttpServlet {

    public final String JSP_HOME = "/WEB-INF/home.jsp";
    public final String JSP_BOOK = "/WEB-INF/book_info.jsp";

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

        // Book comments go inside this collection
        Collection<Object> comments = new ArrayList<>();
        
        // This contains the book to be displayed
        request.setAttribute(Values.PARAM_BOOK, book);
        
        // This contains the comments related to this books
        request.setAttribute(Values.PARAM_COMMENTS, comments);
        
        // Displays the book contents
        request.getRequestDispatcher(JSP_BOOK).include(request, response);
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