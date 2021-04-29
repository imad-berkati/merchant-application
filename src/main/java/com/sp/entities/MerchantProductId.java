package com.sp.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class MerchantProductId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer merchantId;

    private Integer productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchantProductId that = (MerchantProductId) o;
        return Objects.equals(merchantId, that.merchantId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, productId);
    }
}
