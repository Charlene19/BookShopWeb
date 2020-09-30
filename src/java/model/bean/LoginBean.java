package model.bean;

import java.io.Serializable;
import model.entity.Customer;
/**
 *
 * @author zvr
 */
public class LoginBean implements Serializable{
    
    private boolean isLogged;
    private Customer customer;

    
    public LoginBean(){
        
    }
    public boolean getIsLogged(){
        return isLogged;
    }
    public void setIsLogged(boolean isLogged){
        this.isLogged = isLogged;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void logout(){
        setIsLogged(false);
        customer = null;
    }
}
