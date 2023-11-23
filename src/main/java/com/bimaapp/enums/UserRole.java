package com.bimaapp.enums;

public enum UserRole {

    UNDERWRITER("underwriter"), 
    CLAIM_ANALYST("claim_analyst"), 
    NORMAL("normal");

    private String name;

    private UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
