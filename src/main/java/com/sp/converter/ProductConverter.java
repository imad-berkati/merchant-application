package com.sp.converter;

import com.sp.entities.ProductEntity;
import com.sp.model.ProductRequest;
import com.sp.model.ProductResponse;
import com.sp.model.ProductUpdateRequest;
import com.sp.utilis.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductConverter {

    public static ProductResponse convertToResponse(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(entity.getId());
        productResponse.setCreateDate(entity.getCreateDate());
        productResponse.setLabel(entity.getLabel());
        productResponse.setCurrency(entity.getCurrency());
        productResponse.setUnitPrice(entity.getUnitPrice());
        productResponse.setHeight(entity.getHeight());
        productResponse.setWeight(entity.getWeight());
        return productResponse;
    }

    public static List<ProductResponse> convertToResponse(List<ProductEntity> entities) {
        entities = ListUtils.removeNulls(entities);

        if (ListUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }
        return entities.stream()
                .map(ProductConverter::convertToResponse)
                .collect(Collectors.toList());
    }

    public static ProductEntity convertToEntity(ProductRequest productRequest) {

        if (productRequest == null) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();
        productEntity.setLabel(productRequest.getLabel());
        productEntity.setCurrency(productRequest.getCurrency());
        productEntity.setUnitPrice(productRequest.getUnitPrice());
        productEntity.setHeight(productRequest.getHeight());
        productEntity.setWeight(productRequest.getWeight());
        return productEntity;
    }

    public static ProductEntity toUpdateEntity(ProductEntity entityToUpdate,
                                               ProductUpdateRequest productUpdateRequest) {
        if (entityToUpdate == null) {
            return null; // TODO handle exception
        }
        entityToUpdate.setCurrency(productUpdateRequest.getCurrency());
        entityToUpdate.setHeight(productUpdateRequest.getHeight());
        entityToUpdate.setWeight(productUpdateRequest.getWeight());
        entityToUpdate.setUnitPrice(productUpdateRequest.getUnitPrice());
        entityToUpdate.setLabel(productUpdateRequest.getLabel());

        return entityToUpdate;
    }
}
