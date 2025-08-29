package com.example.SpringSecurityService.service;

import com.example.SpringSecurityService.model.LoginUser;
import com.example.SpringSecurityService.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrincipal implements UserDetails {

    //private Users user;
    private  LoginUser loginUser;

//    UserPrincipal(Users user){
//        this.user=user;
//    }

    UserPrincipal(LoginUser loginUser){
        this.loginUser=loginUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return loginUser.getPassword();
    }

    @Override
    public String getUsername() {
        return loginUser.getUsername();
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();//db
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();//db
//    }
}
