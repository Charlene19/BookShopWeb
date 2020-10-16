/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.beans.*;
import java.io.Serializable;
import java.sql.SQLException;
import model.dao.CommentDAO;

/**
 *
 * @author cda611
 */
public class beanComment implements Serializable {
    

      private boolean isAuthComment; 
 
    public beanComment() {
       
    }

    public boolean isIsAuthComment() {
        return isAuthComment;
    }

    public void setIsAuthComment(boolean isAuthComment) {
        this.isAuthComment = isAuthComment;
    }
     
    
}
