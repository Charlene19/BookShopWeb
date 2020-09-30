package model.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import model.dao.BookDAO;
import model.entity.Book;

/**
 *
 * @author zvr
 */
public class BookBean implements Serializable {

    
    public BookBean(){
        
    }
    
    public boolean isBookAvailable(Book book){
        return true;
    }
    
    public List<Book> search(String search) throws NamingException, SQLException{
        
        List<Book> books = new BookDAO().getAll();
        
        return books;
    }
}
