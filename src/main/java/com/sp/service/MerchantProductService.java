package com.sp.service;

import com.sp.dao.IMerchantProductRepository;
import com.sp.entities.MerchantProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MerchantProductService implements IMerchantProductService {

    @Autowired
    private IMerchantProductRepository merchantProductRepository;

    @Override
    public void create(MerchantProductEntity entity) {
        merchantProductRepository.create(entity);
    }
}
