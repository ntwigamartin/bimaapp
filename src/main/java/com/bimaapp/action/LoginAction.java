package com.bimaapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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
public class LoginAction extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        resp.sendRedirect("./home");
        
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
                    session.setAttribute("loggedInId", LocalDateTime.now().toString());

                    Cookie cookie = new Cookie("user_id", UUID.randomUUID().toString());
                    resp.addCookie(cookie);
                    // cookie.setMaxAge(3600);

                    resp.sendRedirect("./home");
                }
            }
            writer.print("<html><body>Invalid username or password. <a href=\"./login\">Login Again</a></body></html>");
        }else {
            writer.print("<html><body>Please enter a username and password</body></html>");
        }
    }
}
