package com.example.demo2.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
// @RequiredArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerNo; // 거래처번호(업주번호)
    private String customerName; // 거래처명(상호)
    private String bizNo; // 사업자번호
    private String ceoName; // 대표자명

    public CustomerEntity(String customerNo, String customerName, String bizNo, String ceoName) {
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.bizNo = bizNo;
        this.ceoName = ceoName;
    }

}
