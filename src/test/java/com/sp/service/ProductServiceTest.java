package com.sp.service;

import com.sp.config.ApplicationConfig;
import com.sp.entities.ProductEntity;
import com.sp.enums.Currency;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class}, loader = AnnotationConfigContextLoader.class)
public class ProductServiceTest {

    @Autowired
    IProductService productService;

    private static ProductEntity productEntity;

    @BeforeClass
    public static void setUp() {
        productEntity = new ProductEntity();
        productEntity.setCreateDate(new Date());
        productEntity.setLabel("Jordan nike");
        productEntity.setUnitPrice(88.58d);
        productEntity.setWeight(11d);
        productEntity.setHeight(4d);
        productEntity.setCurrency(Currency.EUR);
    }

    @Test
    public void createProduct() {
        Integer id = productService.create(productEntity);
        Optional<ProductEntity> existedProductOptional = productService.findById(id);
        assertTrue(existedProductOptional.isPresent());
        ProductEntity existedProduct = existedProductOptional.get();
        assertEquals(existedProduct.getCreateDate().getTime(), productEntity.getCreateDate().getTime());
        assertEquals(existedProduct.getCurrency(), productEntity.getCurrency());
        assertEquals(existedProduct.getHeight(), productEntity.getHeight());
        assertEquals(existedProduct.getWeight(), productEntity.getWeight());
        assertEquals(existedProduct.getLabel(), productEntity.getLabel());
        productService.deleteById(id);
    }

    @Test
    public void updateProduct() {
        Integer id = productService.create(productEntity);
        Optional<ProductEntity> existedProductOptional = productService.findById(id);
        assertTrue(existedProductOptional.isPresent());
        ProductEntity existedProduct = existedProductOptional.get();
        existedProduct.setLabel("Balenciaga");
        existedProduct.setUnitPrice(9999d);

        ProductEntity updatedProduct = productService.update(existedProduct);
        assertEquals(updatedProduct.getLabel(), existedProduct.getLabel());
        assertEquals(updatedProduct.getUnitPrice(), existedProduct.getUnitPrice());
        productService.deleteById(id);
    }

    @Test
    public void deleteById() {
        Integer id = productService.create(productEntity);
        productService.deleteById(id);
        Optional<ProductEntity> existedProductOptional = productService.findById(id);
        assertFalse(existedProductOptional.isPresent());
    }

    @Test
    public void findById() {
        Integer id = productService.create(productEntity);
        Optional<ProductEntity> existedProductOptional = productService.findById(id);
        assertTrue(existedProductOptional.isPresent());
    }
}
