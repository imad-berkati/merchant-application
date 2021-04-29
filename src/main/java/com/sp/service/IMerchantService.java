package com.sp.service;

import com.sp.entities.MerchantEntity;

import java.util.List;
import java.util.Optional;

public interface IMerchantService {

    Integer create(MerchantEntity entity);

    Optional<MerchantEntity> findById(int id);

    MerchantEntity update(MerchantEntity entity);

    void deleteById(int id);

    List<MerchantEntity> findAll();
}
