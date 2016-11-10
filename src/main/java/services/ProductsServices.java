package services;

import daos.Dao;
import models.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
@Service
public class ProductsServices implements Services<ProductsEntity> {

    @Autowired
    private Dao<ProductsEntity> productsEntityDao;

    @Override
    public List<ProductsEntity> getAll(Class<ProductsEntity> productsEntityClass) {
        return productsEntityDao.getAll(ProductsEntity.class);
    }
}
