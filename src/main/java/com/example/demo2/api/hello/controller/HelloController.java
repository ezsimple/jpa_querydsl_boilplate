package com.example.demo2.api.hello.controller;

import com.example.demo2.api.entity.User;
import com.example.demo2.api.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String hello(ModelMap model) {
        return "Hello World9";
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        User user = helloService.findById(id);
        return ResponseEntity.ok(user);
    }
}
