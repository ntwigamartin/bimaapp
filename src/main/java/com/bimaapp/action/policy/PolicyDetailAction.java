package com.bimaapp.action.policy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.action.BaseAction;
import com.bimaapp.bean.policy.NewPolicyDetailBean;
import com.bimaapp.bean.policy.NewPolicyDetailBeanI;

@WebServlet("/policy")
public class PolicyDetailAction extends BaseAction{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/policy_detail.jsp");
        dispatcher.forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
        NewPolicyDetailBeanI newPolicyDetailBean = new NewPolicyDetailBean();
        Map<String, String> paramMap = new HashMap<>();

        for (String paramName : req.getParameterMap().keySet()) {
            String paramValue = req.getParameter(paramName);

            paramMap.put(paramName, paramValue);
        }

        newPolicyDetailBean.createCoverDetail(paramMap);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/policy_detail.jsp");
        dispatcher.forward(req, resp);

    }
}

