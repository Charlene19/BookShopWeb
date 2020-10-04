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
public class Order_Row {
    
private String bookIsbn;
   private int orderQuantity;
   private java.lang.Double orderRowPrice;
   private java.lang.Double orderRowDiscount;
   private int commentId;
   private int orderRowId;
   private int orderId;
   
   
   public Order_Row(){
       
   }
   public Order_Row(int orderRowId, int commentId, int orderId, String bookIsbn, int orderQuantity, Double orderRowPrice,
		Double orderRowDiscount) {
	super();
	this.orderRowId = orderRowId;
	this.commentId = commentId;
	this.orderId = orderId;
	this.bookIsbn = bookIsbn;
	this.orderQuantity = orderQuantity;
	this.orderRowPrice = orderRowPrice;
	this.orderRowDiscount = orderRowDiscount;
}

/** @pdOid 2a699b39-0505-447a-905a-c9e31c4f38a5 */

   public Order_Row(int orderRowId, int commentId, int orderId, String bookIsbn, int orderQuantity, Double orderRowPrice) {
	super();
	this.orderRowId = orderRowId;
	this.commentId = commentId;
	this.orderId = orderId;
	this.bookIsbn = bookIsbn;
	this.orderQuantity = orderQuantity;
	this.orderRowPrice = orderRowPrice;
}

/** @pdOid d7447124-897d-4dc4-b46f-26356e10d431 */

   public Order_Row(int orderRowId, int orderId, String bookIsbn, int orderQuantity, Double orderRowPrice) {
	super();
	this.orderRowId = orderRowId;
	this.orderId = orderId;
	this.bookIsbn = bookIsbn;
	this.orderQuantity = orderQuantity;
	this.orderRowPrice = orderRowPrice;
}
   

   public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public java.lang.Double getOrderRowPrice() {
		return orderRowPrice;
	}

	public void setOrderRowPrice(java.lang.Double orderRowPrice) {
		this.orderRowPrice = orderRowPrice;
	}

	public java.lang.Double getOrderRowDiscount() {
		return orderRowDiscount;
	}

	public void setOrderRowDiscount(java.lang.Double orderRowDiscount) {
		this.orderRowDiscount = orderRowDiscount;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getOrderRowId() {
		return orderRowId;
	}

	public void setOrderRowId(int orderRowId) {
		this.orderRowId = orderRowId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
   
   /** @pdOid 0cdd0874-fd9f-47d6-a6c3-1a6e71459f18 */
   public java.lang.Double calculOrderRow() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 5eb3470d-8fee-4851-a406-3d7fcdbe6b9a */
   public Order_Row getOrderRow() {
      // TODO: implement
      return null;
   }

}
