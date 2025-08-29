package com.example.SpringSecurityService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LoginUser {
    @Id
    private int Id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "LoginUser{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
