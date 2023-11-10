package com.bimaapp.bean;

import java.io.Serializable;

import com.bimaapp.database.Database;
import com.bimaapp.model.Client;

public class NewClientBean implements NewClientBeanI, Serializable{
    
    public void createClient(Client client) {
        
        Database.getDbInstance().getClients().add(client);
    }
}
