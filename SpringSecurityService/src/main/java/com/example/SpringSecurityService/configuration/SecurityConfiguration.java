package com.example.SpringSecurityService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customer -> customer.disable());
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement((session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user1=User.withDefaultPasswordEncoder()
                .username("rohit")
                .password("3000")
                .roles("USER")
                .build();

        UserDetails user2=User.withDefaultPasswordEncoder()
                .username("kohli")
                .password("2000")
                .roles("USER")
                .build();

        UserDetails user3=User.withDefaultPasswordEncoder()
                .username("pant")
                .password("1000")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1,user2,user3);
    }
}
