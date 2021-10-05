package com.example.demo2.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "T_USER")
public class UserEntity {

    @Id
    @Column(name = "F_USER_ID")
    String userId;

    @Column(name = "F_USER_NAME")
    String userName;

    @Column(name = "F_USER_PASSWD")
    String userPasswd;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity", cascade = CascadeType.ALL)
    List<RoleEntity> userRoles;
}
