package com.bimaapp.app.action.clientaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.app.action.BaseAction;
import com.bimaapp.app.bean.clientbean.ClientSearchBean;
import com.bimaapp.app.bean.helperbean.GeneratePolicyNumberBean;
import com.bimaapp.app.bean.policybean.NewPolicyBeanI;
import com.bimaapp.app.model.Client;
import com.bimaapp.app.model.Policy;
import com.bimaapp.enums.PolicyType;


@WebServlet("/client")
public class ClientPoliciesAction extends BaseAction{

    @EJB
    NewPolicyBeanI newPolicyBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_policies.jsp");
        dispatcher.forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, String> paramMap = new HashMap<>();

        Client client = new ClientSearchBean().getClient(req.getParameter("national_id"));
        String policyNumber = new GeneratePolicyNumberBean().generatePolicyNumber();
        PolicyType policyType = Enum.valueOf(PolicyType.class, req.getParameter("policy_type"));
        Policy policy = new Policy();
        serializeForm(policy, req.getParameterMap());
        policy.setClient(client);
        policy.setPolicyType(policyType);
        policy.setNumber(policyNumber);

        // newPolicyBean.addOrUpdate(policy);

        System.out.println("***********" + policy + "***********");

        for (String paramName : req.getParameterMap().keySet()) {
            String paramValue = req.getParameter(paramName);

            paramMap.put(paramName, paramValue);
        }
        
        try {
            newPolicyBean.createPolicy(paramMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_policies.jsp");
        dispatcher.forward(req, resp);
    }
}
