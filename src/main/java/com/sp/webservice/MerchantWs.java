package com.sp.webservice;

import com.sp.converter.MerchantConverter;
import com.sp.entities.MerchantEntity;
import com.sp.model.MerchantRequest;
import com.sp.model.MerchantResponse;
import com.sp.model.MerchantUpdateRequest;
import com.sp.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class MerchantWs {

    @Autowired
    private IMerchantService merchantService;

    @WebMethod(operationName = "getAllMerchants")
    public List<MerchantResponse> findAllMerchants() {
        List<MerchantEntity> merchantEntities = merchantService.findAll();
        return MerchantConverter.convertToResponse(merchantEntities);
    }

    @WebMethod(operationName = "createMerchant")
    public MerchantResponse createMerchant(MerchantRequest merchantRequest) {
        MerchantEntity merchantEntity = MerchantConverter.convertToEntity(merchantRequest);
        Integer id = merchantService.create(merchantEntity);
        return MerchantConverter.convertToResponse(merchantService.findById(id).orElseGet(null));
    }

    @WebMethod(operationName = "deleteMerchant")
    public void deleteMerchant(@WebParam(name = "merchantId") int merchantId) {
        merchantService.deleteById(merchantId);
    }

    @WebMethod(operationName = "updateMerchant")
    public MerchantResponse updateMerchant(MerchantUpdateRequest updateRequest) {
        MerchantEntity existedMerchant = merchantService.findById(updateRequest.getId()).orElseGet(null);
        MerchantEntity merchantToUpdate = MerchantConverter.toUpdateEntity(existedMerchant, updateRequest);
        if (merchantToUpdate == null) {
            return null; // TODO handle exception
        }

        return MerchantConverter.convertToResponse(merchantService.update(merchantToUpdate));
    }
}
