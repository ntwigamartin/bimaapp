package com.bimaapp.bean;

import java.io.Serializable;

import com.bimaapp.database.Database;
import com.bimaapp.enums.UserRole;
import com.bimaapp.model.User;

public class UserRegisterBean implements UserRegisterBeanI, Serializable{

    public boolean createUser(User user, String confirmPasswordParam) {
                
        Database db = Database.getDbInstance();       

        if (user.getPassword().equals(confirmPasswordParam)) {
            db.getUsers().add(new User(user.getUsername(), user.getPassword(), UserRole.NORMAL));
            return true;
        }else {
            return false;
        }
    }
}
