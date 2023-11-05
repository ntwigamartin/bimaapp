package com.bimaapp.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bimaapp.model.User;

public class Database implements Serializable {
    
    private List<User> users = new ArrayList<User>();

    private static Database dbInstance;

    private Database() {}

    public static Database getDbInstance() {
        if (dbInstance == null) {
            dbInstance = new Database();
        }
        return dbInstance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
