package com.sp.entities;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "merchant")
@Data
public class MerchantEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "merchant_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<AddressEntity> addressList;

    @OneToMany(mappedBy = "merchant", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<MerchantProductEntity> merchantProductEntities = new ArrayList<>();

    public void addAddress(AddressEntity entity) {
        if (addressList == null) {
            addressList = new ArrayList<>();
        }
        addressList.add(entity);
    }

}
