package com.bimaapp.model;

import java.io.Serializable;

import com.bimaapp.enums.PolicyType;
import com.bimaapp.utils.HtmlFormField;

public class Policy implements Serializable{

    private Long id;

    @HtmlFormField(label = "Start Date", inputType = "date")
    private String startDate;

    @HtmlFormField(label = "Start Date", inputType = "date")
    private String endDate;
    
    private String number;
    private PolicyType policyType;
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
