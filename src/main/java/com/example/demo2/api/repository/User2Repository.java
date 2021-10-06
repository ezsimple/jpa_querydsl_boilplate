package com.example.demo2.api.repository;

import com.example.demo2.api.entity.QRole2Entity;
import com.example.demo2.api.entity.QUser2Entity;
import com.example.demo2.api.entity.User2Entity;
import com.example.demo2.api.hello.dto.UserDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import static com.example.demo2.global.core.CoreResource.jpaQueryFactory;

public interface User2Repository extends JpaRepository<User2Entity, String>, QuerydslPredicateExecutor<User2Entity> {

    default JPAQuery<UserDto> findByUserId(String userId) {
        QUser2Entity qUser2Entity = QUser2Entity.user2Entity;
        QRole2Entity qRole2Entity = QRole2Entity.role2Entity;

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qUser2Entity.userId.eq(userId));

        JPAQuery<UserDto> query = jpaQueryFactory()
                .select(
                        Projections.bean(
                                UserDto.class
                                , qUser2Entity.userId
                                , qUser2Entity.userNm.as("userName")
                                , qRole2Entity.roleNm.as("userRole")
                        )
                )
                .from(qUser2Entity)
                .leftJoin(qRole2Entity).on(qRole2Entity.userId.eq(qUser2Entity.userId))
                .where(booleanBuilder)
                ; // fetch는 dao에서

        return query;
    }
}