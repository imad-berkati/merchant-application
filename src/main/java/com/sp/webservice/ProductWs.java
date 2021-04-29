package com.sp.webservice;

import com.sp.converter.ProductConverter;
import com.sp.entities.ProductEntity;
import com.sp.model.ProductRequest;
import com.sp.model.ProductResponse;
import com.sp.model.ProductUpdateRequest;
import com.sp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProductWs {

    @Autowired
    IProductService productService;

    @WebMethod(operationName = "getAllProducts")
    public List<ProductResponse> findAllProducts() {
        List<ProductEntity> productEntities = productService.findAll();
        List<ProductResponse> productResponses = ProductConverter.convertToResponse(productEntities);
        return productResponses;
    }

    @WebMethod(operationName = "createProduct")
    public ProductResponse createProduct(ProductRequest productRequest) {
        ProductEntity productEntity = ProductConverter.convertToEntity(productRequest);
        Integer id = productService.create(productEntity);
        return ProductConverter.convertToResponse(productService.findById(id).orElseGet(null));
    }

    @WebMethod(operationName = "deleteProduct")
    public void deleteProduct(@WebParam(name = "productId") int productId) {
        productService.deleteById(productId);
    }

    @WebMethod(operationName = "updateProduct")
    public ProductResponse updateProduct(ProductUpdateRequest updateRequest) {
        ProductEntity existedProduct = productService.findById(updateRequest.getId()).orElseGet(null);

        ProductEntity productToUpdate = ProductConverter.toUpdateEntity(existedProduct, updateRequest);

        if (productToUpdate == null) {
            return null; // TODO handle exception
        }

        return ProductConverter.convertToResponse(productService.update(productToUpdate));
    }

}
