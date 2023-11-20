package com.bimaapp.app.bean.policy;

import java.util.List;

import com.bimaapp.app.model.Policy;

public interface PolicySearchBeanI {
    List<Policy> getClientPolicies(String paramValue);
    Policy getPolicy(String paramValue);
    List<Policy> searchPolicies(String paramValue);
}
