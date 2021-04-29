package com.sp.service;

import com.sp.dao.MerchantRepository;
import com.sp.entities.MerchantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MerchantService implements IMerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    public Integer create(MerchantEntity entity) {
        return (Integer) merchantRepository.create(entity);
    }

    @Override
    public Optional<MerchantEntity> findById(int id) {
        return merchantRepository.findById(id);
    }

    @Override
    public MerchantEntity update(MerchantEntity entity) {
        return merchantRepository.update(entity);
    }

    @Override
    public void deleteById(int id) {
        merchantRepository.deleteById(id);
    }

    @Override
    public List<MerchantEntity> findAll() {
        return merchantRepository.findAll();
    }

}
