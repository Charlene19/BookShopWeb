

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Customer;
import res.Values;


@WebServlet(urlPatterns = {"/servletId"})
public class ServletIdModif extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute(Values.PARAM_CUSTOMER);
        
        String customerId = (String) session.getAttribute("email");
            
        try (PrintWriter out = response.getWriter()) {
            String lName = request.getParameter("lName");
            String fName = request.getParameter("fName");
            String pseudo = request.getParameter("pseudo");
            String newPassword = request.getParameter("newPassword");
            String newPasswordConf = request.getParameter("newPasswordConf");
            
            if (newPassword.isEmpty() || lName.isEmpty() || fName.isEmpty() || pseudo.isEmpty() || newPasswordConf.isEmpty()) {
                out.println("Veuillez remplir les champs obligatoires");
            } else if (newPassword != newPasswordConf) {
                    out.println("rztertze");
                }
            else {
                    RequestDispatcher req = request.getRequestDispatcher("/account.html");
               req.forward(request, response);
            }
        } 
        
                    out.println("</body>");
            out.println("</html>");
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
