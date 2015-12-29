package pms.dao;


import java.util.List;

public interface GenericDao <T> {

    void create(T t);

    void delete(T t);

    void update(T t);

    T read(Long id);

    List<T> getAll();

}
