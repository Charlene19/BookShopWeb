/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.dao.BookDAO;
import model.entity.Event;

/**
 *
 * @author cda611
 */
public class beanEvent implements Serializable {
    
    public beanEvent() {
      
    }
    
    
    
    public List returnlBook(){

        return new ArrayList();
    }
    
    public double getRemise(){
       //doit retourner ou une remise ou le prix du livre à déterminer. 
        
        return 0.0;
    }
    
    public Event getEvent(){
        
        return new Event();
    }
}
