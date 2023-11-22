package com.bimaapp.app.bean.userbean;

import java.sql.SQLException;

import com.bimaapp.app.model.User;

public interface LoginBeanI {
    boolean authenticate(User user) throws SQLException;
}
