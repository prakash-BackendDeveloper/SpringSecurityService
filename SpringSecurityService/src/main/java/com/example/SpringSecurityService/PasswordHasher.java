package com.example.SpringSecurityService;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncode=new BCryptPasswordEncoder(12);
        String pw="admin1234";
        System.out.println(bCryptPasswordEncode.encode(pw));
    }
}
