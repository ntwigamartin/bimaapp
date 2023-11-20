package com.bimaapp.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bimaapp.app.model.Client;
import com.bimaapp.app.model.CoverDetail;
import com.bimaapp.app.model.Policy;
import com.bimaapp.app.model.User;

public class Database implements Serializable {
    
    private List<User> users = new ArrayList<User>();
    private List<Client> clients = new ArrayList<Client>();
    private List<Policy> policies = new ArrayList<Policy>();
    private List<CoverDetail> coverDetails = new ArrayList<CoverDetail>();

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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    public List<CoverDetail> getCoverDetails() {
        return coverDetails;
    }
    
    public void setCoverDetails(List<CoverDetail> coverDetails) {
        this.coverDetails = coverDetails;
    }
    
}
