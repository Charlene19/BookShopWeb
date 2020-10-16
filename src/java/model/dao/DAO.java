package model.dao;

import java.util.List;

/**
 * @author zvr
 * 
 * @param <T> Type of the object
 * @param <U> Type of the primary key in DB (varchar, int, etc.)
 */
public interface DAO<T,U> {
    
    void add(T object) throws Exception;
    List<T> getAll() throws Exception;
    T getById(U id) throws Exception;
    void update(T object) throws Exception;
    void delete(T object) throws Exception;
}
