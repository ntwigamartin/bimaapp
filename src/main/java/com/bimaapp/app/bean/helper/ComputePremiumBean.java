package com.bimaapp.app.bean.helper;

import java.io.Serializable;
import java.math.BigDecimal;

import com.bimaapp.enums.CoverType;
import com.bimaapp.enums.PolicyType;

public class ComputePremiumBean implements ComputePremiumBeanI, Serializable{

    @Override
    public BigDecimal computePremium(int vehicleValue, PolicyType policyType, CoverType coverType) {
        if (coverType.equals(CoverType.COMPREHENSIVE)) {
            if (policyType.equals(PolicyType.PRIVATE)) {
                return BigDecimal.valueOf(vehicleValue * 0.05);
            }else {
                return BigDecimal.valueOf(vehicleValue * 0.06);
            }
        } else {
            if (policyType.equals(PolicyType.PRIVATE)) {
                return BigDecimal.valueOf(10000);
            }else {
                return BigDecimal.valueOf(20000);
            }
        }
    }
    
}
