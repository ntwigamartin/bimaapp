package com.bimaapp.app.bean.coverdetail;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.bimaapp.app.bean.helper.ComputePremiumBean;
import com.bimaapp.app.bean.policy.PolicySearchBean;
import com.bimaapp.app.model.Policy;
import com.bimaapp.database.MysqlDatabase;
import com.bimaapp.enums.CoverType;

public class NewCoverDetailBean implements NewCoverDetailBeanI,  Serializable {

    @Override
    public void createCoverDetail(Map<String, String> paramMap) throws SQLException {
        
        int vehicleValue = Integer.parseInt((String) paramMap.get("vehicleValue"));
        CoverType coverType = getCoverType((String) paramMap.get("cover_type"));
        Policy policy = new PolicySearchBean().getPolicy((String) paramMap.get("policy_num"));
        BigDecimal premium = new ComputePremiumBean().computePremium(vehicleValue, policy.getPolicyType(), coverType);
        long policyId = new PolicySearchBean().getPolicy((String) paramMap.get("policy_num")).getId();

        PreparedStatement sqlStmt = MysqlDatabase.getInstance().getConnection()
        .prepareStatement("insert into coverdetails(vehicle_reg, vehicle_make, vehicle_value, cover_type, premium, terms, policy_id) values(?,?,?,?,?,?,?)");

        sqlStmt.setString(1, (String) paramMap.get("vehicleReg"));
        sqlStmt.setString(2, (String) paramMap.get("vehicleMake"));
        sqlStmt.setInt(3, Integer.parseInt((String) paramMap.get("vehicleValue")));
        sqlStmt.setString(4, (String) paramMap.get("cover_type"));
        sqlStmt.setBigDecimal(5, premium);
        sqlStmt.setString(6, (String) paramMap.get("terms"));
        sqlStmt.setLong(7, policyId);

        sqlStmt.executeUpdate();
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
