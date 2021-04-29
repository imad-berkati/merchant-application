package com.sp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductUpdateRequest extends ProductRequest {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
