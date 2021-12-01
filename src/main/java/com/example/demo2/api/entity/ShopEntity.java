package com.example.demo2.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
// @RequiredArgsConstructor
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shopNo;
    private String shopName;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    public ShopEntity(String shopNo, String shopName, CustomerEntity customerEntity) {
        this.shopNo = shopNo;
        this.shopName = shopName;
        this.customerEntity = customerEntity;
    }
}
