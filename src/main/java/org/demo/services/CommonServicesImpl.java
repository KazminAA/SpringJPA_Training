package org.demo.services;

import org.demo.daos.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
@Service("comservice")
public class CommonServicesImpl<T> implements Services<T> {

    @Autowired
    private Dao<T> dao;

    @Override
    public List getAll(Class tClass) {
        return dao.getAll(tClass);
    }

    @Override
    public void merge(T entity) {
        dao.merge(entity);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteByField(Class<T> tClass, String fieldName, String value) {
        dao.deleteByField(tClass, fieldName, value);
    }

    @Override
    public List<T> getByField(Class<T> tClass, String fieldName, String value) {
        List<T> result = dao.getByField(tClass, fieldName, value);
        return result;
    }
}
