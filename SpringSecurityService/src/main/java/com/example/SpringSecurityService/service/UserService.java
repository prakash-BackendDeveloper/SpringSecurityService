package com.example.SpringSecurityService.service;

import com.example.SpringSecurityService.Repo.UserDetailsRepo;
import com.example.SpringSecurityService.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDetailsRepo repo;

    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);

    public void addUser(Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

}
