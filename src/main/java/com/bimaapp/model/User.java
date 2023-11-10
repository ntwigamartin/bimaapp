package com.bimaapp.model;

import java.io.Serializable;

import com.bimaapp.enums.UserRole;

public class User implements Serializable{
    private Long userId;
    private String username;
    private String password;
    private UserRole userRole;

    public User() {}
    
    public User(Long userId, String username, String password, UserRole userRole) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public User(String username, String password, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", userRole=" + userRole
                + "]";
    }
    
        
}
