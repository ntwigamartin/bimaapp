package com.bimaapp.app.bean.clientbean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bimaapp.app.model.Client;
import com.bimaapp.database.MysqlDatabase;

public class ClientSearchBean implements ClientSearchBeanI, Serializable{
    List<Client> dbClients = new ArrayList<Client>();

    @Override
    public Client getClient(String paramValue) {
        dbClients = retrieveDbClients();
        Long id = Long.parseLong(paramValue);

        for (Client client : dbClients) {
            if (client.getNationalId().equals(paramValue) || client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> searchClients(String query) {
        dbClients = retrieveDbClients();

        return dbClients.stream()
            .filter(client -> client.getNationalId().contains(query)
                    || client.getName().contains(query)
                    || client.getTelephoneNumber().contains(query)
                    || client.getEmail().contains(query)
                    || client.getAddress().contains(query))
            .collect(Collectors.toList());
    }

    public List<Client> retrieveDbClients() {

        String sqlQuery = "select * from clients;";

        try {
            Statement sqlStmt = MysqlDatabase.getInstance().getConnection()
            .createStatement();

            ResultSet results = sqlStmt.executeQuery(sqlQuery);
            while (results.next()) {
                Long id = results.getLong("id");
                String nationalId = results.getString("national_id");
                String name = results.getString("client_name");
                String telephoneNumber = results.getString("telephone_number");
                String email = results.getString("email");
                String address = results.getString("address");

                dbClients.add(new Client(id, nationalId, name, telephoneNumber, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbClients;
    }

    
    
}
