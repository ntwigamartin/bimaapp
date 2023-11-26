package com.bimaapp.app.bean.policybean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.bimaapp.app.bean.GenericBean;
import com.bimaapp.app.bean.clientbean.ClientSearchBean;
import com.bimaapp.app.bean.helperbean.GeneratePolicyNumberBean;
import com.bimaapp.app.model.Policy;
import com.bimaapp.database.MysqlDatabase;

@Stateless
@Remote
public class NewPolicyBean extends GenericBean<Policy> implements NewPolicyBeanI{


    public void createPolicy(Map<String, ? extends Object> paramMap) throws SQLException {
        
               
        Long clientId = new ClientSearchBean().getClient((String) paramMap.get("national_id")).getId();

        String policyNumber = new GeneratePolicyNumberBean().generatePolicyNumber();


        PreparedStatement sqlStmt = MysqlDatabase.getConnection()
        .prepareStatement("insert into policies (start_date, end_date, policy_number, policy_type, client_id) values (?,?,?,?,?)");

        sqlStmt.setString(1, (String) paramMap.get("startDate"));
        sqlStmt.setString(2, (String) paramMap.get("endDate"));
        sqlStmt.setString(3, policyNumber);
        sqlStmt.setString(4, (String) paramMap.get("policy_type"));
        sqlStmt.setLong(5, clientId);

        sqlStmt.executeUpdate();
    }

    

}
