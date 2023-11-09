package com.bimaapp.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.bimaapp.database.Database;
import com.bimaapp.model.Client;

public class NewClientBean implements Serializable{
    
    public static void createClient(HttpServletRequest req) {
        String nationalId = req.getParameter("national_id");
        String name = req.getParameter("client_name");
        String telephoneNumber = req.getParameter("telephone_number");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        Database.getDbInstance().getClients().add(new Client(nationalId, name, telephoneNumber, email, address));
    }
}
