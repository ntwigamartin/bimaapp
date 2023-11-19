package com.bimaapp.action.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.bean.policy.NewPolicyBean;
import com.bimaapp.bean.policy.NewPolicyBeanI;


@WebServlet("/client")
public class ClientDetailAction extends HttpServlet{

    NewPolicyBeanI newPolicyBean = new NewPolicyBean();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_detail.jsp");
        dispatcher.forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, String> paramMap = new HashMap<>();

        for (String paramName : req.getParameterMap().keySet()) {
            String paramValue = req.getParameter(paramName);

            paramMap.put(paramName, paramValue);
        }

        newPolicyBean.createPolicy(paramMap);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_detail.jsp");
        dispatcher.forward(req, resp);
    }
}
