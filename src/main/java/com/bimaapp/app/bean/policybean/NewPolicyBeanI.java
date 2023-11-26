package com.bimaapp.app.bean.policybean;

import java.sql.SQLException;
import java.util.Map;

import com.bimaapp.app.bean.GenericBeanI;
import com.bimaapp.app.model.Policy;


public interface NewPolicyBeanI extends GenericBeanI<Policy> {
    void createPolicy(Map<String, ? extends Object> requestMap) throws SQLException;
}
