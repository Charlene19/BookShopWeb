package controller;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.ShoppingCartBean;
import model.dao.BookDAO;
import model.entity.Book;
import res.Values;

/**
 *
 * @author maybe
 */
@WebServlet(urlPatterns = {"/shoppingcart"})
public class ServletShoppingCart extends HttpServlet {

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
        
        BookDAO bookDAO = new BookDAO();
        Book book = null;
        String isbn = "";
        boolean isEmpty = true;
        String errorMessage = "";
        String message = "";
                
        HttpSession session = request.getSession();
        book = (Book) request.getAttribute(Values.PARAM_BOOK);
        isbn = request.getParameter(Values.PARAM_ISBN);
        Collection<Book> books;
        
        // This bean contains the shopping carts ( books )
        ShoppingCartBean shoppingcartBean = (ShoppingCartBean) session.getAttribute(Values.BEAN_SHOPPING_CART_NAME);
        if (shoppingcartBean == null) {
            shoppingcartBean = new ShoppingCartBean();
                session.setAttribute(Values.BEAN_SHOPPING_CART_NAME, shoppingcartBean);
        }
        books = shoppingcartBean.getBooks();
        
        // If the user adds a new book
        if(Values.ACTION_ADD_BOOK.equals(request.getParameter(Values.PARAM_ACTION))){
            isbn = request.getParameter(Values.PARAM_ISBN);
            
            try {
                shoppingcartBean.add(bookDAO.getById(isbn));
                book = shoppingcartBean.getBook(isbn);
                message = String.format(Values.MSG_BOOK_ADDED, book.getTitle());
            } catch (Exception ex) {
                request.setAttribute(Values.PARAM_ERROR_MSG, ex.getMessage());
                request.getRequestDispatcher(Values.JSP_ERROR).include(request, response);
                return;
            }
        }
        
        if(isbn == null || isbn.isEmpty()){
            
        }
        // If the user increase by 1 book
        else if(Values.ACTION_INC_BOOK.equals(request.getParameter(Values.PARAM_ACTION))){
            book = shoppingcartBean.getBook(isbn);
            shoppingcartBean.increment(isbn);
            message = String.format(Values.MSG_BOOK_QTY_CHANGED, book.getTitle(), book.getCartQuantity());
        }
        // If the user decreases by 1 book
        else if(Values.ACTION_DEC_BOOK.equals(request.getParameter(Values.PARAM_ACTION))){
            book = shoppingcartBean.getBook(isbn);
            shoppingcartBean.decrement(isbn);
            message = String.format(Values.MSG_BOOK_QTY_CHANGED, book.getTitle(), book.getCartQuantity());
        }
        // If the user removes a book
        else if(Values.ACTION_DEL_BOOK.equals(request.getParameter(Values.PARAM_ACTION))){
            book = shoppingcartBean.getBook(isbn);
            shoppingcartBean.remove(isbn);
            message = String.format(Values.MSG_BOOK_REMOVED, book.getTitle());
        }
        
        // If the user clears the cart
        if(Values.ACTION_EMPTY_CART.equals(request.getParameter(Values.PARAM_ACTION))){
            shoppingcartBean.clear();
            message = String.format(Values.MSG_CART_CLEARED);
        }
        // If the user wants to order
        if(Values.ACTION_CREATE_ORDER.equals(request.getParameter(Values.PARAM_ACTION))){
            response.sendRedirect("ordervalidation");
            return;
        }
        
        isEmpty = shoppingcartBean.isEmpty();
        // If the cart is empty
        if(shoppingcartBean.isEmpty()){
            message = Values.ERROR_EMPTY_CART;
        }
        
        request.setAttribute(Values.PARAM_ERROR_MSG, errorMessage);
        request.setAttribute(Values.PARAM_MSG, message);
        request.setAttribute("books", books);
        request.setAttribute("isEmpty", isEmpty);
        
        // If an action has been made this will prevent data to be resent
        if(request.getParameter(Values.PARAM_ACTION) != null){
            response.sendRedirect("shoppingcart");
        }
        else{
            request.getRequestDispatcher(Values.JSP_SHOPPING_CART_FULL).forward(request, response);
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
}