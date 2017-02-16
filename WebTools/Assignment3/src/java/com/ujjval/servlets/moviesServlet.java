/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ujjval.servlets;

import com.ujjval.beans.Movie;
import com.ujjval.constants.Constants;
import com.ujjval.dao.ConnDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class moviesServlet extends HttpServlet {

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
            out.println("<title>Servlet moviesServlet</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n"
                    + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("</head>");
            out.println("<body style=\"background-color: #80CBC4;\"><div class=\"container\">");
            out.println("<h1> Welcome to our Movie Store</h1>");
            out.println("<h2><p style=\"background-color: #80CBC4;\"> Please make your selection below</p></h2>");
            out.println("<form name=\"moviesForm\" action=\"moviesServlet\" method=\"POST\">\n"
                    + "            <select name=\"moviesOption\">\n"
                    + "                <option>Browse Movies</option>\n"
                    + "                <option>Add New movie to DB</option>\n"
                    + "            </select>\n"
                    + "            <input type=\"hidden\" name=\"path\" value=\"moviesServlet\"/>\n"
                    + "  <input type=\"submit\" value=\"Send\" name=\"movies\" />\n"
                    + "        </form></div>");
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
        if (request.getParameter("path").equals("moviesServlet")) {
            String path = "";
            if (request.getParameter("moviesOption").equals("Browse Movies")) {
                path = "1";
            } else {
                path = "2";
            }
            request.setAttribute("path", path);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/movies.jsp");
            //RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/movies.jsp");
            rd.forward(request, response);
        }
        if (request.getParameter("path").equals("movies.jsp")) {
            if (request.getParameter("formName").equals("searchMovieForm")) {

                try {
                    Connection conn = ConnDAO.getConnection();
                    String queryColumn = "";
                    if (request.getParameter("searchBy").equals("Search by Title")) {
                        queryColumn = "title";
                    } else if (request.getParameter("searchBy").equals("Search by Actor")) {
                        queryColumn = "actor";
                    } else if (request.getParameter("searchBy").equals("Search by Actress")) {
                        queryColumn = "actress";
                    }
                    String query = "Select * from movies where " + queryColumn + " like ?";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, "%" + request.getParameter("keyword") + "%");
                    ResultSet result = pst.executeQuery();
                    ArrayList<Movie> movieList = new ArrayList<>();
                    while (result.next()) {
                        Movie m = new Movie();
                        m.setTitle(result.getString("title"));
                        m.setActor(result.getString("actor"));
                        m.setActress(result.getString("actress"));
                        m.setGenre(result.getString("genre"));
                        m.setYear(result.getInt("year"));
                        movieList.add(m);
                    }
                    session.setAttribute("keyword", request.getParameter("keyword"));
                    session.setAttribute("criteria", queryColumn);
                    session.setAttribute("movieList", movieList);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/movieBrowse.jsp");
                    rd.forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(moviesServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(moviesServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (request.getParameter("formName").equals("addMovieForm")) {

                try {
                    Connection conn = ConnDAO.getConnection();
                    String query = "INSERT INTO movies(title,actor,actress,genre,year) VALUES(?,?,?,?,?)";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, request.getParameter("movieTitle"));
                    pst.setString(2, request.getParameter("leadActor"));
                    pst.setString(3, request.getParameter("leadActress"));
                    pst.setString(4, request.getParameter("movieGenre"));
                    pst.setInt(5, Integer.parseInt(request.getParameter("movieYear")));
                    int result = pst.executeUpdate();
                    if (result > 0) {
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/movieAdded.jsp");
                        rd.forward(request, response);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(moviesServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(moviesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
