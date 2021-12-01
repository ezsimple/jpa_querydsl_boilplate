package com.example.demo2.api.repository;

import com.example.demo2.api.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ShopRepository extends JpaRepository<ShopEntity, Long>, QuerydslPredicateExecutor<ShopEntity> {
}
