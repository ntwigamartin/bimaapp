package com.bimaapp.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bimaapp.database.Database;
import com.bimaapp.model.User;

public class LoginBean implements Serializable {

    public static boolean loginUser(HttpServletRequest req, HttpServletResponse resp) {
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

                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

}
