package services;

import java.util.List;

/**
 * Created by Alexandr on 10.11.2016.
 */
public interface Services<T> {
    List<T> getAll(Class<T> tClass);
}
