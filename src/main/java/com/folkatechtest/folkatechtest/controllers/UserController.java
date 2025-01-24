package com.folkatechtest.folkatechtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.folkatechtest.folkatechtest.models.dtos.LoginDto;
import com.folkatechtest.folkatechtest.models.dtos.UserDto;
import com.folkatechtest.folkatechtest.services.JwtService;
import com.folkatechtest.folkatechtest.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("register")  
    public UserDto register(@RequestBody UserDto userDto) {
        var user = service.saveUser(userDto);
        return user;
    }

    @PostMapping("login")
    public String login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(loginDto.getEmail());
        }
        return "failed";
    }
    
}
