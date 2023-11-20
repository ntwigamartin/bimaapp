package com.bimaapp.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.bimaapp.database.helper.DbTable;
import com.bimaapp.database.helper.DbTableColumn;
import com.bimaapp.enums.CoverType;
import com.bimaapp.utils.HtmlFormField;

@DbTable(name = "coverdetails")
public class CoverDetail implements Serializable{

    @DbTableColumn(name = "id", definition = "INT PRIMARY KEY AUTO_INCREMENT")
    private Long id;

    @DbTableColumn(name = "vehicle_reg")
    @HtmlFormField(label="Vehicle Reg")
    private String vehicleReg;

    @DbTableColumn(name = "vehicle_make")
    @HtmlFormField(label="Vehicle Make")
    private String vehicleMake;

    @DbTableColumn(name = "vehicle_value", definition = "INT")
    @HtmlFormField(label="Vehicle Value", inputType = "number")
    private int vehicleValue;

    @DbTableColumn(name = "cover_type")
    private CoverType coverType;

    @DbTableColumn(name = "premium", definition = "DECIMAL(12,2)")
    private BigDecimal premium;

    @DbTableColumn(name = "terms")
    @HtmlFormField(label="Terms")
    private String terms;
    
    @DbTableColumn(name = "policy_id")
    private Policy policy;
    
    public CoverDetail(Long id, String vehicleReg, String vehicleMake, int vehicleValue, CoverType coverType,
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

    public CoverDetail(String vehicleReg, String vehicleMake, int vehicleValue, CoverType coverType,
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

    public int getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(int vehicleValue) {
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
