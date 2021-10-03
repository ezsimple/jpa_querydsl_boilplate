package com.example.demo2.global.configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// @EnableJpaAuditing
@Configuration
public class JpaConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    // JPAQueryFactory를 bean으로 등록하는것으로 끝
    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

}
