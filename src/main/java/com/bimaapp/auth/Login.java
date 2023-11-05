package com.bimaapp.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{

        PrintWriter writer = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username != null && password != null) {
            if (username.equals("admin") && password.equals("123")) {
                resp.sendRedirect("./home");
            }
        }else {
            writer.print("Please enter a username and password");
        }
    }
}
