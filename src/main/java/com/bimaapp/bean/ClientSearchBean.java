package com.bimaapp.bean;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.bimaapp.database.Database;
import com.bimaapp.model.Client;

public class ClientSearchBean implements ClientSearchBeanI, Serializable{
    List<Client> clients = Database.getDbInstance().getClients();

    @Override
    public Client getClient(String paramValue) {
        
        for (Client client : clients) {
            if (client.getNationalId().equals(paramValue)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> searchClients(String query) {
        return clients.stream()
            .filter(client -> client.getNationalId().contains(query)
                    || client.getName().contains(query)
                    || client.getTelephoneNumber().contains(query)
                    || client.getEmail().contains(query)
                    || client.getAddress().contains(query))
            .collect(Collectors.toList());
    }
    
}
