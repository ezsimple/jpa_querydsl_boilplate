package com.example.demo2.api.hello.controller;

import com.example.demo2.api.hello.dto.UserDto;
import com.example.demo2.api.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String hello(ModelMap model) {
        return "Hello World9";
    }

    @ResponseBody
    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findByUserId(@PathVariable("id") String id) {
        UserDto dto = helloService.findByUserId(id);
        return dto;
    }
}
