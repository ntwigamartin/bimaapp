package com.bimaapp.bean.user;

import java.sql.SQLException;

import com.bimaapp.model.User;

public interface LoginBeanI {
    boolean authenticate(User user) throws SQLException;
}
