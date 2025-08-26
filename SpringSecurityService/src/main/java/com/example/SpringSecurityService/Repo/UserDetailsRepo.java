package com.example.SpringSecurityService.Repo;

import com.example.SpringSecurityService.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);

}
