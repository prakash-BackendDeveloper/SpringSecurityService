package com.example.SpringSecurityService.Repo;

import com.example.SpringSecurityService.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepo extends JpaRepository<LoginUser, Integer> {
    LoginUser findByUsername(String username);
}
