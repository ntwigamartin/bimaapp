package com.bimaapp.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bimaapp.database.Database;
import com.bimaapp.enums.UserRole;
import com.bimaapp.model.Client;
import com.bimaapp.model.User;

@WebListener
public class AppServletContextListener implements ServletContextListener{
    
    public void contextInitialized(ServletContextEvent sce) {

        Database db = Database.getDbInstance();
        db.getUsers().add(new User("admin", "123", UserRole.NORMAL));
        db.getUsers().add(new User("John", "john", UserRole.NORMAL));

        db.getClients().add(new Client("27835782", "Jane Doe", "0712011000", "jane@gmail.com", "nairobi"));
        db.getClients().add(new Client("27835783", "John Doe", "0712011233", "john@gmail.com", "Thika"));
        db.getClients().add(new Client("27835784", "Peter Doe", "0712011322", "peter@gmail.com", "Nakuru"));
        db.getClients().add(new Client("27835785", "Willy Doe", "0712011499", "willy@gmail.com", "Mombasa"));
        db.getClients().add(new Client("27835786", "Jenn Doe", "0712011755", "jenn@gmail.com", "Kisumu"));
    }
}
