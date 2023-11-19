package com.bimaapp.bean.policy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import com.bimaapp.database.Database;
import com.bimaapp.enums.CoverType;
import com.bimaapp.model.CoverDetail;
import com.bimaapp.model.Policy;

public class NewPolicyDetailBean implements NewPolicyDetailBeanI,  Serializable {

    @Override
    public void createCoverDetail(Map<String, String> paramMap) {

        String vehicleReg = (String) paramMap.get("vehicleReg");
        String vehicleMake = (String) paramMap.get("vehicleMake");
        int vehicleValue = Integer.parseInt((String) paramMap.get("vehicleValue"));
        CoverType coverType = getCoverType((String) paramMap.get("cover_type"));
        String terms = (String) paramMap.get("terms");
        Policy policy = new PolicySearchBean().getPolicy((String) paramMap.get("policy_num"));
        BigDecimal premium = new ComputePremiumBean().computePremium(vehicleValue, policy.getPolicyType(), coverType);

        Database.getDbInstance().getCoverDetails().add(new CoverDetail(vehicleReg, vehicleMake, vehicleValue, coverType, premium, terms, policy));

    }

    public CoverType getCoverType (String paramValue) {
        if (paramValue.equalsIgnoreCase("thirdparty")) {
            return CoverType.THIRDPARTY;
        } else if (paramValue.equalsIgnoreCase("comprehensive")) {
            return CoverType.COMPREHENSIVE;
        }else {
            return null;
        }
    }
    
}
