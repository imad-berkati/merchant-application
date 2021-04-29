package com.sp.service;

import com.sp.config.ApplicationConfig;
import com.sp.entities.AddressEntity;
import com.sp.entities.MerchantEntity;
import com.sp.entities.MerchantProductEntity;
import com.sp.entities.ProductEntity;
import com.sp.enums.Currency;
import com.sp.utilis.ListUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class}, loader = AnnotationConfigContextLoader.class)
public class MerchantProductServiceTest {

    @Autowired
    private IMerchantProductService merchantProductService;

    @Autowired
    IProductService productService;

    @Autowired
    private IMerchantService merchantService;

    private static ProductEntity productEntity;
    private static MerchantEntity merchantEntity;


    @BeforeClass
    public static void setUp() throws ParseException {
        productEntity = new ProductEntity();
        productEntity.setCreateDate(new Date());
        productEntity.setLabel("Jordan nike");
        productEntity.setUnitPrice(88.58d);
        productEntity.setWeight(11d);
        productEntity.setHeight(4d);
        productEntity.setCurrency(Currency.EUR);

        merchantEntity = new MerchantEntity();
        merchantEntity.setName("wissam");
        merchantEntity.setLastName("berkati");
        merchantEntity.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1993-04-22"));

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet("italie morrooo");
        addressEntity.setNumber(888);
        addressEntity.setZipCode("1665");
        merchantEntity.addAddress(addressEntity);
    }

    @Test
    public void associateProductToMerchant() {
        // create Product
        Integer productId = productService.create(productEntity);
        Optional<ProductEntity> existedProductOptional = productService.findById(productId);
        assertTrue(existedProductOptional.isPresent());
        ProductEntity existedProduct = existedProductOptional.get();

        // create Merchant
        Integer merchantId = merchantService.create(merchantEntity);
        Optional<MerchantEntity> existedMerchantOptional = merchantService.findById(merchantId);
        assertTrue(existedMerchantOptional.isPresent());
        MerchantEntity existedMerchant = existedMerchantOptional.get();

        assertTrue(ListUtils.isEmpty(merchantEntity.getMerchantProductEntities()));

        // Link Merchant and Product
        MerchantProductEntity merchantProductEntity = new MerchantProductEntity();
        merchantProductEntity.setMerchant(existedMerchant);
        merchantProductEntity.setProduct(existedProduct);
        existedMerchant.getMerchantProductEntities().add(merchantProductEntity);
        existedProduct.getMerchantProductEntities().add(merchantProductEntity);
        merchantProductService.create(merchantProductEntity);

        Optional<MerchantEntity> otherMerchantOptional = merchantService.findById(merchantId);
        assertTrue(otherMerchantOptional.isPresent());
        MerchantEntity otherMerchant = otherMerchantOptional.get();

        assertTrue(ListUtils.isNotEmpty(otherMerchant.getMerchantProductEntities()));
        assertEquals(otherMerchant.getMerchantProductEntities().size(), 1);
        ProductEntity merchantProduct = otherMerchant.getMerchantProductEntities().get(0).getProduct();

        assertEquals(merchantProduct.getId(), existedProduct.getId());
        assertEquals(merchantProduct.getLabel(), existedProduct.getLabel());
        assertEquals(merchantProduct.getHeight(), existedProduct.getHeight());

        merchantService.deleteById(merchantId);
        productService.deleteById(productId);
    }
}
