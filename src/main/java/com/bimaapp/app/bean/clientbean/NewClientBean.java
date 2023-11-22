package com.bimaapp.app.bean.clientbean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bimaapp.app.model.Client;
import com.bimaapp.database.MysqlDatabase;

public class NewClientBean implements NewClientBeanI, Serializable{
    
    public void createClient(Client client) {
        
        try {
            PreparedStatement sqlStmt = MysqlDatabase.getInstance().getConnection()
            .prepareStatement("insert into clients(national_id, client_name, telephone_number, email, address) values(?,?,?,?,?)");

            sqlStmt.setString(1, client.getNationalId());
            sqlStmt.setString(2, client.getName());
            sqlStmt.setString(3, client.getTelephoneNumber());
            sqlStmt.setString(4, client.getEmail());
            sqlStmt.setString(5, client.getAddress());

            sqlStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
