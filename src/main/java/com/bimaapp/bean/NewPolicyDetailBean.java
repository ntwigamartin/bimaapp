package com.bimaapp.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import com.bimaapp.database.Database;
import com.bimaapp.enums.CoverType;
import com.bimaapp.model.CoverDetail;
import com.bimaapp.model.Policy;

public class NewPolicyDetailBean implements NewPolicyDetailBeanI,  Serializable {

    @Override
    public void createCoverDetail(HttpServletRequest req) {
        String vehicleReg = req.getParameter("vehicleReg");
        String vehicleMake = req.getParameter("vehicleMake");
        int vehicleValue = Integer.parseInt(req.getParameter("vehicleValue"));
        CoverType coverType = getCoverType(req.getParameter("cover_type"));
        String terms = req.getParameter("terms");
        Policy policy = new PolicySearchBean().getPolicy(req.getParameter("policy_num"));
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
