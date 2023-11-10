package com.bimaapp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.bean.NewClientBean;
import com.bimaapp.bean.NewClientBeanI;
import com.bimaapp.model.Client;

@WebServlet("/clients")
public class ClientSearchAction extends BaseAction {

    NewClientBeanI newClientBean = new NewClientBean();
    Client client = new Client();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_search.jsp");
        dispatcher.forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
       
        serializeForm(client, req.getParameterMap());
        newClientBean.createClient(client);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_search.jsp");
        dispatcher.forward(req, resp);

    }
}
