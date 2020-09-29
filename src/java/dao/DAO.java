package dao;

import dao.DatabaseException;
import java.util.List;

/**
 *
 * @author zvr
 * @param <T>
 */
public interface DAO<T> {

    void add(T object) throws DatabaseException;
    void update(T object) throws DatabaseException;
    void delete(T object) throws DatabaseException;
    List<T> getAll() throws DatabaseException;
    T get(Object id) throws DatabaseException;
}