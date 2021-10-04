package com.example.demo2.api.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "T_EMP")
public class EmpEntity { // 사원테이블

    @Id @GeneratedValue
    @Column(name = "F_EMP_NO")
    private Long empNo;  // 사원번호

    @Column(name = "F_NAME")
    private String name; // 사원명

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "F_ADDR") // T_ADDR.F_ADDR을 가르킴
    private AddrEntity addr; // 주소 (FK)
}
