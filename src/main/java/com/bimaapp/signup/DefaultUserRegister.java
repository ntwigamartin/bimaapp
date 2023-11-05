package com.bimaapp.signup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bimaapp.database.Database;
import com.bimaapp.model.User;

@WebListener
public class DefaultUserRegister implements ServletContextListener{
    
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("Application initialized");

        Database db = Database.getDbInstance();
        db.getUsers().add(new User("admin", "123"));
        db.getUsers().add(new User("John", "john"));
    }
}
