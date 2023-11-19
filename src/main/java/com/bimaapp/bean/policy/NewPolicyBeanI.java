package com.bimaapp.bean.policy;

import java.util.Map;

import com.bimaapp.enums.PolicyType;

public interface NewPolicyBeanI {
    void createPolicy(Map<String, ? extends Object> requestMap);
    PolicyType getPolicyType(String paramValue);
    String generatePolicyNumber();
}
