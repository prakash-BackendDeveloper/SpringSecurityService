package com.example.SpringSecurityService.controller;


import com.example.SpringSecurityService.model.LoginUser;
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

    @PostMapping("/admin/add")
    public void addUser(@RequestBody Users user){
       userService.addUser(user);

    }

    @PostMapping("/register")
    public LoginUser register(@RequestBody LoginUser user){
        return  userService.register(user);
    }


    @PostMapping("/login")
    public String login(@RequestBody LoginUser user){
        return userService.verify(user);
    }
}
