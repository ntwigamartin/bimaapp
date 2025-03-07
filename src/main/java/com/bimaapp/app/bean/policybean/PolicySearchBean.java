package com.bimaapp.app.bean.policybean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.persistence.EnumType;

import com.bimaapp.app.bean.clientbean.ClientSearchBean;
import com.bimaapp.app.model.Client;
import com.bimaapp.app.model.Policy;
import com.bimaapp.database.MysqlDatabase;
import com.bimaapp.enums.PolicyType;

public class PolicySearchBean implements PolicySearchBeanI, Serializable{

    List<Policy> policies = retrieveDbPolicies();

    @Override
    public List<Policy> getClientPolicies(String paramValue) {
        
        List<Policy> clientPolicies = new ArrayList<>();

        for (Policy policy : policies) {
            if (policy.getClient().getNationalId().equals(paramValue)){
                clientPolicies.add(policy);
            }
        }
        return clientPolicies;
    }

    @Override
    public Policy getPolicy(String paramValue) {
        for (Policy policy : policies) {
            if(policy.getNumber().equals(paramValue)) {
                return policy;
            }
        }
        return null;
    }

    public Policy getPolicy(long policy_id) {
        
        for (Policy policy : policies) {
            if (policy.getId() == policy_id) {
                return policy;
            }
        }
        return null;
    }


    @Override
    public List<Policy> searchPolicies(String query) {
        return policies.stream()
            .filter(policy -> policy.getNumber().contains(query))
            .collect(Collectors.toList());
    }

    public List<Policy> retrieveDbPolicies() {
        List<Policy> dbPolicies = new ArrayList<>();
        String sqlQuery = "select * from policies;";

        try {
            Statement sqlStmt = MysqlDatabase.getConnection()
            .createStatement();

            ResultSet results = sqlStmt.executeQuery(sqlQuery);
            while (results.next()) {
                long id = results.getLong("id");
                String startDate = results.getString("start_date");
                String endDate = results.getString("end_date");
                String policyNum = results.getString("policy_number");
                String dbPolicyType = results.getString("policy_type");
                PolicyType policyType = getPolicyType(dbPolicyType);
                String clientId = results.getString("client_id");
                Client client = new ClientSearchBean().getClient(clientId);

                dbPolicies.add(new Policy(id, startDate, endDate, policyNum, policyType, client));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbPolicies;
    }

    public PolicyType getPolicyType(String paramValue) {
        if (paramValue.equalsIgnoreCase("private")) {
            return PolicyType.PRIVATE;
        }else if (paramValue.equalsIgnoreCase("commercial")) {
            return PolicyType.COMMERCIAL;
        }else {
            return null;
        }
    }

}
