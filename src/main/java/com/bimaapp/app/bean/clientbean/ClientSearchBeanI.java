package com.bimaapp.app.bean.clientbean;

import java.util.List;

import com.bimaapp.app.model.Client;

public interface ClientSearchBeanI {
    Client getClient(String paramValue);

    List<Client> searchClients(String parameter);
}
