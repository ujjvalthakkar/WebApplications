/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ujjval.servlets;

import com.ujjval.beans.Book;
import com.ujjval.constants.Constants;
import com.ujjval.dao.ConnDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ujjva
 */
public class booksServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Book Store</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcomme to our Book Store</h1>");
            out.println("<p> Please make your selection below</p>");
            out.println("<form name=\"booksForm\" action=\"booksServlet\" method=\"POST\">\n"
                    + "            <select name=\"booksOption\">\n"
                    + "                <option>Browse Books</option>\n"
                    + "                <option>Add New Books to DB</option>\n"
                    + "            </select>\n"
                    + "            <input type=\"hidden\" name=\"path\" value=\"booksServlet\"/>\n"
                    + "  <input type=\"submit\" value=\"Send\" name=\"books\" />\n"
                    + "        </form>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession();
        String path = "";
        if (request.getParameter("path").equals("booksServlet")) {
            if (request.getParameter("booksOption").equals("Browse Books")) {
                path = "1";
                try {
                    Connection conn = null;
                    Class.forName(Constants.driver);
                    conn = DriverManager.getConnection(Constants.bookurl, Constants.user, Constants.pass);
                    String query = "Select * from books";
                    Statement st = conn.createStatement();
                    ResultSet result = st.executeQuery(query);
                    ArrayList<Book> bookList = new ArrayList<Book>();
                    while (result.next()) {
                        Book b = new Book();
                        b.setIsbn(result.getString("isbn"));
                        b.setTitle(result.getString("title"));
                        b.setAuthors(result.getString("authors"));
                        b.setPrice(Float.parseFloat(result.getString("price")));
                        bookList.add(b);
                    }
                    request.setAttribute("bookList", bookList);
                    request.setAttribute("path", path);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/books.jsp");
                    rd.forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(booksServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(booksServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                path = "2";
                request.setAttribute("path", path);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/books.jsp");
                rd.forward(request, response);
            }

        }
        if (request.getParameter("path").equals("books.jsp")) {
            if (request.getParameter("formName").equals("addBookForm")) {
                path = "3";
                request.setAttribute("path", path);
                request.setAttribute("numberOfBooks", request.getParameter("number"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/books.jsp");
                rd.forward(request, response);
            }

            if (request.getParameter("formName").equals("addBooksForm")) {
                int n = Integer.parseInt(request.getParameter("numberOfBooks"));
                int result = 0;
                try {
                    Connection conn = null;
                    Class.forName(Constants.driver);
                    conn = DriverManager.getConnection(Constants.bookurl, Constants.user, Constants.pass);

                    for (int i = 1; i <= n; i++) {
                        String query = "INSERT INTO books(isbn,title,authors,price) VALUES(?,?,?,?)";
                        PreparedStatement pst = conn.prepareStatement(query);
                        pst.setString(1, request.getParameter("isbn" + i));
                        pst.setString(2, request.getParameter("title" + i));
                        pst.setString(3, request.getParameter("author" + i));
                        pst.setFloat(4, Float.parseFloat(request.getParameter("price" + i)));
                        result = pst.executeUpdate();
                    }
                    if (result > 0) {
                        request.setAttribute("number", n);
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/booksAdded.jsp");
                        rd.forward(request, response);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(booksServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(booksServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
