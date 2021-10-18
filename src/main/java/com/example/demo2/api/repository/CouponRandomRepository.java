package com.example.demo2.api.repository;

import com.example.demo2.api.entity.CouponRandomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CouponRandomRepository extends JpaRepository<CouponRandomEntity, String>, QuerydslPredicateExecutor<CouponRandomEntity> {
}