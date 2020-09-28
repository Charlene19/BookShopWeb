/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Order;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cda611
 */
public class beanOrder implements Serializable {
    
   
    
    public beanOrder() {    
    }
    
    public boolean validateOrder(){
        //doit retourner un booléen pour valider la commande
        return false;
    }
    
    public Order getOrder(){
        
        return new Order(); 
    }
    
    public List allOrder(){
        
        //retourne toutes les commandes du client
        return new ArrayList<Order>();
    }
    
    public List unachieveOrder(){
        
        //retourne les commandes n'ayant pas un statut livré du client
        return new ArrayList<Order>(); 
    }
}
