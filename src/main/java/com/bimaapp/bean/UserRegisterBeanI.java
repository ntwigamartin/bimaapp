package com.bimaapp.bean;

import java.sql.SQLException;

import com.bimaapp.model.User;

public interface UserRegisterBeanI {
    boolean createUser(User user, String confirmPasswordParam) throws SQLException;
}
