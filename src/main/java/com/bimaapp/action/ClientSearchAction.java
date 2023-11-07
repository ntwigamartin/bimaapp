package com.bimaapp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bimaapp.database.Database;
import com.bimaapp.model.Client;

@WebServlet("/clients")
public class ClientSearchAction extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("LoggedInId") != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_search.jsp");
            dispatcher.forward(req, resp);

        } else {
            resp.sendRedirect("./");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        String nationalId = req.getParameter("national_id");
        String name = req.getParameter("client_name");
        String telephoneNumber = req.getParameter("telephone_number");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        if (session.getAttribute("LoggedInId") != null) {
            
            Database.getDbInstance().getClients().add(new Client(nationalId, name, telephoneNumber, email, address));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/client_search.jsp");
            dispatcher.forward(req, resp);

        } else {
            resp.sendRedirect("./");
        }
    }
}
