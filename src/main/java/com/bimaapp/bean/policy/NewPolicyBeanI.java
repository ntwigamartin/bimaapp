package com.bimaapp.bean.policy;

import java.sql.SQLException;
import java.util.Map;


public interface NewPolicyBeanI {
    void createPolicy(Map<String, ? extends Object> requestMap) throws SQLException;
}
