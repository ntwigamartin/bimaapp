package com.bimaapp.bean.coverdetail;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bimaapp.bean.policy.PolicySearchBean;
import com.bimaapp.database.MysqlDatabase;
import com.bimaapp.enums.CoverType;
import com.bimaapp.model.CoverDetail;
import com.bimaapp.model.Policy;

public class CoverDetailSearchBean implements CoverDetailSearchBeanI, Serializable {

    List<CoverDetail> coverDetailList = new ArrayList<>();

    @Override
    public List<CoverDetail> getCoverDetailList() {
        
        String query = "SELECT * FROM coverdetails;";
        try {
            Statement statement = MysqlDatabase.getInstance().getConnection().createStatement();
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                long id = results.getLong("id");
                String vehicleReg = results.getString("vehicle_reg");
                String vehicleMake = results.getString("vehicle_make");
                int vehicleValue = results.getInt("vehicle_value");
                String dbCoverType = results.getString("cover_type");
                CoverType coverType = new NewCoverDetailBean().getCoverType(dbCoverType);
                BigDecimal premium = results.getBigDecimal("premium");
                String terms = results.getString("terms");
                long dbPolicyId = results.getLong("policy_id");
                Policy policy = getPolicy(dbPolicyId);

                coverDetailList.add(new CoverDetail(id, vehicleReg, vehicleMake, vehicleValue, coverType, premium, terms, policy));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coverDetailList;
    }
    

    public Policy getPolicy(long policy_id) {
        List<Policy> policies = new PolicySearchBean().retrieveDbPolicies();
        
        for (Policy policy : policies) {
            if (policy.getId() == policy_id) {
                return policy;
            }
        }
        return null;
    }
}
