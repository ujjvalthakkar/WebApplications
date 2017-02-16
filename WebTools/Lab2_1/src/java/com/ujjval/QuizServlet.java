/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ujjval;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ujjva
 */
public class QuizServlet extends HttpServlet {

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
            out.println("<title>Servlet QuizServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Question1</h1>");
            out.println("<form method='post' action='quiz.html'>");
            out.println("<input type='hidden' name='page' value='1'/>");
            out.println("<p>This is the First Question</p>");
            out.println("<input type=\"radio\" name=\"ans\" value=\"get\">Get");
            out.println("<input type=\"radio\" name=\"ans\" value=\"post\">Post");
            out.println("<input type=\"radio\" name=\"ans\" value=\"add\">Add");
            out.println("<input type=\"radio\" name=\"ans\" value=\"delete\">Delete<br>");
            out.println("<input type='submit' value='Next'/>");
            out.println("</form>");
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
        int page = Integer.parseInt(request.getParameter("page"));
        if (page == 1) {
            String ans = request.getParameter("ans");
            session.setAttribute("Answer1", ans);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet QuizServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Question2</h1>");
                out.println("<form method='post' action='quiz.html'>");
                out.println("<input type='hidden' name='page' value='2'/>");
                out.println("<p>This is the Second Question</p>");
                out.println("<input type=\"radio\" name=\"ans\" value=\"get1\">Get1");
                out.println("<input type=\"radio\" name=\"ans\" value=\"post1\">Post1");
                out.println("<input type=\"radio\" name=\"ans\" value=\"add1\">Add1");
                out.println("<input type=\"radio\" name=\"ans\" value=\"delete1\">Delete1<br><br>");
                out.println("<input type='submit' value='Next'/>");
                out.println("</form><br>");
                out.println("<button type=\"button\" name=\"back\" onclick=\"history.back()\">Back</button>");
                out.println("</body>");
                out.println("</html>");
            }
        } else if (page == 2) {
            String ans = request.getParameter("ans");
            session.setAttribute("Answer2", ans);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet QuizServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Question3</h1>");
                out.println("<form method='post' action='quiz.html'>");
                out.println("<input type='hidden' name='page' value='3'/><br>");
                out.println("<p>This is the Third Question</p>");
                out.println("<input type=\"radio\" name=\"ans\" value=\"get2\">Get2");
                out.println("<input type=\"radio\" name=\"ans\" value=\"post2\">Post2");
                out.println("<input type=\"radio\" name=\"ans\" value=\"add2\">Add2");
                out.println("<input type=\"radio\" name=\"ans\" value=\"delete2\">Delete2<br><br>");
                out.println("<input type='submit' value='Next'/>");
                out.println("</form><br>");
                out.println("<button type=\"button\" name=\"back\" onclick=\"history.back()\">Back</button>");
                out.println("</body>");
                out.println("</html>");
            }
        } else if (page == 3) {
            String ans = request.getParameter("ans");
            session.setAttribute("Answer3", ans);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet QuizServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Your Answers are</h1>");
                String ans1 = (String) session.getAttribute("Answer1");
                String ans2 = (String) session.getAttribute("Answer2");
                String ans3 = (String) session.getAttribute("Answer3");
                out.println("<p>Answer1:"+ans1+"</p>");
                out.println("<p>Answer2:"+ans2+"</p>");
                out.println("<p>Answer3:"+ans3+"</p>");
                out.println("<button type=\"button\" name=\"back\" onclick=\"history.back()\">Back</button>");
                out.println("</body>");
                out.println("</html>");
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
