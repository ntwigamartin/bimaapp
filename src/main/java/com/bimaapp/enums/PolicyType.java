package com.bimaapp.enums;

public enum PolicyType {
    
    PRIVATE("private"), 
    COMMERCIAL("commercial");

    private String name;

    private PolicyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
