package com.bimaapp.app.bean.coverdetailbean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bimaapp.app.bean.policybean.PolicySearchBean;
import com.bimaapp.app.model.CoverDetail;
import com.bimaapp.app.model.Policy;
import com.bimaapp.database.MysqlDatabase;
import com.bimaapp.enums.CoverType;

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
                Policy policy = new PolicySearchBean().getPolicy(dbPolicyId);

                coverDetailList.add(new CoverDetail(id, vehicleReg, vehicleMake, vehicleValue, coverType, premium, terms, policy));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coverDetailList;
    }
    



    public List<CoverDetail> getPolicyCoverDetails(String paramValue) {
        List<CoverDetail> coverDetails = getCoverDetailList();
        List<CoverDetail> policyCoverDetails = new ArrayList<CoverDetail>();

        for (CoverDetail coverDetail : coverDetails) {
            if (coverDetail.getPolicy().getNumber().equals(paramValue)) {
                policyCoverDetails.add(coverDetail);
            }
        }

        return policyCoverDetails;
    }
}
