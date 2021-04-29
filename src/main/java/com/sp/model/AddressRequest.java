package com.sp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddressRequest {

    private Integer number;

    private String street;

    private String zipCode;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
