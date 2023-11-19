package com.bimaapp.bean.client;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bimaapp.database.Database;
import com.bimaapp.database.MysqlDatabase;
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
        List<Client> dbClients = retrieveDbClients();

        return dbClients.stream()
            .filter(client -> client.getNationalId().contains(query)
                    || client.getName().contains(query)
                    || client.getTelephoneNumber().contains(query)
                    || client.getEmail().contains(query)
                    || client.getAddress().contains(query))
            .collect(Collectors.toList());
    }

    public List<Client> retrieveDbClients() {

        List<Client> dbClients = new ArrayList<Client>();
        String sqlQuery = "select * from clients;";

        try {
            Statement sqlStmt = MysqlDatabase.getInstance().getConnection()
            .createStatement();

            ResultSet results = sqlStmt.executeQuery(sqlQuery);
            while (results.next()) {
                String nationalId = results.getString("national_id");
                String name = results.getString("client_name");
                String telephoneNumber = results.getString("telephone_number");
                String email = results.getString("email");
                String address = results.getString("address");

                dbClients.add(new Client(nationalId, name, telephoneNumber, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbClients;
    }
    
}
