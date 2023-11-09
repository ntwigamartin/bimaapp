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

import com.bimaapp.database.Database;
import com.bimaapp.enums.UserRole;
import com.bimaapp.model.User;

@WebServlet("/register")
public class UserRegisterAction extends HttpServlet{
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/user_register.jsp");
        dispatcher.forward(req, resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Database db = Database.getDbInstance();
        PrintWriter writer = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmpassword");

        if (password.equals(confirmPassword)) {
            db.getUsers().add(new User(username, confirmPassword, UserRole.NORMAL));
            resp.sendRedirect("./");
        }else {
            writer.print("<html><body>passwords do not match.<a href=\"./register\">Try again</a></body></html>");
        }
    }
}
