package com.neu.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Bean.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dishu
 */
public class CourseSearchServlet extends HttpServlet {

    List<Course> courseList;

    @Override
    public void init() {
//This method will only be call for once
        courseList = new ArrayList<>();
        Course c1 = new Course();
        c1.setCourseDescription("java programming");
        c1.setCrn("36099");
        c1.setInstructor("Khaled M. Bugrara");
        c1.setName("AED");

        Course c2 = new Course();
        c2.setCourseDescription("Course foro learning web technologies used in front end");
        c2.setCrn("37913");
        c2.setInstructor("Yusuf Ozbek");
        c2.setName("Web Design and user exp");

        Course c3 = new Course();
        c3.setCourseDescription("course for learning algorithms");
        c3.setCrn("34267");
        c3.setInstructor("Khaled M. Bugrara");
        c3.setName("Program Structure and Algorithms");

        Course c4 = new Course();
        c4.setCourseDescription("course for learning java EE");
        c4.setCrn("31606");
        c4.setInstructor("Yusuf Ozbek");
        c4.setName("Web Tools");

        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("index.html");
        }

        String searchQuery = request.getParameter("query");
        String searchType = request.getParameter("searchType");

        searchQuery = searchQuery.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();//Regex 

        if (searchQuery.equals("")) {//Validate this in the JS as well
            response.sendRedirect("error.jsp");
        }
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Available Courses are:</title>");
        out.println("</head>");
        out.println("<body><form method='post' action='addCourse.htm'>");
        out.println("<h2> Results found </h2>");
        boolean found = false;

        if (searchType.equals("crn")) {
            for (Course c : courseList) {
                if (c.getCrn().contains(searchQuery)) {
                    found = true;
                    String crn = c.getCrn();
                    String courseName = c.getName();
                    String courseInstructor = c.getInstructor();
                    String courseDesc = c.getCourseDescription();
                    out.println("<input type='checkbox' name = 'course' value='" + crn + "@" + courseName + "@" + courseDesc + "@" + courseInstructor + "'/>" + crn + courseName
                            + "<a href='addCourse.htm?courseId=" + crn + "&name=" + courseName + "&discription=" + courseDesc + "&instructor=" + courseInstructor
                            + "&action=single'> Add this course </a><br>");
                }
            }
        }

        if (searchType.equals("courseInst")) {
            for (Course c : courseList) {
                if (c.getInstructor().toLowerCase().contains(searchQuery.toLowerCase())) {
                    found = true;
                    String crn = c.getCrn();
                    String courseName = c.getName();
                    String courseInstructor = c.getInstructor();
                    String courseDesc = c.getCourseDescription();
                    out.println("<input type='checkbox' name = 'course' value='" + crn + "@" + courseName + "@" + courseDesc + "@" + courseInstructor + "'/>" + crn + courseName
                            + "<a href='addCourse.htm?courseId=" + crn + "&name=" + courseName + "&discription=" + courseDesc + "&instructor=" + courseInstructor
                            + "&action=single'> Add this course </a><br>");
                }
            }
        }
        if (searchType.equals("courseName")) {
            for (Course c : courseList) {
                if (c.getName().toLowerCase().contains(searchQuery.toLowerCase())) {
                    found = true;
                    String crn = c.getCrn();
                    String courseName = c.getName();
                    String courseInstructor = c.getInstructor();
                    String courseDesc = c.getCourseDescription();
                    out.println("<input type='checkbox' name = 'course' value='" + crn + "@" + courseName + "@" + courseDesc + "@" + courseInstructor + "'/>" + crn + courseName
                            + "<a href='addCourse.htm?courseId=" + crn + "&name=" + courseName + "&discription=" + courseDesc + "&instructor=" + courseInstructor
                            + "&action=single'> Add this course </a><br>");
                }
            }
        }
        if (searchType.equals("courseDesc")) {
            for (Course c : courseList) {
                if (c.getCourseDescription().toLowerCase().contains(searchQuery.toLowerCase())) {
                    found = true;
                    String crn = c.getCrn();
                    String courseName = c.getName();
                    String courseInstructor = c.getInstructor();
                    String courseDesc = c.getCourseDescription();
                    out.println("<input type='checkbox' name = 'course' value='" + crn + "@" + courseName + "@" + courseDesc + "@" + courseInstructor + "'/>" + crn + courseName
                            + "<a href='addCourse.htm?courseId=" + crn + "&name=" + courseName + "&discription=" + courseDesc + "&instructor=" + courseInstructor
                            + "&action=single'> Add this course </a><br>");
                }
            }
        }
        if (!found) {
            out.print("<p>Course Not found!!</p>");
            out.println("<button type=\"button\" name=\"back\" onclick=\"history.back()\">Back</button>");
        } else {
            out.println("<input type='hidden' name='action' value='multiple' />");
            out.println("<input type='submit' value='Add selected Course' />");

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
