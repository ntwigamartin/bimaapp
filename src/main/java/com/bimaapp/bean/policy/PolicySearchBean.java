package com.bimaapp.bean.policy;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bimaapp.bean.client.ClientSearchBean;
import com.bimaapp.database.Database;
import com.bimaapp.database.MysqlDatabase;
import com.bimaapp.enums.PolicyType;
import com.bimaapp.model.Client;
import com.bimaapp.model.CoverDetail;
import com.bimaapp.model.Policy;

public class PolicySearchBean implements PolicySearchBeanI, Serializable{

    // List<Policy> policies = Database.getDbInstance().getPolicies();
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

    @Override
    public List<CoverDetail> getPolicyCoverDetails(String paramValue) {
        List<CoverDetail> coverDetails = Database.getDbInstance().getCoverDetails();
        List<CoverDetail> policyCoverDetails = new ArrayList<CoverDetail>();

        for (CoverDetail coverDetail : coverDetails) {
            if (coverDetail.getPolicy().getNumber().equals(paramValue)) {
                policyCoverDetails.add(coverDetail);
            }
        }

        return policyCoverDetails;
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
            Statement sqlStmt = MysqlDatabase.getInstance().getConnection()
            .createStatement();

            ResultSet results = sqlStmt.executeQuery(sqlQuery);
            while (results.next()) {
                String startDate = results.getString("start_date");
                String endDate = results.getString("end_date");
                String policyNum = results.getString("policy_number");
                String dbPolicyType = results.getString("policy_type");
                PolicyType policyType = getPolicyType(dbPolicyType);
                String clientId = results.getString("client_id");
                Client client = getClient(clientId);

                dbPolicies.add(new Policy(startDate, endDate, policyNum, policyType, client));
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

    
    public Client getClient(String paramValue) {
        Long id = Long.parseLong(paramValue);
        List<Client> dbClients = new ClientSearchBean().retrieveDbClients();
        for (Client client : dbClients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
 
}
