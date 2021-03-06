package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import model.bean.LoginBean;
import model.dao.CustomerDAO;
import model.entity.Customer;

import res.Values;

/**
 *
 * @author zvr
*/
@WebServlet(urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {

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
        
        CustomerDAO customerDAO = new CustomerDAO();

        String errorMessage = "";

        String email = "";
        String password = "";

        email = request.getParameter("email");
        password = request.getParameter("password");

        HttpSession session = request.getSession();
        // This bean is used to check if the user is logged or not and stores
        // all its information
        LoginBean loginBean = (LoginBean) session.getAttribute(Values.BEAN_LOGIN_NAME);
        if (loginBean == null) {
            loginBean = new LoginBean();
                session.setAttribute(Values.BEAN_LOGIN_NAME, loginBean);
        }

        // If the user wants to logout
        if(Values.ACTION_LOGOUT.equals(request.getParameter(Values.PARAM_ACTION))){

            // Logging the user out
            loginBean.logout();
            session.removeAttribute(Values.PARAM_CUSTOMER);
            session.removeAttribute(Values.BEAN_LOGIN_NAME);
            session.removeAttribute(Values.BEAN_ORDER_VALIDATION_NAME);
            
            // Going back to homepage
            response.sendRedirect(Values.SERVLET_HOME);
            return;
        }
        // If the user is logged already
        if (loginBean.getIsLogged()) {

            String url = Values.JSP_ACCOUNT;

            if (request.getAttribute(Values.PARAM_ORIGIN) != null) {
                url = (String) session.getAttribute(Values.PARAM_ORIGIN);
            }
            // Displaying Account page
            response.sendRedirect(url);
            return;
        }
        // If the user is coming from another page
        if(!Values.ACTION_LOGIN.equals(request.getParameter(Values.PARAM_ACTION))){

            // Displaying Login page
            //request.getRequestDispatcher(Values.JSP_LOGIN).include(request, response);
            request.getRequestDispatcher(Values.JSP_LOGIN_FULL).include(request, response);
            return;
        }

        try {
            Customer customer = customerDAO.getByUsername(email, password);
            // If login is invalid ( incorrect username/password )
            if(customer == null){
                errorMessage += Values.ERROR_INVALID_LOGIN;
            }
            // If login OK
            else{
                loginBean.setIsLogged(true);
                loginBean.setCustomer(customer);
                session.setAttribute(Values.BEAN_LOGIN_NAME, loginBean);
                session.setAttribute(Values.PARAM_CUSTOMER, customer);

                
                if(session.getAttribute(Values.PARAM_ORIGIN) != null){
                    response.sendRedirect((String) session.getAttribute(Values.PARAM_ORIGIN));
                }
                // Displaying Account page
                else{
                    response.sendRedirect(Values.JSP_ACCOUNT);
                }
                return;
            }

        } catch (NamingException ex) {
            errorMessage += ex.getMessage();
        } catch (SQLException ex) {
            errorMessage += ex.getMessage();
        } catch (NoSuchAlgorithmException ex) {
            errorMessage += ex.getMessage();
        } catch (UnsupportedEncodingException ex) {
            errorMessage += ex.getMessage();
        }

        
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("error_message", errorMessage);

        request.getRequestDispatcher("/WEB-INF/dlogin.jsp").include(request, response);
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
