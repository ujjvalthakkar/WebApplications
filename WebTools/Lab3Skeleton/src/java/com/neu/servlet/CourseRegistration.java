package com.neu.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Bean.Course;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dishu
 */
public class CourseRegistration extends HttpServlet {

    private List<Course> courseList;

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
        // response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Set<Course> myCourses;//Show the student what will happen if we add 2 same object to a set
        if (null != session.getAttribute("myCourseSet")) {
            myCourses = (Set<Course>) session.getAttribute("myCourseSet");
        } else {
            myCourses = new HashSet<Course>();
        }
        String actionValue = request.getParameter("action");

        if (actionValue.equalsIgnoreCase("single")) {
            String crn = request.getParameter("courseId");
            if (!checkExist(myCourses, crn)) {
                String courseName = request.getParameter("name");
                String instructor = request.getParameter("instructor");
                String discription = request.getParameter("discription");
                Course newCourse = new Course();
                newCourse.setName(courseName);
                newCourse.setCourseDescription(discription);
                newCourse.setCrn(crn);
                newCourse.setInstructor(instructor);
                myCourses.add(newCourse);
            }

            //create a course and add to the set
        } else if (actionValue.equalsIgnoreCase("multiple")) {
            String[] course = request.getParameterValues("course");
            for (String course1 : course) {
           
                String[] currentCourse = course1.split("@");
                if (!checkExist(myCourses, currentCourse[0])) {
                    Course newCourse = new Course();
                    newCourse.setName(currentCourse[1]);
                    newCourse.setCourseDescription(currentCourse[2]);
                    newCourse.setCrn(currentCourse[0]);
                    newCourse.setInstructor(currentCourse[3]);
                    myCourses.add(newCourse);
                }
                //add courses to the set
            }
        } else if (actionValue.equalsIgnoreCase("remove")) {
            String removeCourseCrn = request.getParameter("crn");
            for (Course c : myCourses) {
                if (c.getCrn().equals(removeCourseCrn)) {
                    //reove from set
                    myCourses.remove(c);
                    break;
                }
            }
        }

        session.setAttribute("myCourseSet", myCourses);
        response.sendRedirect("courseView.jsp");

    }

    public boolean checkExist(Set<Course> set, String crn) {
        for (Course c : set) {
            if (c.getCrn().equals(crn)) {
                return true;
            }
        }
        return false;
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
