package com.bimaapp.app.bean.helperbean;

import java.math.BigDecimal;

import com.bimaapp.enums.CoverType;
import com.bimaapp.enums.PolicyType;

public interface ComputePremiumBeanI {
    BigDecimal computePremium(int vehicleValue, PolicyType policyType, CoverType coverType);
}
