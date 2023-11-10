package com.bimaapp.bean;

import com.bimaapp.model.User;

public interface UserRegisterBeanI {
    boolean createUser(User user, String confirmPasswordParam);
}
