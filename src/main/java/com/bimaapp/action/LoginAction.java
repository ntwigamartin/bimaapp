package com.bimaapp.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.bean.LoginBean;

@WebServlet("/login")
public class LoginAction extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        resp.sendRedirect("./home");
        
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{

        PrintWriter writer = resp.getWriter();
    
        if (LoginBean.loginUser(req, resp)) {
            
            resp.sendRedirect("./home");

        }else {
            writer.print("<html><body>Invalid username or password. <a href=\"./login\">Login Again</a></body></html>");
        }
    }
}
