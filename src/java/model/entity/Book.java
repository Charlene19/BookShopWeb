

package model.entity;

/**
 *****************************************************************
 * Module: Book.java Author: ZVR Purpose: Defines the Class Book *
 * ****************************************************************
 */
import java.io.Serializable;
import java.util.*;

public class Book implements Serializable {

    private String isbn;
    private String title;
    private String subTitle;
    private int quantity;
    private int soldQuantity;
    private int cartQuantity;
    private float price;
    private Vat vat;
    private Publisher publisher;
    private String shelf;
    private String coverURL;
    private String postIt;
    private String summary;
    private List<Category> categories;
    private List<Author> authors;
    private List<Keyword> keywords;
    private List<BookStatusAssoc> statuses;
    private float priceT;

    public Book() {
        // TODO: implement
    }

    public String getIsbn() {
        return isbn;
    }

    /**
     * @param newIsbn
     */
    public void setIsbn(String newIsbn) {
        isbn = newIsbn;
    }

    public String getTitle() {
        return title;
    }

    /**
     * @param newTitle
     */
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    /**
     * @param newSubTitle
     */
    public void setSubTitle(String newSubTitle) {
        subTitle = newSubTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public float getTPrice(){
        priceT = price + price * (vat.getRate() / 100);
        return priceT;
    }

     public float getPriceT(){
        priceT = price + price * (vat.getRate() / 100);
        return priceT;
    }
    /**
     * @param newPrice
     */
    public void setPrice(float newPrice) {
        price = newPrice;
    }

    public Vat getVat() {
        return vat;
    }

    /**
     * @param newVat
     */
    public void setVat(Vat newVat) {
        vat = newVat;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    /**
     * @param newPublisher
     */
    public void setPublisher(Publisher newPublisher) {
        publisher = newPublisher;
    }

    public String getShelf() {
        return shelf;
    }

    /**
     * @param newShelf
     */
    public void setShelf(String newShelf) {
        shelf = newShelf;
    }

    public String getCoverURL() {
        return coverURL;
    }

    /**
     * @param newCoverURL
     */
    public void setCoverURL(String newCoverURL) {
        coverURL = newCoverURL;
    }

    public String getPostIt() {
        return postIt;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @param newPostIt
     */
    public void setPostIt(String newPostIt) {
        postIt = newPostIt;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public List<BookStatusAssoc> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<BookStatusAssoc> statuses) {
        this.statuses = statuses;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String toString() {
        return isbn+" - "+title+" - "+subTitle;
    }

    /**
     * BookStatus that holds the assocDate and a comment when it was associated
     * to a book
     */
    public static class BookStatusAssoc extends BookStatus {

        private String assocDate;
        private String assocPostIt;

        public BookStatusAssoc() {

        }

        public BookStatusAssoc(BookStatus bookStatus) {
            setId(bookStatus.getId());
            setName(bookStatus.getName());

        }

        public String getAssocDate() {
            return assocDate;
        }

        public void setAssocDate(String assocDate) {
            this.assocDate = assocDate;
        }

        public String getAssocPostIt() {
            return assocPostIt;
        }

        public void setAssocPostIt(String assocPostIt) {
            this.assocPostIt = assocPostIt;
        }
    }
}

