package com.example.demo2.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name ="T_TEAM")
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "F_TEAM_ID")
    private Long teamId;

    @Column(name = "F_NAME")
    private String name;
}
