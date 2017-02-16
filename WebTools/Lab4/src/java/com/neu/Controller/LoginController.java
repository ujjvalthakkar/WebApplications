/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.Controller;

import com.neu.DAO.DAO;
import com.neu.bean.MessageBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Manasi Laddha
 */
public class LoginController extends HttpServlet {

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

        /* TODO output your page here. You may use following sample code. */
        HttpSession session = request.getSession();
        if (request.getRequestURI().endsWith("logout.htm")) {
            session.invalidate();
            response.sendRedirect("index.jsp");
        } else if (request.getRequestURI().endsWith("login.htm")) {
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            //Instantiate JDBC object
            //Load the driver
            //Establish the connection to the database
            //Create the statement object to pass the SQL query to the database
            //Process the result
            //First we will try statement object
            //This may cause SQL injection
            //Do not use this
            //Unless you sanitize user input for SQL injection
            //Do the same thing with PreparedStatement
            //SQL injection is not possible with PreparedStatement

            try {
                //This can be retrive from web.xml
                //It would be easier to change.
                String driver=getServletContext().getInitParameter("driver");
                String dburl=getServletContext().getInitParameter("dburl");
                String dbuser=getServletContext().getInitParameter("dbuser");
                String pwd=getServletContext().getInitParameter("password");
                
                Class.forName("com.mysql.jdbc.Driver");
                //Connection connection = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/usersdb", "student", "p@ssw0rd");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usersdb", "root", "admin");
                System.out.println("Connection>>>>" + connection);
                //connection=DAO.establishedConnectionJDBC();
                //Statement st;//Warning! It's old do not use it.SQL injection is possible.
                PreparedStatement st;
                //String query = "select * from userstable where UserName = '" + user + "' and UserPassword='" + password + "'";
                //select * from userstable 
                // where UserName = ‘superman' or 1=1;-- ’ and UserPassword=’anything’
                String query = "select * from userstable where UserName = ? and UserPassword= ?";
                //st = connection.createStatement();
                st = connection.prepareStatement(query);
                st.setString(1, user);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    query = "select * from messages where UserName = ?";
                    if (connection != null) {
                        st = connection.prepareStatement(query);
                        st.setString(1, user);
                        ResultSet resultMessage = st.executeQuery();
                        ArrayList<MessageBean> messageBeanList = new ArrayList<>();
                        while (resultMessage.next()) {
                            MessageBean m = new MessageBean();
                            m.setFromUser(resultMessage.getString("fromUser"));
                            m.setMessage(resultMessage.getString("message"));
                            m.setMessageDate(resultMessage.getString("messageDate"));
                            m.setMessageId(resultMessage.getString("messageId"));
                            m.setUserName(resultMessage.getString("userName"));
                            messageBeanList.add(m);
                        }
                        session.setAttribute("userName", user);
                        session.setAttribute("messageList", messageBeanList);
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/userhome.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException! " + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("SQLException! " + ex.getMessage());
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
    }// </editor-fold>

}
