package com.bimaapp.app.action.useraction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bimaapp.app.action.BaseAction;
import com.bimaapp.app.bean.userbean.UserRegisterBean;
import com.bimaapp.app.bean.userbean.UserRegisterBeanI;
import com.bimaapp.app.model.User;

@WebServlet("/register")
public class UserRegisterAction extends BaseAction{

    @EJB
    UserRegisterBeanI userRegisterBean;
        
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/user_register.jsp");
        dispatcher.forward(req, resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter writer = resp.getWriter();
        User user = new User();

        serializeForm(user, req.getParameterMap());

        try {
            if (userRegisterBean.createUser(user, req.getParameter("confirmpassword"))) {
                resp.sendRedirect("./");
            }else {
                writer.print("<html><body>passwords do not match.<a href=\"./register\">Try again</a></body></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
