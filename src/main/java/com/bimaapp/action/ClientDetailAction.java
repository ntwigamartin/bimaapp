package com.bimaapp.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.bean.ClientSearchBean;
import com.bimaapp.bean.NewPolicyBean;
import com.bimaapp.bean.NewPolicyBeanI;


@WebServlet("/client")
public class ClientDetailAction extends HttpServlet{

    NewPolicyBeanI newPolicyBean = new NewPolicyBean();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_detail.jsp");
        dispatcher.forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println();
        System.out.println();
        System.out.println(req.getParameter("national_id"));
        System.out.println();
        System.out.println(new ClientSearchBean().getClient(req.getParameter("national_id")));
        System.out.println();
        newPolicyBean.createPolicy(req);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_detail.jsp");
        dispatcher.forward(req, resp);
    }
}
