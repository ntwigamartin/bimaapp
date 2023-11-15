package com.bimaapp.model;

import java.io.Serializable;

import com.bimaapp.utils.HtmlFormClass;
import com.bimaapp.utils.HtmlFormField;

@HtmlFormClass(formActionUrl = "./clients")
public class Client implements Serializable{

    private Long id;

    @HtmlFormField(label="National ID", inputType ="number")
    private String nationalId;

    @HtmlFormField(label="Client Name")
    private String name;

    @HtmlFormField(label="Telephone Number")
    private String telephoneNumber;

    @HtmlFormField(label="Email")
    private String email;

    @HtmlFormField(label="Address")
    private String address;

    public Client() {}
    
    public Client(Long id, String nationalId, String name, String telephoneNumber, String email, String address) {
        this.id = id;
        this.nationalId = nationalId;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.address = address;
    }

    public Client(String nationalId, String name, String telephoneNumber, String email, String address) {
        this.nationalId = nationalId;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", nationalId=" + nationalId + ", name=" + name + ", telephoneNumber="
                + telephoneNumber + ", email=" + email + ", address=" + address + "]";
    }

    
}
