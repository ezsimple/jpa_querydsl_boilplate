package com.example.demo2.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "T_USER2")
public class User2Entity {

    @Id
    @Column(name = "F_USER_ID")
    String userId;

    @Column(name = "F_USER_NM")
    String userNm;

    @Column(name = "F_USER_PW")
    String userPw;

    @JoinColumn(name = "F_ROLE_NM")
    @OneToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    List<Role2Entity> roles;
}
