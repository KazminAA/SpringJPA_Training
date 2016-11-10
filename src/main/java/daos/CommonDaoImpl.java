package daos;

import org.springframework.stereotype.Repository;

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
        System.out.println(tClass.getName());
        String query = "select class from " + tClass.getName() + " as class";
        return em.createQuery(query, tClass).getResultList();
    }
}
