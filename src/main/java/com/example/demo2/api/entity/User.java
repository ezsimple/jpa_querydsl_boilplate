package com.example.demo2.api.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_USER")
public class User {

    @Id
    @Column(name = "F_USER_ID")
    String userId;

    @Column(name = "F_USER_NAME")
    String userName;

    @Column(name = "F_USER_PASSWD")
    String userPasswd;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    List<Role> userRoles;
}
