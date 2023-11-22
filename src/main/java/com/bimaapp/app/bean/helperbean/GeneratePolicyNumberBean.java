package com.bimaapp.app.bean.helperbean;

import java.io.Serializable;
import java.util.List;

import com.bimaapp.app.bean.policybean.PolicySearchBean;
import com.bimaapp.app.model.Policy;

public class GeneratePolicyNumberBean implements GeneratePolicyNumberBeanI, Serializable{

    @Override
    public String generatePolicyNumber() {
        List<Policy> policies = new PolicySearchBean().retrieveDbPolicies();

        if (policies.size() > 0) {
            String policyStr = policies.get(policies.size() - 1).getNumber();
            int policyNum = Integer.parseInt(policyStr);
            int newPolicyNumber = policyNum + 1;

            String generatedPolicyNum = newPolicyNumber + "";

            return generatedPolicyNum;
        }
        
        return "1001";
    }
    
}
