package com.sp.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface ICrudDao<T extends Serializable> {

    List<T> findAll();

    Optional<T> findById(int id);

    Object create(T entity);

    T update(T entity);

    void deleteById(int entityId);
}
