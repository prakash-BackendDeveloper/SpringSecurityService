package com.example.SpringSecurityService.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private  JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customer -> customer.disable());
        http.authorizeHttpRequests(request -> request
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
//                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/login", "/register").permitAll()
                .anyRequest().authenticated());

//        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement((session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)));
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
      //  provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        List<UserDetails> users=new ArrayList<>();
//
//        UserDetails user1=User.withDefaultPasswordEncoder()
//                .username("rohit")
//                .password("3000")
//                .roles("USER")
//                .build();
//
//        UserDetails user2=User.withDefaultPasswordEncoder()
//                .username("kohli")
//                .password("2000")
//                .roles("USER")
//                .build();
//
//        UserDetails user3=User.withDefaultPasswordEncoder()
//                .username("pant")
//                .password("1000")
//                .roles("USER")
//                .build();
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//
//       // return new InMemoryUserDetailsManager(user1,user2,user3);
//
//        return new InMemoryUserDetailsManager(users);
//    }
}
