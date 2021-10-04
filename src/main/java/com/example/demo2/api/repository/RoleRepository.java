package com.example.demo2.api.repository;

import com.example.demo2.api.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RoleRepository extends JpaRepository<RoleEntity, String>, QuerydslPredicateExecutor<RoleEntity> {
}