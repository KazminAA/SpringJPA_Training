package org.demo.daos;

import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
public interface Dao<T> {
    List<T> getAll(Class<T> tClass);

    void merge(T entity);
}
