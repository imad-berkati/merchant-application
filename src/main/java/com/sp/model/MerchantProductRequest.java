package com.sp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MerchantProductRequest {

    private Integer productId;

    private Integer merchantId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }
}
