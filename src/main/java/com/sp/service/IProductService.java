package com.sp.service;

import com.sp.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Integer create(ProductEntity entity);

    Optional<ProductEntity> findById(int id);

    ProductEntity update(ProductEntity entity);

    void deleteById(int id);

    List<ProductEntity> findAll();

}
