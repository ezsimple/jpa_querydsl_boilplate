package com.example.demo2.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @ManyToOne 관계를 가장 먼저 이해해야 한다.
 * 1. 회원과 팀이 있다.
 * 2. 회원은 하나의 팀에만 소속될 수 있다.
 * 3. 회원과 팀은 다대일 관계이다.
 */

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name ="T_MEMBER")
public class Member {

    @Id @GeneratedValue
    @Column(name = "F_MEMBER_ID")
    private Long memberId;

    @Column(name = "F_NAME")
    private String name;

    @ManyToOne
    // @JoinColumn("F_TEAM_ID") 생략 가능 하다.
    private Team team;

}
