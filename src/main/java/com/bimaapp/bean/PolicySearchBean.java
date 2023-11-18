package com.bimaapp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bimaapp.database.Database;
import com.bimaapp.model.CoverDetail;
import com.bimaapp.model.Policy;

public class PolicySearchBean implements PolicySearchBeanI, Serializable{

    List<Policy> policies = Database.getDbInstance().getPolicies();

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
 
}
