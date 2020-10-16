package util;

import java.util.Comparator;
import model.entity.Book;

/**
 *
 * Use true for ascending order sorting and false for reverse
 * 
 * @author zvr
 */
public class BookSoldComparator implements Comparator<Book> {

        private boolean isAscendingOrder;
        
        public BookSoldComparator(boolean isAscendingOrder){
            this.isAscendingOrder = isAscendingOrder;
        }
        
        public BookSoldComparator(){
            this(true);
        }
        
        @Override
        public int compare(Book book0, Book book1) {
            
            if(isAscendingOrder){
                return book1.getSoldQuantity() - book0.getSoldQuantity();
            }
            
            return book0.getSoldQuantity() - book1.getSoldQuantity();
        }
}