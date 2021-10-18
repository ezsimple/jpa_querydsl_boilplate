package com.example.demo2.api.hello.controller;

import com.example.demo2.api.entity.CouponRandomEntity;
import com.example.demo2.api.hello.dto.UserDto;
import com.example.demo2.api.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String hello(ModelMap model) {
        return "Hello World9";
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> findByUserId(@PathVariable("id") String id) {
        List<UserDto> userDtos = helloService.findByUserId(id);
        return userDtos;
    }

    @GetMapping(value = "/bulk/insert/{count}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CouponRandomEntity> bulkInsert(@PathVariable("count") int count) {
        return helloService.bulkInsert(count);
    }
}
