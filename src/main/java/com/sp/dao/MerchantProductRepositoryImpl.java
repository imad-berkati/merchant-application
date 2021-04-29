package com.sp.dao;

import com.sp.entities.MerchantProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantProductRepositoryImpl extends AbstractCrudDao<MerchantProductEntity>
        implements IMerchantProductRepository {

    public MerchantProductRepositoryImpl() {
        setClazz(MerchantProductEntity.class);
    }
}
