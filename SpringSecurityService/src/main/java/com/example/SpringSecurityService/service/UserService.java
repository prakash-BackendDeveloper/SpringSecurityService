package com.example.SpringSecurityService.service;

import com.example.SpringSecurityService.Repo.LoginUserRepo;
import com.example.SpringSecurityService.Repo.UserDetailsRepo;
import com.example.SpringSecurityService.model.LoginUser;
import com.example.SpringSecurityService.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDetailsRepo repo;

    @Autowired
    LoginUserRepo loginUserRepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);

    public void addUser(Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    public LoginUser register(LoginUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return loginUserRepo.save(user);
    }

    public String verify(LoginUser user) {
        Authentication authentication= authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "failure";
    }
}
