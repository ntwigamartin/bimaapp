package com.bimaapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bimaapp.bean.LoginBean;
import com.bimaapp.bean.LoginBeanI;
import com.bimaapp.model.User;

@WebServlet("/login")
public class LoginAction extends BaseAction {

    LoginBeanI loginBean = new LoginBean();
    User user = new User();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("./home");

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        serializeForm(user, req.getParameterMap());
        
        if (loginBean.authenticate(user)) {

            HttpSession session = req.getSession(true);
            session.setAttribute("user", user.getUsername());
            session.setAttribute("loggedInId", LocalDateTime.now().toString());

            Cookie cookie = new Cookie("user_id", UUID.randomUUID().toString());
            resp.addCookie(cookie);
            // cookie.setMaxAge(3600)

            resp.sendRedirect("./home");

        } else {
            writer.print("<html><body>Invalid username or password. <a href=\"./login\">Login Again</a></body></html>");
        }
    }
}
