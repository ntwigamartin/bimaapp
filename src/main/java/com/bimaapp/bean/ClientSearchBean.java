package com.bimaapp.bean;

import java.io.Serializable;
import java.util.List;

import com.bimaapp.database.Database;
import com.bimaapp.model.Client;

public class ClientSearchBean implements ClientSearchBeanI, Serializable{

    @Override
    public Client getClient(String paramValue) {
        List<Client> clients = Database.getDbInstance().getClients();
        for (Client client : clients) {
            if (client.getNationalId().equals(paramValue)) {
                return client;
            }
        }
        return null;
    }
    
}
