package com.bimaapp.bean.policy;

import java.sql.SQLException;
import java.util.Map;

import com.bimaapp.enums.PolicyType;

public interface NewPolicyBeanI {
    void createPolicy(Map<String, ? extends Object> requestMap) throws SQLException;
}
