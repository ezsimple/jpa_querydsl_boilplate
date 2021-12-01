package com.example.demo2.api.dao;

import com.example.demo2.api.entity.QCustomerEntity;
import com.example.demo2.api.entity.QShopEntity;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.demo2.global.core.CoreResource.jpaQueryFactory;

@Repository
@RequiredArgsConstructor
public class ShopDao {

    QCustomerEntity qCustomerEntity = QCustomerEntity.customerEntity;
    QShopEntity qShopEntity = QShopEntity.shopEntity;

    public JPAQuery<String> crossJoin() {
        JPAQuery<String> query = jpaQueryFactory()
                .select(
                        qShopEntity.shopNo
                )
                .from(qShopEntity)
                .where(qShopEntity.shopNo.lt(qCustomerEntity.customerNo));
        return query;
    }
}
