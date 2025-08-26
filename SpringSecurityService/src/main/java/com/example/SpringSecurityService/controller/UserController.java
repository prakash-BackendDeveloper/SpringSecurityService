package com.example.SpringSecurityService.controller;


import com.example.SpringSecurityService.model.Users;
import com.example.SpringSecurityService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody Users user){
       userService.addUser(user);

    }

}
