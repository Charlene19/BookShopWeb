package model.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import model.entity.Book;
/**
 *
 * @author zvr
 */
public class ShoppingCartBean implements Serializable{
    
    private String totalPriceText;
    private String totalFullPriceText;
    
    private HashMap<String,Book> books;

    public ShoppingCartBean(){
        books = new HashMap<>();
    }
    
    // Rounds a float by 2 decimals ( 15.56 )
    private String roundFloat(float value) {
        return String.format("%.02f", value);
    }
    
    public Book getBook(String isbn){
        return books.get(isbn);
    }
    
    // Add a new book into the cart
    public void add(Book book){
        // If the book isnt in the map - add it
        if(!books.containsKey(book.getIsbn())){
            books.put(book.getIsbn(), book);
            setQuantity(book.getIsbn(), 1);
        }
        else{
            increment(book.getIsbn());
        }
    }
    
    // Set book's quantity manually
    public void setQuantity(String isbn, int quantity) {

        // If the quantity is greater than the stock
        if(quantity > books.get(isbn).getQuantity()){
            return;
        }
            
        // Sets the book quantity to the specified value
        books.get(isbn).setCartQuantity(quantity);
        
        // If the quantity reaches 0
        if(getQuantity(isbn) <= 0){
            remove(isbn);
        }
    }
    // Increases book's quantity by 1
    public void increment(String isbn){
        setQuantity(isbn, getQuantity(isbn) + 1);
    }
    
    // Decreases book's quantity by 1
    public void decrement(String isbn){
        setQuantity(isbn, getQuantity(isbn) - 1);
    }
    
    // Removes a book from the shopping cart
    public void remove(String isbn){
        books.remove(isbn);
    }
    
    public void clear(){
        books.clear();
    }
    
    // Returns all books in cart
    public Collection<Book> getBooks(){
        return books.values();
    }
    
    // Returns book's quantity for a given book
    public int getQuantity(String isbn){
        
        if(books.containsKey(isbn)){
            return getBook(isbn).getCartQuantity();
        }
        return 0;
    }
    
    // Returns total "HT" price for all the cart
    public float getTotalPrice(){
        
        float price = 0;
        
        for(Book book : books.values()){
            price += book.getPrice() * book.getCartQuantity();
        }
        return price;
    }
    
    // Returns total "TTC" price for all the cart
    public float getTotalFullPrice(){
        
        float price = 0;
        
        for(Book book : books.values()){
            price += book.getTPrice() * book.getCartQuantity();
        }
        return price;
    }
    
    public String getTotalPriceText(){
        return roundFloat(getTotalPrice());
    }

    public String getTotalFullPriceText() {
        return roundFloat(getTotalFullPrice());
    }
    
    
    
    // Returns true if the shopping cart is empty
    public boolean isEmpty(){
        return books.isEmpty();
    }
}
