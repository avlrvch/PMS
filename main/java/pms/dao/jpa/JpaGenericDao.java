package pms.dao.jpa;

import pms.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class JpaGenericDao<T> implements GenericDao<T> {

    private static final String READ_ALL_QUERY_PATTERN =
            "SELECT e FROM %s e";

    @PersistenceContext
    EntityManager em;

    private Class<T> type;

    public JpaGenericDao() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        type = (Class<T>) superClass.getActualTypeArguments()[0];
    }

    @Override
    public void create(T entity) {
        em.persist(entity);
    }

    @Override
    public T read(Long id) {
        return em.find(type, id);
    }

    @Override
    public List<T> getAll() {
        String query = String.format(READ_ALL_QUERY_PATTERN, type.getSimpleName());
        return em.createQuery(query)
                .getResultList();
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}

