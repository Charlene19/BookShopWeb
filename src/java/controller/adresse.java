package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.AddressDAO;
import model.entity.Address;
import model.entity.Customer;
import res.Values;

/**
 *
 * @author jabar
 */
@WebServlet(name = "adresse", urlPatterns = {"/adresse"})
public class adresse extends HttpServlet {

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
            throws ServletException, IOException, SQLException, NamingException {

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        
        // Si le client n'est pas log
        if(customer == null){
            response.sendRedirect(Values.SERVLET_HOME);
            return;
        }
        
        // UNSAFE CAST
        int customerId = Integer.parseInt(""+customer.getCustomerId());
        
        // Si on cherche a ajouter une adresse
        if ("livraison".equals(request.getParameter("action")) || "facturation".equals(request.getParameter("action"))) {
            
            request.setAttribute("type", request.getParameter("action"));
            this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutadresse.jsp").forward(request, response);
            
        }
        // Si on cherche a valider une adresse
        if ("valider".equals(request.getParameter("action"))) {

            // Ajout en base de données
            AddressDAO.insertAddress(request.getParameter("societe"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("rue"), request.getParameter("rue1"), request.getParameter("codepostal"), request.getParameter("ville"), request.getParameter("portable"), "active");

            // Recuperation du dernier ID
            String lastId = "" + AddressDAO.LastId();

            // Si c'est une adresse de facturation
            if ("facturation".equals(request.getParameter("type"))) {
                
                // Ajout de l'adresse dans la base et dans le client
                AddressDAO.insertAddressBilling(""+customerId, lastId);
                customer.setBillingAddresses(AddressDAO.listAddressBillingByIdCustomer(customerId));
                
            } // Si c'est une adresse de livraison
            else if ("livraison".equals(request.getParameter("type"))) {
                
                // Ajout de l'adresse dans la base et dans le client
                AddressDAO.insertAddressDelivry(""+customerId, lastId);                
                customer.setDeliveryAddresses(AddressDAO.listAddressDelivryByIdCustomer(customerId));
            }
        }
        // On affiche les adresses
        List<Address> addressLiv = AddressDAO.listAddressDelivryByIdCustomer(customerId);
        List<Address> addressBil = AddressDAO.listAddressBillingByIdCustomer(customerId);
        
        request.setAttribute("addressLiv", addressLiv);
        request.setAttribute("addressBil", addressBil);

        this.getServletContext().getRequestDispatcher("/WEB-INF/adresseC.jsp").forward(request, response); 
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(adresse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(adresse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(adresse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(adresse.class.getName()).log(Level.SEVERE, null, ex);
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
