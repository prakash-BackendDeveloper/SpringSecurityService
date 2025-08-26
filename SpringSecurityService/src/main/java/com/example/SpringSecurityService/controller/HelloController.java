package com.example.SpringSecurityService.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("")
    public String printHello(){
        return "Hello World";
    }
    @GetMapping("/session")
    public String printSessionId(HttpServletRequest request){
        return request.getSession().getId();
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @GetMapping("/public/demo")
    public String demo(){
        return "Public page demo code";
    }


}
