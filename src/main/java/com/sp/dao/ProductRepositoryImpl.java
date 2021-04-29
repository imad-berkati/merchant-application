package com.sp.dao;

import com.sp.entities.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends AbstractCrudDao<ProductEntity> implements ProductRepository {

    public ProductRepositoryImpl() {
        setClazz(ProductEntity.class);
    }
}
