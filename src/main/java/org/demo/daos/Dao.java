package org.demo.daos;

import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
public interface Dao<T> {
    List<T> getAll(Class<T> tClass);

    List<T> getByField(Class<T> tClass, String fieldName, String value);

    void merge(T entity);

    void delete(T entity);

    void deleteByField(Class<T> tClass, String fieldName, String value);
}
