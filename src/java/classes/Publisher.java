package classes;

/***********************************************************************
 * Module:  Author.java
 * Author:  zvr
 * Purpose: Defines the Class Author
 ***********************************************************************/

public class Publisher {
    
   private int id;
   private String name;
   private Address address;
   private String postIt;
   
   public Publisher() {
      
   }
   
   public int getId() {
      return id;
   }
   
   /** @param newId */
   public void setId(int newId) {
      id = newId;
   }
   
   public String getName() {
      return name;
   }
   
   /** @param newName */
   public void setName(String newName) {
      name = newName;
   }
   
   public Address getAddress() {
      return address;
   }
   
   /** @param newAddress */
   public void setAddress(Address newAddress) {
      address = newAddress;
   }
   
   public String getPostIt() {
      return postIt;
   }
   
   /** @param newPostIt */
   public void setPostIt(String newPostIt) {
      postIt = newPostIt;
   }
   
   public String toString() {
      // TODO: implement
      return name;
   }
}