package services;

import daos.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
@Service
public class CommonServicesImpl<T> implements Services<T> {

    @Autowired
    private Dao<T> dao;

    @Override
    public List getAll(Class tClass) {
        return dao.getAll(tClass);
    }
}
