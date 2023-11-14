package com.bimaapp.bean;

import javax.servlet.http.HttpServletRequest;

import com.bimaapp.enums.PolicyType;

public interface NewPolicyBeanI {
    void createPolicy(HttpServletRequest req);
    PolicyType getPolicyType(String paramValue);
    String generatePolicyNumber();
}
