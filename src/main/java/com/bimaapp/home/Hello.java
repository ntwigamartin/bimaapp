package com.bimaapp.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Hello extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException{
        PrintWriter writer = resp.getWriter();
        writer.print("Hello");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException{
        PrintWriter writer = resp.getWriter();

        String num = req.getParameter("num");

        writer.print(num);
    }
    
}
