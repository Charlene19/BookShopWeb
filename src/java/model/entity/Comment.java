/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;


/**
 *
 * @author cda611
 */
/***********************************************************************
 * Module:  Commentaire.java
 * Author:  cda611
 * Purpose: Defines the Class Commentaire
 ***********************************************************************/

import java.util.*;

/** Représente le commentaire laissé par un client
 * 
 * @pdOid 3c6342df-8372-4c5f-9da1-97b4bfcd0a30 */
public class Comment {
   
    
   public long commId;
   public long customerId;
   public long orderId; 
   public String isbnBook;
   public java.lang.String commTitre;
   public int commNote;
   public java.lang.String commTxt;
   public String commDate;
   public java.lang.String commIp;

    public long getCommId() {
        return commId;
    }

    public void setCommId(long commId) {
        this.commId = commId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getIsbnBook() {
        return isbnBook;
    }

    public void setIsbnBook(String isbnBook) {
        this.isbnBook = isbnBook;
    }

    public String getCommTitre() {
        return commTitre;
    }

    public void setCommTitre(String commTitre) {
        this.commTitre = commTitre;
    }

    public int getCommNote() {
        return commNote;
    }

    public void setCommNote(int commNote) {
        this.commNote = commNote;
    }

    public String getCommTxt() {
        return commTxt;
    }

    public void setCommTxt(String commTxt) {
        this.commTxt = commTxt;
    }

    public String getCommDate() {
        return commDate;
    }

    public void setCommDate(String commDate) {
        this.commDate = commDate;
    }

    public String getCommIp() {
        return commIp;
    }

    public void setCommIp(String commIp) {
        this.commIp = commIp;
    }
   
   

}
