package com.example.demo2.api.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @Column(name = "ID")
    String id;

    @Column(name = "NAME")
    String name;

    @Column(name = "PASSWD")
    String passwd;

    @Column(name = "roles")
    @OneToMany(cascade = CascadeType.ALL)
    List<Role> roles;
}
