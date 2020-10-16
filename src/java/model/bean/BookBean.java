package model.bean;

import java.io.Serializable;
import model.entity.Book;

/**
 *
 * @author zvr
 */
public class BookBean implements Serializable {

    // "HT" price for 1
    private String priceText;
    
    // "TTC" price for 1
    private String fullPriceText;
    
    // "HT" price for all
    private float priceTotal;
    private String priceTotalText;
    
    // "TTC" price for all
    private float fullPriceTotal;
    private String fullPriceTotalText;

    private Book book;

    public BookBean() {

    }

    // Rounds a float by 2 decimals ( 15.56 )
    private String roundFloat(float value) {
        return String.format("%.02f", value);
    }

    // Returns "HT" price for 1 book in text format
    public String getPriceText() {
        return roundFloat(book.getPrice());
    }

    // Returns "TTC" price for 1 book
    public String getFullPriceText() {
        return roundFloat(book.getTPrice());
    }

    public float getPriceTotal() {
        return book.getPrice() * book.getCartQuantity();
    }

    public String getPriceTotalText() {
        return roundFloat(getPriceTotal());
    }

    public float getFullPriceTotal() {
        return book.getTPrice() * book.getCartQuantity();
    }

    public String getFullPriceTotalText() {
        return roundFloat(getFullPriceTotal());
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    public String getDiscountFullPriceText(float discount){
        return roundFloat (book.getPriceT() - discount * book.getPriceT() / 100);
    }
}
