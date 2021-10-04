package com.example.demo2.api.repository;

import com.example.demo2.api.entity.QRoleEntity;
import com.example.demo2.api.entity.QUserEntity;
import com.example.demo2.api.entity.UserEntity;
import com.example.demo2.api.hello.dto.UserDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import static com.example.demo2.global.core.CoreResource.jpaQueryFactory;

public interface UserRepository extends JpaRepository<UserEntity, String>, QuerydslPredicateExecutor<UserEntity> {

    // interface내에서 injection 이 되지 않음
    // @Autowired
    // JPAQueryFactory jpaQueryFactory = null;

    default JPAQuery<UserDto> findByUserId(String userId) {
        QUserEntity qUserEntity = QUserEntity.userEntity;
        QRoleEntity qRoleEntity = QRoleEntity.roleEntity;

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qUserEntity.userId.eq(userId));

        JPAQuery<UserDto> query = jpaQueryFactory()
                .select(
                        Projections.bean(
                                UserDto.class
                                , qUserEntity.userId
                                , qUserEntity.userName
                                , qRoleEntity.userRole
                        )
                )
                .from(qUserEntity)
                .leftJoin(qRoleEntity).on(qRoleEntity.userId.eq(qUserEntity.userId))
                .where(booleanBuilder)
                ; // fetch는 dao에서

        return query;
    }
}