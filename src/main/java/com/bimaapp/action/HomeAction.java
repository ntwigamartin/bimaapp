package com.bimaapp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeAction extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/jsp/home.jsp");
            dispatcher.forward(req, resp);
           
    }
   
}
