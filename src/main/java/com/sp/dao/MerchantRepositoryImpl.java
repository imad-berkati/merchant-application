package com.sp.dao;

import com.sp.entities.MerchantEntity;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantRepositoryImpl extends AbstractCrudDao<MerchantEntity> implements MerchantRepository {

    public MerchantRepositoryImpl() {
        setClazz(MerchantEntity.class);
    }
}
