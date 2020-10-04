package model.entity;

import java.text.SimpleDateFormat;
import java.util.*;

/** @pdOid aee2cd64-c487-4c32-9b82-d6a667e119c1 */
public class Package {
   /** @pdOid 6e64f4d1-057a-4c99-9b7f-4ac20d217153 */
   /** @pdOid 6e64f4d1-057a-4c99-9b7f-4ac20d217153 */
   private Long id;
   /** @pdOid 80d2e4fd-da15-463b-86ea-d2983ce2d745 */
   private String tracker;
   /** @pdOid 9e147f37-8e35-4281-b334-a01c7be684a9 */
   private String dateLivraison;
   /** @pdOid d81be937-5c97-467d-8064-8aef80506232 */
   private String postIt;
	public SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
	Date dateF;
   
	
public Package (Long id, String tracker, String dateLivraison) {
	this.id = id; this.tracker = tracker; this.dateLivraison = dateLivraison;
}

public Package (Long id, String tracker, String dateLivraison, String postIt) {
	this.id = id; this.tracker = tracker; this.dateLivraison = dateLivraison; this.postIt = postIt;
}

public Package ( String tracker, String dateLivraison) {
	 this.tracker = tracker; this.dateLivraison = dateLivraison;
}

public Package ( String tracker, String dateLivraison, String postIt) {
	 this.tracker = tracker; this.dateLivraison = dateLivraison; this.postIt = postIt;
}

public Long getId() {
	return id;
}

public String getTracker() {
	return tracker;
}
public void setTracker(String tracker) {
	this.tracker = tracker;
}
public String getDateLivraison() {
	return dateLivraison;
}
public void setDateLivraison(String dateLivraison) {
	this.dateLivraison = dateLivraison;
}
public String getPostIt() {
	return postIt;
}
public void setPostIt(String postIt) {
	this.postIt = postIt;
}
public  Date stringToDate(String date) throws Exception { 
    dateF =formater.parse(date);
    return dateF ; 
}

public String toString() {
	String str; 
	str = tracker + " " + dateLivraison + " " + (postIt != null ? postIt : "");
	return str;
}

}