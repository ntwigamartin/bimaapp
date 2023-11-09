package com.bimaapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.bean.UserRegisterBean;

@WebServlet("/register")
public class UserRegisterAction extends HttpServlet{
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/user_register.jsp");
        dispatcher.forward(req, resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter writer = resp.getWriter();

        if (UserRegisterBean.createUser(req)) {
            resp.sendRedirect("./");
        }else {
            writer.print("<html><body>passwords do not match.<a href=\"./register\">Try again</a></body></html>");
        }
    }
}
