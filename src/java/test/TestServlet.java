/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.AddressDAO;
import model.dao.CustomerDAO;
import model.entity.Address;
import model.entity.Customer;
import util.HashUtil;

/**
 *
 * @author User
 */
public class TestServlet extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");

            Customer customer = new CustomerDAO().getByUsername("test", "2002");
            
            //List<Address> deliveryAddresses = AddressDAO.listDeliveryAddressByIdCustomer(7);
            //List<Address> billingAddresses = AddressDAO.listBillingAddressByIdCustomer(7);

            for (Address address : customer.getDeliveryAddresses()) {
                System.out.println("del : " + address);
            }

            for (Address address : customer.getBillingAddresses()) {
                System.out.println("bil : " + address);
            }
            /*
             try {
             addCustomer();
             } catch (NoSuchAlgorithmException ex) {
             Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
             } catch (UnsupportedEncodingException ex) {
             Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
             }
             testHash();
             */
        } catch (SQLException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void testHash() {

        try {

            String pass = "password";
            String hashedPass = hashText(pass);

            System.err.println("Clear : " + pass);
            System.out.println("MD5   : " + hashedPass);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String hashText(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        if (text == null) {
            return null;
        }

        String hashedText = "";

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytesHash = messageDigest.digest(text.getBytes("UTF-8"));

        for (byte b : bytesHash) {
            hashedText += String.valueOf(String.format("%02x", b));
        }
        return hashedText;
    }

    private static void addCustomer() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        CustomerDAO customerDAO = new CustomerDAO();

        // The customer to insert
        Customer customer = new Customer();

        customer.setCustomerFName("az");
        customer.setCustomerLName("az");
        customer.setCustomerUsername("sa");
        customer.setCustomerPassword(new HashUtil().hashText("123mail"));
        customer.setCustomerEmail("mail");

        try {
            customerDAO.add(customer);

        } catch (NamingException ex) {
            System.out.println("Naming exception: " + ex);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
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
