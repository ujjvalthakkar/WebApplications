/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Manasi Laddha
 */
public class MessageController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getRequestURI().endsWith("reply.htm")) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reply.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().endsWith("sendmessage.htm")) {
            //read the fields and insert into messages
            String message = request.getParameter("message");
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("userName");
            String recipient = request.getParameter("to");
            try {
                //This can be retrive from web.xml
                //It would be easier to change.
                String driver = getServletContext().getInitParameter("driver");
                String dburl = getServletContext().getInitParameter("dburl");
                String dbuser = getServletContext().getInitParameter("dbuser");
                String pwd = getServletContext().getInitParameter("password");

                Class.forName(driver);
                //Connection connection = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/usersdb", "student", "p@ssw0rd");
                Connection connection = DriverManager.getConnection(dburl, dbuser, pwd);
                //Date d = (Date) new java.util.Date();
                Date d = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                String messageDate = format.format(d);
               
                String query = "insert into messages(userName,fromUser,message,messageDate) VALUES('" + recipient + "','" + username + "','" + message + "','" + messageDate + "')";
                Statement statement = connection.createStatement();
                int result = statement.executeUpdate(query);
                if (result > 0) {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/messageSent.jsp");
                    rd.forward(request, response);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("SQLException " + e.getMessage());
            }
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
