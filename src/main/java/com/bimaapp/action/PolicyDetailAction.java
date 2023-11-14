package com.bimaapp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.bean.NewPolicyDetailBean;
import com.bimaapp.bean.NewPolicyDetailBeanI;

@WebServlet("/policy")
public class PolicyDetailAction extends BaseAction{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/policy_detail.jsp");
        dispatcher.forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
        NewPolicyDetailBeanI newPolicyDetailBean = new NewPolicyDetailBean();
        newPolicyDetailBean.createCoverDetail(req);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/policy_detail.jsp");
        dispatcher.forward(req, resp);

    }
}

