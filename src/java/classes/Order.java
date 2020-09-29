/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author cda611
 */
public class Order {

  private Long id;
    private Long customerId;
    int id2; 
    int customerId2;
    private Customer customer; 
    private Address adresseLiv;
    private Address adresseBil;
    private ShippingOffer shipping; 
    private String dateOrder; 
    private String dateLivraison; 
    private String ipCustomer; 
    private String commentaire; 
    private double priceTaxFree;
    private Order order;
    private String orderStatus;
    private int Idcustomer;
    private int shippingId;
     private int adresseLivId;
    private int adresseBilId;
    
    public Order() {	
    }
    
    public Order(Long id) {
    	this.id = id;
    }
 
    public Order(Long id, Customer customer, Address adresseLiv, Address adresseBil, ShippingOffer shipping, String dateOrder, String dateLivraison, String ipCustomer, String commentaire, double priceTaxFree) {
        this.id = id;
        this.customer = customer;
        this.adresseLiv = adresseLiv;
        this.adresseBil = adresseBil;
        this.shipping = shipping;
        this.dateOrder = dateOrder;
        this.dateLivraison = dateLivraison;
        this.ipCustomer = ipCustomer;
        this.commentaire = commentaire;
        this.priceTaxFree = priceTaxFree;
    }
    

    public Order(Long id, int Idcustomer, int adresseLivId, int adresseBilId, int shippingId, String dateOrder, String dateLivraison, String ipCustomer, String commentaire, double priceTaxFree) {
        this.id = id;
        this.Idcustomer = Idcustomer;
        this.adresseLivId = adresseLivId;
        this.adresseBilId = adresseBilId;
        this.shippingId = shippingId;
        this.dateOrder = dateOrder;
        this.dateLivraison = dateLivraison;
        this.ipCustomer = ipCustomer;
        this.commentaire = commentaire;
        this.priceTaxFree = priceTaxFree;
    }
    
    public Order (int id2,     int customerId2, String dateOrder, String commentaire){
        
        this.id2 = id2;
        this.customerId2 = customerId2; 
        this.dateOrder = dateOrder; 
        this.commentaire = commentaire;
    }
    
    public Order (Long id, Long customerId, String dateOrder, String commentaire){
        
        this.id = id;
        this.customerId = customerId; 
        this.dateOrder = dateOrder; 
        this.commentaire = commentaire;
    }
    public Order (Long id, Long customerId, String dateOrder, String commentaire, String orderStatus){
        
        this.id = id;
        this.customerId = customerId; 
        this.dateOrder = dateOrder; 
        this.commentaire = commentaire;
        this.orderStatus = orderStatus;
    }
    
    public Order(Long id, Long customerId, String dateOrder, String dateLivraison, double priceTaxFree) {
        this.id = id;
        this.customerId = customerId;
        this.dateOrder = dateOrder;
        this.dateLivraison = dateLivraison;
        this.priceTaxFree = priceTaxFree;
    }
    
    public Order(int id2, int customerId2, String dateOrder, String dateLivraison, double priceTaxFree) {
        this.id2 = id2;
        this.customerId2 = customerId2;
        this.dateOrder = dateOrder;
        this.dateLivraison = dateLivraison;
        this.priceTaxFree = priceTaxFree;
    }
    
    
      public Order( Customer customer, Address adresseLiv, Address adresseBil, ShippingOffer shipping, String dateOrder, String dateLivraison, String ipCustomer, String commentaire, double priceTaxFree) {
    
        this.customer = customer;
        this.adresseLiv = adresseLiv;
        this.adresseBil = adresseBil;
        this.shipping = shipping;
        this.dateOrder = dateOrder;
        this.dateLivraison = dateLivraison;
        this.ipCustomer = ipCustomer;
        this.commentaire = commentaire;
        this.priceTaxFree = priceTaxFree;
    }
    
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
      public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public int getAdresseLivId() {
        return adresseLivId;
    }

    public void setAdresseLivId(int adresseLivId) {
        this.adresseLivId = adresseLivId;
    }

    public int getAdresseBilId() {
        return adresseBilId;
    }

    public void setAdresseBilId(int adresseBilId) {
        this.adresseBilId = adresseBilId;
    }

    
    public Long getCustomerId() {
    	
		return customerId;
    	
    }

    public int getIdcustomer() {
        return Idcustomer;
    }

    public void setIdcustomer(int Idcustomer) {
        this.Idcustomer = Idcustomer;
    }
    
    
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public Address getAdresseLiv() {
        return adresseLiv;
    }

    public void setAdresseLiv(Address adresseLiv) {
        this.adresseLiv = adresseLiv;
    }

    public Address getAdresseBil() {
        return adresseBil;
    }

    public void setAdresseBil(Address adresseBil) {
        this.adresseBil = adresseBil;
    }

    public ShippingOffer getShipping() {
        return shipping;
    }

    public void setShipping(ShippingOffer shipping) {
        this.shipping = shipping;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getIpCustomer() {
        return ipCustomer;
    }

    public void setIpCustomer(String ipCustomer) {
        this.ipCustomer = ipCustomer;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public double getPriceTaxFree() {
        return priceTaxFree;
    }

    public void setPriceTaxFree(double priceTaxFree) {
        this.priceTaxFree = priceTaxFree;
    }
    
    public Order getOrder() {
    	return order;
    }
    
  @Override
    public String toString() {
    	return this.getId() + " " + getCustomer() + " " ;
    }
   
    
}


