package com.bimaapp.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bimaapp.database.Database;
import com.bimaapp.enums.UserRole;
import com.bimaapp.model.User;

@WebListener
public class AppServletContextListener implements ServletContextListener{
    
    public void contextInitialized(ServletContextEvent sce) {

        Database db = Database.getDbInstance();
        db.getUsers().add(new User("admin", "123", UserRole.NORMAL));
        db.getUsers().add(new User("John", "john", UserRole.NORMAL));
    }
}
