package com.bimaapp.bean;

import com.bimaapp.model.User;

public interface LoginBeanI {
    boolean authenticate(User user);
}
