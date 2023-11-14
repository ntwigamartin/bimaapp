package com.bimaapp.bean;

import java.util.List;

import com.bimaapp.model.CoverDetail;
import com.bimaapp.model.Policy;

public interface PolicySearchBeanI {
    List<Policy> getClientPolicies(String paramValue);
    Policy getPolicy(String paramValue);
    List<CoverDetail> getPolicyCoverDetails(String paramValue);
}
