package com.example.demo2.api.hello.service;

import com.example.demo2.api.entity.User;
import com.example.demo2.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {

    @Autowired
    UserRepository userRepository;

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

}
