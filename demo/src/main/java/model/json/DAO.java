package model.json;

import java.util.List;

public interface DAO<T> {
    T get(int id);

    List<T> getAll();

    boolean add(T object);

    boolean update(T object);

    boolean delete(int id);
}
