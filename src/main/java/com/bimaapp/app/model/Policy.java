package com.bimaapp.app.model;

import java.io.Serializable;

import com.bimaapp.database.helper.DbTable;
import com.bimaapp.database.helper.DbTableColumn;
import com.bimaapp.enums.PolicyType;
import com.bimaapp.utils.HtmlFormField;

@DbTable(name = "policies")
public class Policy implements Serializable{

    @DbTableColumn(name = "id", definition = "INT PRIMARY KEY AUTO_INCREMENT")
    private Long id;

    @DbTableColumn(name = "start_date")
    @HtmlFormField(label = "Start Date", inputType = "date")
    private String startDate;

    @DbTableColumn(name = "end_date")
    @HtmlFormField(label = "End Date", inputType = "date")
    private String endDate;
    
    @DbTableColumn(name = "policy_number")
    private String number;

    @DbTableColumn(name = "policy_type")
    private PolicyType policyType;

    @DbTableColumn(name = "client_id", definition = "Long")
    private Client client;
    
    public Policy(Long id, String startDate, String endDate, String number, PolicyType policyType, Client client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.number = number;
        this.policyType = policyType;
        this.client = client;
    }

    public Policy(String startDate, String endDate, String number, PolicyType policyType, Client client) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.number = number;
        this.policyType = policyType;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PolicyType getPolicyType() {
        return policyType;
    }

    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Policy [startDate=" + startDate + ", endDate=" + endDate + ", number=" + number + ", policyType="
                + policyType + ", client=" + client + "]";
    }
    
    
      
}
