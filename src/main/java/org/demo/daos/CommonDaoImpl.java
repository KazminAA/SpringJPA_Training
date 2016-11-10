package org.demo.daos;

import org.demo.models.ProductsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
@Repository
public class CommonDaoImpl implements Dao<ProductsEntity> {

    //@PersistenceContext
    private EntityManager em;

    @Override
    public List<ProductsEntity> getAll(Class<ProductsEntity> tClass) {
        System.out.println(tClass.getName());
        String query = "select class from " + tClass.getName() + " as class";
        return em.createQuery(query, tClass).getResultList();
    }
}
