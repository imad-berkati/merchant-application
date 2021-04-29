package com.sp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class MerchantRequest extends MerchantBase {

    private List<AddressRequest> addressList;

    public List<AddressRequest> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressRequest> addressList) {
        this.addressList = addressList;
    }
}
