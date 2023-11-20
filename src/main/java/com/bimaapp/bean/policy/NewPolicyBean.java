package com.bimaapp.bean.policy;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.bimaapp.bean.client.ClientSearchBean;
import com.bimaapp.database.MysqlDatabase;

public class NewPolicyBean implements NewPolicyBeanI, Serializable{

    public void createPolicy(Map<String, ? extends Object> paramMap) throws SQLException {
        
               
        Long clientId = new ClientSearchBean().getClient((String) paramMap.get("national_id")).getId();

        String policyNumber = new GeneratePolicyNumberBean().generatePolicyNumber();


        PreparedStatement sqlStmt = MysqlDatabase.getInstance().getConnection()
        .prepareStatement("insert into policies (start_date, end_date, policy_number, policy_type, client_id) values (?,?,?,?,?)");

        sqlStmt.setString(1, (String) paramMap.get("startDate"));
        sqlStmt.setString(2, (String) paramMap.get("endDate"));
        sqlStmt.setString(3, policyNumber);
        sqlStmt.setString(4, (String) paramMap.get("policy_type"));
        sqlStmt.setLong(5, clientId);

        sqlStmt.executeUpdate();
    }

    

}
