package com.example.SpringSecurityService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
