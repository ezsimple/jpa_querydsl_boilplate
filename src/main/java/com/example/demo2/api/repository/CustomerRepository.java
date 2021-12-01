package com.example.demo2.api.repository;

import com.example.demo2.api.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, QuerydslPredicateExecutor<CustomerEntity> {
}
