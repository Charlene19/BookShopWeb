/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Event;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
