package org.demo.daos;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
@Repository
public class CommonDaoImpl<T> implements Dao<T> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<T> getAll(Class<T> tClass) {
        String query = "select ent from " + tClass.getName() + " as ent";
        return em.createQuery(query, tClass).getResultList();
    }

    @Transactional
    @Override
    public void merge(T entity) {
        em.merge(entity);
    }

    @Transactional
    @Override
    public void delete(T entity) {
        em.remove(entity);
    }
}
