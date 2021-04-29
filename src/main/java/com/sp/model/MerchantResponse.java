package com.sp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class MerchantResponse extends MerchantBase {

    private Integer id;

    private Date createDate;

    private List<AddressResponse> addressList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<AddressResponse> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressResponse> addressList) {
        this.addressList = addressList;
    }
}
