package com.sp.service;

import com.sp.dao.ProductRepository;
import com.sp.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Integer create(ProductEntity entity) {
        return (Integer) productRepository.create(entity);
    }

    @Override
    public Optional<ProductEntity> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        return productRepository.update(entity);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}
