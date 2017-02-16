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

/**
 *
 * @author ujjva
 */
public class formHandlerServlet extends HttpServlet {

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
            out.println("<title>Servlet formHandlerServlet</title>");
            out.println("<meta charset=\"utf-8\">\n"
                    + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                    + "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n"
                    + "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");

            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h2>Following are the Form inputs:</h2>");
            out.println("  <table class=\"table table-striped\">\n"
                    + "    <thead>\n"
                    + "      <tr>\n"
                    + "        <th>HeaderName</th>\n"
                    + "        <th>Value</th>\n"
                    + "      </tr>\n"
                    + "    </thead>\n"
                    + "    <tbody>");
            out.println("<tr><td><b>NUID</b></td><td>" + sanitize(request.getParameter("nuid")) + "</td></tr>");
            out.println("<tr><td><b>Current Program/Concentration</b></td><td>" + sanitize(request.getParameter("Current Program/Concentration")) + "</td></tr>");
            out.println("<tr><td><b>First Name</b></td><td>" + sanitize(request.getParameter("FirstName")) + "</td></tr>");
            out.println("<tr><td><b>Last Name</b></td><td>" + sanitize(request.getParameter("LastName")) + "</td></tr>");
            out.println("<tr><td><b>Address</b></td><td>" + sanitize(request.getParameter("address")) + "</td></tr>");
            out.println("<tr><td><b>City</b></td><td>" + sanitize(request.getParameter("city")) + "</td></tr>");
            out.println("<tr><td><b>State</b></td><td>" + sanitize(request.getParameter("state")) + "</td></tr>");
            out.println("<tr><td><b>Zip</b></td><td>" + sanitize(request.getParameter("zip")) + "</td></tr>");
            out.println("<tr><td><b>Phone</b></td><td>" + sanitize(request.getParameter("phone")) + "</td></tr>");
            out.println("<tr><td><b>Email</b></td><td>" + sanitize(request.getParameter("email")) + "</td></tr>");
            out.println("<tr><td><b>Degree</b></td><td>" + sanitize(request.getParameter("degree")) + "</td></tr>");
            out.println("<tr><td><b>Student Type</b></td><td>" + sanitize(request.getParameter("studentType")) + "</td></tr>");
            String[] options =  request.getParameterValues("options");
            if (!(options == null)) {
                String s = "";
                out.println("<tr><td><b>Status</b></td><td>");
                for (String s1 : options) {
                    s = s + s1 + " ,";
                }
                out.println( sanitize(s.substring(0, s.length() - 1)) + "</td></tr>");
            }
            out.println("<tr><td><b>Course Details</b></td><td>");
            out.println("  <table class=\"table\">\n"
                    + "    <thead>\n"
                    + "      <tr>\n"
                    + "        <th>Course Name</th>\n"
                    + "        <th>Term</th>\n"
                    + "        <th>CRN #</th>\n"
                    + "        <th>Course #</th>\n"
                    + "        <th># Credits</th>\n"
                    + "      </tr>\n"
                    + "    </thead>\n"
                    + "    <tbody>");
            out.println("<tr><td>" +  sanitize(request.getParameter("CourseName")) + "</td><td>" +  sanitize(request.getParameter("Term")) + "</td><td>" +  sanitize(request.getParameter("CRN")) + "</td><td>" +  sanitize(request.getParameter("CourseNumb")) + "</td><td>" +  sanitize(request.getParameter("Credits")) + "</td></tr>");
            out.println("<tr><td>" +  sanitize(request.getParameter("CourseName1")) + "</td><td>" +  sanitize(request.getParameter("Term1")) + "</td><td>" +  sanitize(request.getParameter("CRN1")) + "</td><td>" +  sanitize(request.getParameter("CourseNumb1")) + "</td><td>" +  sanitize(request.getParameter("Credits1")) + "</td></tr>");
            out.println(" </tbody></table>");
            out.println(" </td></tr>");
            out.println("<tr><td><b>Petiotion Explaination</b></td><td>" +  sanitize(request.getParameter("petiotionExplaination")) + "</td></tr>");
            out.println("<tr><td><b>Student Signature</b></td><td>" +  sanitize(request.getParameter("StudentSignature")) + "</td></tr>");
            out.println("<tr><td><b>Date</b></td><td>" +  sanitize(request.getParameter("date")) + "</td></tr>");
            out.println("<tr><td><b>Recommendation</b></td><td>" +  sanitize(request.getParameter("Recommendation")) + "</td></tr>");
            out.println("<tr><td><b>Program Advisor Signature</b></td><td>" +  sanitize(request.getParameter("ProgramAdvisorSignature")) + "</td></tr>");
            out.println("<tr><td><b>Program Advisor Print Name</b></td><td>" + sanitize(request.getParameter("ProgramAdvisorPrintName")) + "</td></tr>");
            out.println("<tr><td><b>Program Advisor Comments</b></td><td>" +  sanitize(request.getParameter("ProgramAdvisorComments")) + "</td></tr>");
            out.println("<tr><td><b>ECE Graduate Committee Chai</b></td><td>" +  sanitize(request.getParameter("ECEStudent")) + "</td></tr>");
            out.println("<tr><td><b>Date</b></td><td>" +  sanitize(request.getParameter("adate")) + "</td></tr>");
            out.println("<tr><td><b>Graduate School Approval</b></td><td>" +  sanitize(request.getParameter("GraduateSchool")) + "</td></tr>");
            out.println("<tr><td><b>Graduate School Comments to student</b></td><td>" +  sanitize(request.getParameter("GraduateSchoolComments")) + "</td></tr>");
            out.println("<tr><td><b>Graduate School Authorization</b></td><td>" +  sanitize(request.getParameter("GraduateSchoolAuthorization")) + "</td></tr>");
            out.println("<tr><td><b>Date</b></td><td>" +  sanitize(request.getParameter("bdate")) + "</td></tr>");
            out.println("<tr><td><b>Effective Term</b></td><td>" +  sanitize(request.getParameter("EffectiveTerm")) + "</td></tr>");
            out.println(" </tbody></table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public static String sanitize(String s) {
        if (s == null) {
            return null;
        }
        String temp = s;
        temp = temp.replaceAll("<[^>]*>", " ");
        temp = temp.replaceAll("[\\&;`'\\\\\\|\"*?~<>^\\(\\)\\[\\]\\{\\}\\$\\x00]", "");
        
        temp = temp.replaceAll("\n", " ").replace("\r", " ").replace("\t", " ");
        temp = temp.replaceAll("\\s+", " ").trim();
        return temp;
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
