package com.example.demo2.global.core;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CoreResource {

    private static EntityManager entityManager;
    private static JPAQueryFactory jpaQueryFactory;
    private static ApplicationContext applicationContext;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        CoreResource.entityManager = entityManager;
    }

    @Autowired
    public void setJpaQueryFactory(JPAQueryFactory jpaQueryFactory) {
        CoreResource.jpaQueryFactory = jpaQueryFactory;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        CoreResource.applicationContext = applicationContext;
    }

    public static EntityManager entityManager() {
        return entityManager;
    }

    // lombok 대신 static method 아래와 같이 선언시 IDE에서 import 하기 쉬움
    public static JPAQueryFactory jpaQueryFactory() {
        return jpaQueryFactory;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static Object getBean(Class<?> clazz) {
        return applicationContext.getBean(clazz);
    }

}
