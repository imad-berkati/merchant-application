package com.sp.converter;

import com.sp.entities.AddressEntity;
import com.sp.model.AddressRequest;
import com.sp.model.AddressResponse;
import com.sp.utilis.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressConverter {

    public static AddressResponse convertToResponse(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setId(addressEntity.getId());
        addressResponse.setNumber(addressEntity.getNumber());
        addressResponse.setStreet(addressEntity.getStreet());
        addressResponse.setZipCode(addressEntity.getZipCode());

        return addressResponse;
    }

    public static List<AddressResponse> convertToResponse(List<AddressEntity> addressEntities) {
        addressEntities = ListUtils.removeNulls(addressEntities);

        if (ListUtils.isEmpty(addressEntities)) {
            return new ArrayList<>();
        }
        return addressEntities.stream()
                .map(AddressConverter::convertToResponse)
                .collect(Collectors.toList());
    }

    public static AddressEntity convertToEntity(AddressRequest addressRequest) {
        if (addressRequest == null) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setNumber(addressRequest.getNumber());
        addressEntity.setStreet(addressRequest.getStreet());
        addressEntity.setZipCode(addressRequest.getZipCode());

        return addressEntity;

    }

    public static List<AddressEntity> convertToEntity(List<AddressRequest> addressRequests) {
        addressRequests = ListUtils.removeNulls(addressRequests);

        if (ListUtils.isEmpty(addressRequests)) {
            return new ArrayList<>();
        }
        return addressRequests.stream()
                .map(AddressConverter::convertToEntity)
                .collect(Collectors.toList());
    }

}
