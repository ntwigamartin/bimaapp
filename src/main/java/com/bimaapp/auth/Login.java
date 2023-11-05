package com.bimaapp.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();

        if (session.getAttribute("LoggedInId") != null) {
            resp.sendRedirect("./home");
        }

        resp.sendRedirect("./");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{

        PrintWriter writer = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username != null && password != null) {
            if (username.equals("admin") && password.equals("123")) {

                HttpSession session = req.getSession(true);
                session.setAttribute("user", username);
                session.setAttribute("LoggedInId", LocalDateTime.now());

                resp.sendRedirect("./home");
            }
        }else {
            writer.print("Please enter a username and password");
        }
    }
}
