package com.folkatechtest.folkatechtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.folkatechtest.folkatechtest.models.dtos.UserDto;
import com.folkatechtest.folkatechtest.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")  
    public UserDto register(@RequestBody UserDto userDto) {
        var user = service.saveUser(userDto);
        return user;
    }
}
