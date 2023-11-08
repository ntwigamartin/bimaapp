package com.bimaapp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bimaapp.bean.NewPolicyBean;

@WebServlet("/policies")
public class PolicySearch extends HttpServlet{
    
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("LoggedInId") != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/policy_search.jsp");
            dispatcher.forward(req, resp);

        } else {
            resp.sendRedirect("./");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();



        if (session.getAttribute("LoggedInId") != null) {
            System.out.println(req.getParameter("national_id"));
            NewPolicyBean.createPolicy(req);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/policy_search.jsp");
            dispatcher.forward(req, resp);

        } else {
            resp.sendRedirect("./");
        }
    }
}
