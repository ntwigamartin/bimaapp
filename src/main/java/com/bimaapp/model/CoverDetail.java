package com.bimaapp.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.bimaapp.enums.CoverType;

public class CoverDetail implements Serializable{
    private Long id;
    private String vehicleReg;
    private String vehicleMake;
    private String vehicleValue;
    private CoverType coverType;
    private BigDecimal premium;
    private String terms;
    private Policy policy;
    
    public CoverDetail(Long id, String vehicleReg, String vehicleMake, String vehicleValue, CoverType coverType,
            BigDecimal premium, String terms, Policy policy) {
        this.id = id;
        this.vehicleReg = vehicleReg;
        this.vehicleMake = vehicleMake;
        this.vehicleValue = vehicleValue;
        this.coverType = coverType;
        this.premium = premium;
        this.terms = terms;
        this.policy = policy;
    }

    public CoverDetail(String vehicleReg, String vehicleMake, String vehicleValue, CoverType coverType,
            BigDecimal premium, String terms, Policy policy) {
        this.vehicleReg = vehicleReg;
        this.vehicleMake = vehicleMake;
        this.vehicleValue = vehicleValue;
        this.coverType = coverType;
        this.premium = premium;
        this.terms = terms;
        this.policy = policy;
    }

    public CoverDetail(String vehicleReg, String vehicleMake, CoverType coverType, BigDecimal premium, String terms,
            Policy policy) {
        this.vehicleReg = vehicleReg;
        this.vehicleMake = vehicleMake;
        this.coverType = coverType;
        this.premium = premium;
        this.terms = terms;
        this.policy = policy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleReg() {
        return vehicleReg;
    }

    public void setVehicleReg(String vehicleReg) {
        this.vehicleReg = vehicleReg;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(String vehicleValue) {
        this.vehicleValue = vehicleValue;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    @Override
    public String toString() {
        return "CoverDetail [vehicleReg=" + vehicleReg + ", vehicleMake=" + vehicleMake + ", vehicleValue="
                + vehicleValue + ", coverType=" + coverType + ", premium=" + premium + ", terms=" + terms + ", policy="
                + policy + "]";
    }

    
    
}
