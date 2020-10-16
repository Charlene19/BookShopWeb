package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.LoginBean;
import model.bean.OrderValidationBean;
import model.bean.ShoppingCartBean;
import model.dao.OrderDAO;
import model.dao.Order_RowDAO;
import model.entity.Book;
import model.entity.Customer;
import model.entity.Order;
import model.entity.Order_Row;
import model.entity.ShippingOffer;
import res.Values;
import model.dao.OrderDAO;

/**
 *
 * @author zvr
 */
@WebServlet(urlPatterns = {"/ordervalidation"})
public class ServletOrderValidation extends HttpServlet {

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
        
        String errorMessage = "";
        String message = "";
        
        HttpSession session = request.getSession();
        
        LoginBean loginBean = (LoginBean) session.getAttribute(Values.BEAN_LOGIN_NAME);
        ShoppingCartBean shoppingcartBean = (ShoppingCartBean) session.getAttribute(Values.BEAN_SHOPPING_CART_NAME);

        // If the user chooses to go back to cart
        if (Values.ACTION_GOTO_CART.equals(request.getParameter(Values.PARAM_ACTION))) {
            response.sendRedirect("shoppingcart");
        } 
        // If the cart is empty
        else if (shoppingcartBean == null || shoppingcartBean.isEmpty()) {
            errorMessage = "Aucun livre disponible";
            response.sendRedirect("shoppingcart");
            return;
        } 
        // If the user is not logged in
        else if (loginBean == null || !loginBean.getIsLogged()) {
            
            // Sends a message for display and prompts the user to log in
            request.setAttribute(Values.PARAM_MSG, Values.MSG_LOGIN_TO_ORDER);
            session.setAttribute(Values.PARAM_ORIGIN, "ordervalidation");
            request.getRequestDispatcher("login").include(request, response);
            return;
        }
        // Creates or retreive the order validation bean
        OrderValidationBean orderValidationBean = (OrderValidationBean) session.getAttribute(Values.BEAN_ORDER_VALIDATION_NAME);
        if (orderValidationBean == null || orderValidationBean.isIsOver()) {
            
            orderValidationBean = new OrderValidationBean();
            orderValidationBean.setBooks(shoppingcartBean.getBooks());
            orderValidationBean.setCustomer((Customer) session.getAttribute("customer"));
            
            // Putting the bean into the session
            session.setAttribute(Values.BEAN_ORDER_VALIDATION_NAME, orderValidationBean);
            
        }
        orderValidationBean.setBooks(shoppingcartBean.getBooks());

        // If the order has been validated already
        if (orderValidationBean.isValidated()) {
            message = "commande deja validée";
            request.setAttribute(Values.PARAM_ERROR_MSG, errorMessage);
            request.setAttribute(Values.PARAM_MSG, message);
            request.getRequestDispatcher(Values.JSP_ERROR).forward(request, response);
        }
        // If the user chooses to validate the order
        else if (Values.ACTION_CREATE_ORDER.equals(request.getParameter(Values.PARAM_ACTION))) {
            
            try {
                
                // Checks if the books are still available in the database
                if(!orderValidationBean.isOrderPossible()){
                    errorMessage = "La commande ne peux pas etre effectuée ( quantité en stock insuffisante )";
                    request.setAttribute(Values.PARAM_ERROR_MSG, errorMessage);
                    request.setAttribute(Values.PARAM_MSG, message);
                    request.getRequestDispatcher(Values.JSP_ERROR).forward(request, response);
                }
                
                // Creates the order
                Order order = new Order();
                
                order.setCustomer(loginBean.getCustomer());
                order.setDateOrder("2020-10-12T00:00:00");
                order.setAdresseBilId(Integer.parseInt(request.getParameter("billing_address")));
                order.setAdresseLivId(Integer.parseInt(request.getParameter("delivery_address")));
                order.setIpCustomer("0.0.0.0");
                order.setCommentaire("");
                order.setIdcustomer(Integer.parseInt(""+loginBean.getCustomer().getCustomerId()));
                
                HashMap<Long, ShippingOffer> shippingOffers = new HashMap<>();
                for (ShippingOffer offer : orderValidationBean.getGenericShippingOffers()) {
                    
                    shippingOffers.put(offer.getShippingOfferId(), offer);
                    orderValidationBean.setShippingOffers(shippingOffers);
                }
                
                // UNSAFE CAST !!
                order.setShippingId(Integer.parseInt(request.getParameter("shipping_offer")));
                order.setPriceTaxFree(orderValidationBean.getShippingOfferById(Long.parseLong(request.getParameter("shipping_offer"))).getShippingOfferHtPrice());
                
                // Puts the order into the bean
                orderValidationBean.setOrder(order);
                
                request.getRequestDispatcher("ServletPay").forward(request, response);
                
            } catch (NamingException ex) {
                Logger.getLogger(ServletOrderValidation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ServletOrderValidation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ServletOrderValidation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // If the payment has been validated
        else if(Values.ACTION_YES.equals(request.getParameter(Values.PARAM_ACTION))) {
            
             try {
                
                orderValidationBean.setCustomer((Customer) session.getAttribute(Values.PARAM_CUSTOMER));
                if (validateOrder(orderValidationBean, shoppingcartBean, request)) {
                    
                    // Removes the bean and clears the shopping cart
                    session.removeAttribute(Values.BEAN_ORDER_VALIDATION_NAME);
                    shoppingcartBean.clear();
                    
                    message = "commande validée";
                    request.setAttribute(Values.PARAM_MSG, message);
                    request.getRequestDispatcher(Values.JSP_INFO).forward(request, response);
                }
                else {
                    errorMessage = "La commande n'a pu etre validée";
                    request.setAttribute(Values.PARAM_ERROR_MSG, errorMessage);
                    request.setAttribute(Values.PARAM_MSG, message);
                    request.getRequestDispatcher(Values.JSP_ERROR).forward(request, response);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(ServletOrderValidation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // If the payment has been refused
        else if(Values.ACTION_NO.equals(request.getParameter(Values.PARAM_ACTION))) {
            
            errorMessage = "Le paiement à été refusé";
            request.setAttribute(Values.PARAM_ERROR_MSG, errorMessage);
            request.setAttribute(Values.PARAM_MSG, message);
            request.getRequestDispatcher(Values.JSP_ERROR).forward(request, response);
        }
        
        request.setAttribute(Values.PARAM_ERROR_MSG, errorMessage);
        request.setAttribute(Values.PARAM_MSG, message);
        
        request.getRequestDispatcher(Values.JSP_ORDER_VALIDATION_FULL).include(request, response);
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
    
    private boolean validateOrder(OrderValidationBean orderBean, ShoppingCartBean cartBean, HttpServletRequest request) throws Exception {

        // Gets the order
        Order order = orderBean.getOrder();
        OrderDAO orderDAO = new OrderDAO(); 
       
      
        // Adds the order into the DB
        new OrderDAO().add(order);
        order.setId(new OrderDAO().getLastId());
        orderDAO.setStatusOrder(order); 
         
        Order_Row orderRow;
        // Creates an order row for each book
        for (Book book : orderBean.getBooks()) {
            
            orderRow = new Order_Row();
            // UNSAFE CAST
            orderRow.setOrderId(Integer.parseInt("" + order.getId()));
            orderRow.setBookIsbn(book.getIsbn());
            orderRow.setOrderQuantity(book.getCartQuantity());
            // UNSAFE CAST
            orderRow.setOrderRowPrice(Double.parseDouble("" + book.getPrice()));
            new Order_RowDAO(0).add(orderRow);
        }
        
        return true;
    }
}
