package com.example.demo2.api.hello.service;

import com.example.demo2.api.entity.UserEntity;
import com.example.demo2.api.hello.dto.UserDto;
import com.example.demo2.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {

    @Autowired
    UserRepository userRepository;

    public UserDto findByUserId(String id) {
        return userRepository.findByUserId(id);
    }

}
