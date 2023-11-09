package com.bimaapp.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.bimaapp.database.Database;
import com.bimaapp.enums.UserRole;
import com.bimaapp.model.User;

public class UserRegisterBean implements Serializable{

    public static boolean createUser(HttpServletRequest req) {
                
        Database db = Database.getDbInstance();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmpassword");

        if (password.equals(confirmPassword)) {
            db.getUsers().add(new User(username, confirmPassword, UserRole.NORMAL));
            return true;
        }else {
            return false;
        }
    }
}
