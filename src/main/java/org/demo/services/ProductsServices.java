package org.demo.services;

import org.demo.daos.Dao;
import org.demo.models.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
@Service("productservice")
public class ProductsServices implements Services<ProductsEntity> {

    @Autowired
    private Dao<ProductsEntity> productsEntityDao;

    @Override
    public List<ProductsEntity> getAll(Class<ProductsEntity> productsEntityClass) {
        return productsEntityDao.getAll(ProductsEntity.class);
    }

    @Override
    public void merge(ProductsEntity entity) {
        productsEntityDao.merge(entity);
    }
}
