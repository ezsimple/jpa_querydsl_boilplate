package com.example.demo2.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "T_ROLE2")
public class Role2Entity {
    @Id
    @Column(name = "F_ROLE_NM")
    String roleNm;

    @JoinColumn(name = "F_USER_ID")
    String userId;
}
