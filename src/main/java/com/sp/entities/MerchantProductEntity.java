package com.sp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "merchant_product")
@Data
public class MerchantProductEntity implements Serializable {

    @EmbeddedId
    private MerchantProductId id = new MerchantProductId();

    @ManyToOne
    @MapsId("merchantId")
    private MerchantEntity merchant;

    @ManyToOne
    @MapsId("productId")
    private ProductEntity product;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();

}
