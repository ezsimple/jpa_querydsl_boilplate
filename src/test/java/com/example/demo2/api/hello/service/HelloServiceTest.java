package com.example.demo2.api.hello.service;

import com.example.demo2.api.entity.RoleEntity;
import com.example.demo2.api.entity.UserEntity;
import com.example.demo2.api.hello.dto.UserDto;
import com.example.demo2.api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
@Transactional
class HelloServiceTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        createUserAndRole("admin", "어드민", "ROLE_ADMIN");
        createUserAndRole("oper", "오퍼레이터", "ROLE_OPER");
        createUserAndRole("user", "사용자", "ROLE_USER");
    }

    @Test
    void test() {
        UserDto userDto = userRepository.findByUserId("admin").fetchFirst();
        assertEquals(userDto.getUserId(), "admin");
    }

    private void createUserAndRole(String id, String name, String roleName) {
        UserEntity user = new UserEntity();
        RoleEntity role =  new RoleEntity();

        user.setUserId(id);
        user.setUserName(name);
        user.setUserPasswd("1");
        role.setUserId(user.getUserId());
        role.setUserRole(roleName);
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
    }
}