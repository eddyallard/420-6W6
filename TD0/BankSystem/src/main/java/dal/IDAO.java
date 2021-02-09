package dal;

import java.util.List;

public interface IDAO<T> {
    List<T> getAll();
    T get(int id);
    void create(T t);
}
