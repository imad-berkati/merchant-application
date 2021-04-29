package com.sp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MerchantUpdateRequest extends MerchantBase {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
