package com.bimaapp.model;

import java.io.Serializable;

import com.bimaapp.enums.UserRole;

public class User implements Serializable{
    private Long userId;
    private String userName;
    private String password;
    private UserRole userRole;
    
    public User(Long userId, String userName, String password, UserRole userRole) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }

    public User(String userName, String password, UserRole userRole) {
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userRole=" + userRole
                + "]";
    }
    
        
}
