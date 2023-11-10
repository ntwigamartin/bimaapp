package com.bimaapp.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bimaapp.database.Database;
import com.bimaapp.model.User;

public class LoginBean implements LoginBeanI, Serializable {

    public boolean authenticate(User user) {
        Database db = Database.getDbInstance();

        String username = user.getUsername();
        String password = user.getPassword();

        for (User dbUser : db.getUsers()) {
            if (username.equals(dbUser.getUsername()) && password.equals(dbUser.getPassword())) {

                return true;
            }
        }
        return false;
    }

}
