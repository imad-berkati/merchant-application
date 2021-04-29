package com.sp.webservice;

import com.sp.entities.MerchantEntity;
import com.sp.entities.MerchantProductEntity;
import com.sp.entities.ProductEntity;
import com.sp.model.MerchantProductRequest;
import com.sp.service.IMerchantProductService;
import com.sp.service.IMerchantService;
import com.sp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Optional;

@WebService
public class MerchantProductWs {

    @Autowired
    IMerchantProductService merchantProductService;

    @Autowired
    private IMerchantService merchantService;

    @Autowired
    IProductService productService;


    @WebMethod(operationName = "addProductToMerchant")
    public void addProductToMerchant(MerchantProductRequest merchantProductRequest) {

        Optional<MerchantEntity> merchantEntity = merchantService.findById(merchantProductRequest.getMerchantId());
        Optional<ProductEntity> productEntity = productService.findById(merchantProductRequest.getProductId());

        if (!merchantEntity.isPresent() || !productEntity.isPresent()) {
            // TODO handle exception
        }

        MerchantProductEntity merchantProductEntity = new MerchantProductEntity();
        merchantProductEntity.setMerchant(merchantEntity.get());
        merchantProductEntity.setProduct(productEntity.get());
        merchantEntity.get().getMerchantProductEntities().add(merchantProductEntity);
        productEntity.get().getMerchantProductEntities().add(merchantProductEntity);
        merchantProductService.create(merchantProductEntity);

    }
}
