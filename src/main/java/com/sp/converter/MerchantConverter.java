package com.sp.converter;

import com.sp.entities.MerchantEntity;
import com.sp.model.MerchantRequest;
import com.sp.model.MerchantResponse;
import com.sp.model.MerchantUpdateRequest;
import com.sp.utilis.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MerchantConverter {

    public static MerchantResponse convertToResponse(MerchantEntity merchantEntity) {
        if (merchantEntity == null) {
            return null;
        }

        MerchantResponse merchantResponse = new MerchantResponse();

        merchantResponse.setId(merchantEntity.getId());
        merchantResponse.setCreateDate(merchantEntity.getCreateDate());
        merchantResponse.setBirthDate(merchantEntity.getBirthDate());
        merchantResponse.setName(merchantEntity.getName());
        merchantResponse.setLastName(merchantEntity.getLastName());
        merchantResponse.setAddressList(AddressConverter.convertToResponse(merchantEntity.getAddressList()));

        return merchantResponse;
    }

    public static List<MerchantResponse> convertToResponse(List<MerchantEntity> merchantEntities) {
        merchantEntities = ListUtils.removeNulls(merchantEntities);

        if (ListUtils.isEmpty(merchantEntities)) {
            return new ArrayList<>();
        }
        return merchantEntities.stream()
                .map(MerchantConverter::convertToResponse)
                .collect(Collectors.toList());
    }

    public static MerchantEntity convertToEntity(MerchantRequest merchantRequest) {

        if (merchantRequest == null) {
            return null;
        }

        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setName(merchantRequest.getName());
        merchantEntity.setLastName(merchantRequest.getLastName());
        merchantEntity.setBirthDate(merchantRequest.getBirthDate());
        merchantEntity.setAddressList(AddressConverter.convertToEntity(merchantRequest.getAddressList()));

        return merchantEntity;
    }

    public static MerchantEntity toUpdateEntity(MerchantEntity entityToUpdate,
                                                MerchantUpdateRequest merchantUpdateRequest) {
        if (entityToUpdate == null) {
            return null; // TODO handle exception
        }
        entityToUpdate.setName(merchantUpdateRequest.getName());
        entityToUpdate.setLastName(merchantUpdateRequest.getLastName());
        entityToUpdate.setBirthDate(merchantUpdateRequest.getBirthDate());

        return entityToUpdate;
    }
}
