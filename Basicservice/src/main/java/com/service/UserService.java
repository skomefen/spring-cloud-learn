package com.service;


import com.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/refactor")
public interface UserService {

    @RequestMapping("/hello2")
    public String hello2();

    @RequestMapping("/hello3")
    public User printUser(@RequestBody User user);
}
