package com.bimaapp.bean;

import javax.servlet.http.HttpServletRequest;

import com.bimaapp.enums.PolicyType;
import com.bimaapp.model.Client;

public interface NewPolicyBeanI {
    void createPolicy(HttpServletRequest req);
    PolicyType getPolicyType(String paramValue);
    Client getClient(String paramValue);
    String generatePolicyNumber();
}
