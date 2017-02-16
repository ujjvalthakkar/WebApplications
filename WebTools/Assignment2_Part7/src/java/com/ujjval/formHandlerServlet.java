/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ujjval;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
                    + "        <th>Field Name</th>\n"
                    + "        <th>Value</th>\n"
                    + "      </tr>\n"
                    + "    </thead>\n"
                    + "    <tbody>");
            Map<String, String[]> paramMap = request.getParameterMap();
            Set paramSet = paramMap.entrySet();
            Iterator paramIterator = paramSet.iterator();
            
            while (paramIterator.hasNext()) {
                Map.Entry<String, String[]> parameter
                        = (Entry<String, String[]>) paramIterator.next();
                String paramName = parameter.getKey();
                out.print("<tr><td>" + paramName + "</td><td>");
                String[] paramValues = parameter.getValue();
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() == 0) {
                        out.println("<b>Empty Parameter</b>");
                    } else {
                        out.println(sanitize(paramValue));
                    }
                } else {
                    out.println("<ul>");
                    for (int i = 0; i < paramValues.length; i++) {
                        out.println("<li>" + sanitize(paramValues[i]) + "</li>");
                    }
                    out.println("</ul>");
                }
                out.println("</td></tr>");
            }
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
