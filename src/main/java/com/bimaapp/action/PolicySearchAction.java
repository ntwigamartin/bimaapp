package com.bimaapp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.bean.NewPolicyBean;
import com.bimaapp.bean.NewPolicyBeanI;

@WebServlet("/policies")
public class PolicySearchAction extends HttpServlet{

    NewPolicyBeanI newPolicyBean = new NewPolicyBean();
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/policy_search.jsp");
        dispatcher.forward(req, resp);

    }

    
}
