package com.bimaapp.app.bean.userbean;

import java.sql.SQLException;

import com.bimaapp.app.model.User;

public interface UserRegisterBeanI {
    boolean createUser(User user, String confirmPasswordParam) throws SQLException;
}
