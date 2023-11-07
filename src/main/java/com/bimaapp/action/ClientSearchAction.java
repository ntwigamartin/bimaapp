package com.bimaapp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
}
