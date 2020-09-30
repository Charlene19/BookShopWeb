package model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    
	private String name; 
	private String date; 
	private String dateFin; 
	private double discount; 
	private String url; 
	public boolean Aurl;
        public Long id;
	public SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
	Date dateF;
	
//, String dateFin
	public Event(){}
        
	public Event (Long id, String name, String date, String dateFin, double discount, String url) {
            this.id = id; 
		this.name = name; this.date = date; this.dateFin = dateFin; this.discount = discount; this.url = url;
		 Aurl = true;
	}
        
        public Event ( String name, String date, String dateFin, double discount, String url) {
           
		this.name = name; this.date = date; this.dateFin = dateFin; this.discount = discount; this.url = url;
		 Aurl = true;
	}
	
	
	public Event (String name, String date, String dateFin, double discount) {
		this.name = name; this.date = date; this.dateFin = dateFin; this.discount = discount; 
	Aurl = false; 
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
	
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	
	public  Date stringToDate(String date) throws Exception { 
	    dateF =formater.parse(date);
	    return dateF ; 
	}
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString() {
		String str = "Event is : " + name + " qui débute : " + date + " qui finit : " + dateFin + ( url != null ? url : ".");
		return str; 
	}
    
	public static void main (String []args) {
		Event e1 = new Event("Rentree","01/09/20","20/09/20"  ,  5.5);
		System.out.println(e1);
	}
}
