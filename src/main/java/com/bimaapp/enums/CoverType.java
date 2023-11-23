package com.bimaapp.enums;

public enum CoverType {
    
    THIRDPARTY("thirdparty"), 
    COMPREHENSIVE("comprehensive");

    private String name;

    CoverType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
