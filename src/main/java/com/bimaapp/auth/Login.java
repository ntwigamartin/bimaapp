package com.bimaapp.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bimaapp.database.Database;
import com.bimaapp.model.User;

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
        Database db = Database.getDbInstance();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        if (username != null && password != null && db.getUsers() != null) {
            for (User user : db.getUsers()) {
                if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {

                    HttpSession session = req.getSession(true);
                    session.setAttribute("user", username);
                    session.setAttribute("LoggedInId", LocalDateTime.now());

                    Cookie cookie = new Cookie("user_id", UUID.randomUUID().toString());
                    resp.addCookie(cookie);

                    resp.sendRedirect("./home");
                }
            }
            writer.print("<html><body>Invalid username or password. <a href=\"./login\">Login Again</a></body></html>");
        }else {
            writer.print("<html><body>Please enter a username and password</body></html>");
        }
    }
}
