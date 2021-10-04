package com.example.demo2.api.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
// @NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "T_ROLE")
public class RoleEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "F_USER_ID")
    private String userId;

    @Column(name = "F_ROLE")
    private String userRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "F_USER_ID", insertable = false, updatable = false)
    private UserEntity userEntity;

}
