package com.example.demo2.api.repository;

import com.example.demo2.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RoleRepository extends JpaRepository<Role, String>, QuerydslPredicateExecutor<Role> {
}