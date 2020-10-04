/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import model.entity.Book;
import model.entity.Order;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.dao.BookDAO;
import model.dao.OrderDAO;

/**
 *
 * @author cda611
 */
public class beanOrder implements Serializable {

    List<Book> books;

    public beanOrder() {
      
    }

    public boolean validateOrder() {
        //doit retourner un booléen pour valider la commande
        return false;
    }

    public Order getOrder() {

        return new Order();
    }

    public List<Book> orderLastMonth(Long id) throws SQLException, NamingException {

        books = new OrderDAO().getListLast(id);
        return books;

    }

    public List<Book> orderSixMonth(Long id) throws SQLException, NamingException {

        books = new OrderDAO().getListSixMonth(id);
        return books;

    }

    public List<Book> pastOrder(Long id) throws SQLException, NamingException {

        books = new OrderDAO().getListPast(id);
        return books;

    }

    public List<Book> allOrder(Long id) throws SQLException, NamingException {
 id = 2l;
        books = new OrderDAO().getList(id);
        return books;

    }
    
    public List<Book> getListById(String id) throws SQLException, NamingException{
        books = new OrderDAO().getListById(id); 
        return books;
    }

    public List unachieveOrder() {

        //retourne les commandes n'ayant pas un statut livré du client
        return new ArrayList<Order>();
    }
    
    
}
