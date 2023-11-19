package com.bimaapp.bean.user;

import java.sql.SQLException;

import com.bimaapp.model.User;

public interface UserRegisterBeanI {
    boolean createUser(User user, String confirmPasswordParam) throws SQLException;
}
