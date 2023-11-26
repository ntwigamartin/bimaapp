package com.bimaapp.app.action.clientaction;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.app.action.BaseAction;
import com.bimaapp.app.bean.clientbean.NewClientBeanI;
import com.bimaapp.app.model.Client;

@WebServlet("/clients")
public class ClientSearchAction extends BaseAction {

    @EJB
    NewClientBeanI newClientBean;
    

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_search.jsp");
        dispatcher.forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Client client = new Client();
        
        serializeForm(client, req.getParameterMap());
        newClientBean.addOrUpdate(client);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_search.jsp");
        dispatcher.forward(req, resp);

    }
}
