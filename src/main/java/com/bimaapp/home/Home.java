package com.bimaapp.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class Home extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException{

        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();

        ServletContext ctx = req.getServletContext();

        if (session.getAttribute("LoggedInId") != null) {
                writer.print("<!DOCTYPE html>\n" + //
                "<html>\n" + //
                "<head>\n" + //
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + //
                "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" + //
                "<style>\n" + //
                "body {font-family: \"Lato\", sans-serif;}\n" + //
                "\n" + //
                ".sidebar {\n" + //
                "  height: 100%;\n" + //
                "  width: 160px;\n" + //
                "  position: fixed;\n" + //
                "  z-index: 1;\n" + //
                "  top: 0;\n" + //
                "  left: 0;\n" + //
                "  background-color: #111;\n" + //
                "  overflow-x: hidden;\n" + //
                "  padding-top: 16px;\n" + //
                "}\n" + //
                "\n" + //
                ".sidebar a {\n" + //
                "  padding: 6px 8px 6px 16px;\n" + //
                "  text-decoration: none;\n" + //
                "  font-size: 20px;\n" + //
                "  color: #818181;\n" + //
                "  display: block;\n" + //
                "}\n" + //
                "\n" + //
                ".sidebar a:hover {\n" + //
                "  color: #f1f1f1;\n" + //
                "}\n" + //
                "\n" + //
                ".main {\n" + //
                "  margin-left: 160px; /* Same as the width of the sidenav */\n" + //
                "  padding: 0px 10px;\n" + //
                "}\n" + //
                "\n" + //
                "@media screen and (max-height: 450px) {\n" + //
                "  .sidebar {padding-top: 15px;}\n" + //
                "  .sidebar a {font-size: 18px;}\n" + //
                "}\n" + //
                "</style>\n" + //
                "</head>\n" + //
                "<body>\n" + //
                "\n" + //
                "<div class=\"sidebar\">\n" + //
                "  <a href=\"#home\"><i class=\"fa fa-fw fa-home\"></i> Home</a>\n" + //
                "  <a href=\"#clients\"><i class=\"fa fa-fw fa-user\"></i> Clients</a>\n" + //
                "  <a href=\"#underwriting\"><i class=\"fa fa-fw fa-wrench\"></i> Policy</a>\n" + //
                "  <a href=\"#claims\"><i class=\"fa fa-fw fa-wrench\"></i> Claims</a>\n" + //
                "  <a href=\"./logout\"><i class=\"fa fa-fw fa-wrench\"></i> Logout</a>\n" + //
                "</div>\n" + //
                "\n" + //
                "<div class=\"main\">\n" + //
                "<p>Welcome</p>\n" + //
                ctx.getInitParameter("Welcome") + "<br>\n" + "<span>User: </span>\n" +
                session.getAttribute("user") + "\n" + "<br>\n" + session.getAttribute("LoggedInId") + //
                "</div>\n" + //
                "     \n" + //
                "</body>\n" + //
                "</html> \n" + //
                "");
        }else {
            resp.sendRedirect("./");
        }
        

    }
   
}
