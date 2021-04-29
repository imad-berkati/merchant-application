package com.sp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudDao<T extends Serializable> implements ICrudDao<T> {

    private Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    protected final void setClazz(final Class<T> myClazz) {
        clazz = myClazz;
    }

    @Override
    public final Optional<T> findById(int id) {
        return Optional.ofNullable(getSession().get(clazz, id));
    }

    @Override
    public final List<T> findAll() {
        CriteriaQuery<T> query = getSession().getCriteriaBuilder().createQuery(clazz);
        query.select(query.from(clazz));
        return getSession().createQuery(query).getResultList();
    }

    @Override
    public final Object create(T entity) {
        return getSession().save(entity);
    }

    @Override
    public final T update(T entity) {
        return (T) getSession().merge(entity);
    }

    @Override
    public void deleteById(int entityId) {
        final Optional<T> entity = findById(entityId);
        entity.ifPresent(t -> getSession().delete(t));
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
