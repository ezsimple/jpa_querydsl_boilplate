package com.example.demo2.api.hello.service;

import com.example.demo2.api.hello.dto.UserDto;
import com.example.demo2.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    UserRepository userRepository;

    public List<UserDto> findByUserId(String id) {
        List<UserDto> list = userRepository.findByUserId(id).fetch();
        return list;
    }

}
