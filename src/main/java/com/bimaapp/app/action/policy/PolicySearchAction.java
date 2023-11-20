package com.bimaapp.app.action.policy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.app.bean.policy.NewPolicyBean;
import com.bimaapp.app.bean.policy.NewPolicyBeanI;

@WebServlet("/policies")
public class PolicySearchAction extends HttpServlet{

    NewPolicyBeanI newPolicyBean = new NewPolicyBean();
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/policy_search.jsp");
        dispatcher.forward(req, resp);

    }

    
}
