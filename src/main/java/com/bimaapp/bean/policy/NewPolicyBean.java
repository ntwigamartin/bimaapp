package com.bimaapp.bean.policy;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bimaapp.bean.client.ClientSearchBean;
import com.bimaapp.database.Database;
import com.bimaapp.database.MysqlDatabase;
import com.bimaapp.enums.PolicyType;
import com.bimaapp.model.Client;
import com.bimaapp.model.Policy;

public class NewPolicyBean implements NewPolicyBeanI, Serializable{

    public void createPolicy(Map<String, ? extends Object> paramMap) throws SQLException {
        
        System.out.println("******************");
        System.out.println(new ClientSearchBean().getClient((String) paramMap.get("national_id")));
        System.out.println("******************");
       
        Long clientId = new ClientSearchBean().getClient((String) paramMap.get("national_id")).getId();

        String policyNumber = new GeneratePolicyNumberBean().generatePolicyNumber();

        // Database.getDbInstance().getPolicies().add(new Policy(startDate, endDate, policyNumber, policyType, client));

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
