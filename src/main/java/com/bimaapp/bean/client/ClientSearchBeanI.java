package com.bimaapp.bean.client;

import java.util.List;

import com.bimaapp.model.Client;

public interface ClientSearchBeanI {
    Client getClient(String paramValue);

    List<Client> searchClients(String parameter);
}
