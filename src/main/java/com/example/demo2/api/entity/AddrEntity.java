package com.example.demo2.api.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name="T_ADDR")
public class AddrEntity {
    @Id @GeneratedValue
    @Column(name = "F_ID")
    private Long id;

    @Column(name = "F_ADDR")
    private String addr;
}
