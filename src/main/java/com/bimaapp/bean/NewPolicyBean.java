package com.bimaapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bimaapp.database.Database;
import com.bimaapp.enums.PolicyType;
import com.bimaapp.model.Client;
import com.bimaapp.model.Policy;

public class NewPolicyBean implements NewPolicyBeanI, Serializable{

    public void createPolicy(HttpServletRequest req) {
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        PolicyType policyType = getPolicyType(req.getParameter("policy_type"));
        Client client = new ClientSearchBean().getClient(req.getParameter("national_id"));
        String policyNumber = generatePolicyNumber();

        Database.getDbInstance().getPolicies().add(new Policy(startDate, endDate, policyNumber, policyType, client));
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

    public String generatePolicyNumber() {
        List<Policy> policies = Database.getDbInstance().getPolicies();
        String policyStr = policies.get(policies.size() - 1).getNumber();
        int policyNum = Integer.parseInt(policyStr);
        int newPolicyNumber = policyNum + 1;

        String generatedPolicyNum = newPolicyNumber + "";

        return generatedPolicyNum;
    }
}
