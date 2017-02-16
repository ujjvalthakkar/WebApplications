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
public class formHanderServlet extends HttpServlet {

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
            String[] options = request.getParameterValues("options");
            if (!(options == null)) {
                String s = "";
                out.println("<tr><td><b>Status</b></td><td>");
                for (String s1 : options) {
                    s = s + s1 + " ,";
                }
                out.println(sanitize(s.substring(0, s.length() - 1)) + "</td></tr>");
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
            out.println("<tr><td>" + sanitize(request.getParameter("CourseName")) + "</td><td>" + sanitize(request.getParameter("Term")) + "</td><td>" + sanitize(request.getParameter("CRN")) + "</td><td>" + sanitize(request.getParameter("CourseNumb")) + "</td><td>" + sanitize(request.getParameter("Credits")) + "</td></tr>");
            out.println("<tr><td>" + sanitize(request.getParameter("CourseName1")) + "</td><td>" + sanitize(request.getParameter("Term1")) + "</td><td>" + sanitize(request.getParameter("CRN1")) + "</td><td>" + sanitize(request.getParameter("CourseNumb1")) + "</td><td>" + sanitize(request.getParameter("Credits1")) + "</td></tr>");
            out.println(" </tbody></table>");
            out.println(" </td></tr>");
            out.println("<tr><td><b>Petiotion Explaination</b></td><td>" + sanitize(request.getParameter("petiotionExplaination")) + "</td></tr>");
            out.println("<tr><td><b>Student Signature</b></td><td>" + sanitize(request.getParameter("StudentSignature")) + "</td></tr>");
            out.println("<tr><td><b>Date</b></td><td>" + sanitize(request.getParameter("date")) + "</td></tr>");
            out.println("<tr><td><b>Recommendation</b></td><td>" + sanitize(request.getParameter("Recommendation")) + "</td></tr>");
            out.println("<tr><td><b>Program Advisor Signature</b></td><td>" + sanitize(request.getParameter("ProgramAdvisorSignature")) + "</td></tr>");
            out.println("<tr><td><b>Program Advisor Print Name</b></td><td>" + sanitize(request.getParameter("ProgramAdvisorPrintName")) + "</td></tr>");
            out.println("<tr><td><b>Program Advisor Comments</b></td><td>" + sanitize(request.getParameter("ProgramAdvisorComments")) + "</td></tr>");
            out.println("<tr><td><b>ECE Graduate Committee Chai</b></td><td>" + sanitize(request.getParameter("ECEStudent")) + "</td></tr>");
            out.println("<tr><td><b>Date</b></td><td>" + sanitize(request.getParameter("adate")) + "</td></tr>");
            out.println("<tr><td><b>Graduate School Approval</b></td><td>" + sanitize(request.getParameter("GraduateSchool")) + "</td></tr>");
            out.println("<tr><td><b>Graduate School Comments to student</b></td><td>" + sanitize(request.getParameter("GraduateSchoolComments")) + "</td></tr>");
            out.println("<tr><td><b>Graduate School Authorization</b></td><td>" + sanitize(request.getParameter("GraduateSchoolAuthorization")) + "</td></tr>");
            out.println("<tr><td><b>Date</b></td><td>" + sanitize(request.getParameter("bdate")) + "</td></tr>");
            out.println("<tr><td><b>Effective Term</b></td><td>" + sanitize(request.getParameter("EffectiveTerm")) + "</td></tr>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>Petition Form</title>\n"
                    + "        <meta charset=\"utf-8\">\n"
                    + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "        <meta name=\"description\" content=\"Demo project\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js\"></script>\n"
                    + "        <script src=\"http://code.jquery.com/ui/1.11.0/jquery-ui.js\"></script>\n"
                    + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n"
                    + "        <link rel=\"stylesheet\"  href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"/>\n"
                    + "        <link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css\">\n"
                    + "        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js\"></script>\n"
                    + "        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css\"/>\n"
                    + "        <script type=\"text/javascript\">\n"
                    + "            $(document).ready(function () {\n"
                    + "                $(\".datepicker\").datepicker({\n"
                    + "                    format: \"mm/dd/yyyy\",\n"
                    + "                    autoclose: true,\n"
                    + "                    todayHighlight: true,\n"
                    + "                    startDate: new Date()\n"
                    + "                });\n"
                    + "            });\n"
                    + "        </script>\n"
                    + "        <style type=\"text/css\">\n"
                    + "\n"
                    + "            .container{\n"
                    + "                background-color: #424242;\n"
                    + "            }\n"
                    + "            .well{\n"
                    + "                background-color: #E0F2F1;\n"
                    + "            }\n"
                    + "            form legend{\n"
                    + "                display: inline-block;\n"
                    + "                text-align: center;\n"
                    + "                box-sizing: border-box;\n"
                    + "                border-bottom: 1px solid;\n"
                    + "                font-size: 30px;\n"
                    + "            }\n"
                    + "            hr{\n"
                    + "                box-sizing: border-box;\n"
                    + "                border-bottom: 1px solid;\n"
                    + "            }\n"
                    + "            img{\n"
                    + "                width: 350px;\n"
                    + "            }\n"
                    + "            .buttondiv{\n"
                    + "                text-align: center;\n"
                    + "            }\n"
                    + "            .button {\n"
                    + "                position: absolute;\n"
                    + "                top: 50%;\n"
                    + "            }\n"
                    + "        </style>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div class=\"container\">\n"
                    + "            <form class=\"well form-horizontal\"  id=\"petitionForm\" action=\"formHanderServlet\" method=\"POST\">\n"
                    + "                <div class=\"row\">\n"
                    + "                    <div class=\"col-md-5\">\n"
                    + "                        <img src=\"images/neulogo.jpg\" alt=\"Northeastern University\" />\n"
                    + "                    </div>\n"
                    + "                    <div class=\"col-md-4\">\n"
                    + "                        <h4>\n"
                    + "                            <b>\n"
                    + "                                Graduate School of Engineering<br>\n"
                    + "                                130 Snell Engineering Center<br></b>\n"
                    + "                            Northeastern University<br>\n"
                    + "                            360 Huntington Avenue<br>\n"
                    + "                            Boston, MA 02115-5000<br>\n"
                    + "                        </h4>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"col-md-3\">\n"
                    + "                        <h4>\n"
                    + "                            Phone: 617.373.2711<br>\n"
                    + "                            Fax: 617.373.2571<br>\n"
                    + "                            Web: www.coe.neu.edu/gse\n"
                    + "                        </h4>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <br>\n"
                    + "                <h3>Petition Form</h3>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\" for=\"nuid\">NUID:*</label>\n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-question-sign\"></i></span>\n"
                    + "                            <input type=\"text\" class=\"form-control inputStyle\" name=\"nuid\" id=\"nuid\" placeholder=\"Enter your NUID\" required=\"required\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\" for=\"CurrentProgramOrConcentration\">Current Program/Concentration:*</label>\n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-question-sign\"></i></span>\n"
                    + "                            <input type=\"text\" class=\"form-control inputStyle\" name=\"Current Program/Concentration\" id=\"CurrentProgramOrConcentration\" placeholder=\"Enter your Current Program/Concentration\" required=\"required\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">First Name</label>  \n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"
                    + "                            <input  name=\"FirstName\" placeholder=\"First or Given Name\" class=\"form-control\"  type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Last Name</label>  \n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"
                    + "                            <input  name=\"LastName\" placeholder=\"Last or Family Name\" class=\"form-control\"  type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Address</label>  \n"
                    + "                    <div class=\"col-md-4 inputGroupContainer\">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-home\"></i></span>\n"
                    + "                            <input name=\"address\" placeholder=\"Address\" class=\"form-control\" type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">City</label>  \n"
                    + "                    <div class=\"col-md-4 inputGroupContainer\">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-home\"></i></span>\n"
                    + "                            <input name=\"city\" placeholder=\"City\" class=\"form-control\"  type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\"> \n"
                    + "                    <label class=\"col-md-4 control-label\">State</label>\n"
                    + "                    <div class=\"col-md-4 selectContainer\">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-list\"></i></span>\n"
                    + "                            <select name=\"state\" class=\"form-control selectpicker\" >\n"
                    + "                                <option value=\" \">Please select your state</option>\n"
                    + "                                <option>Alabama</option>\n"
                    + "                                <option>Alaska</option>\n"
                    + "                                <option>Arizona</option>\n"
                    + "                                <option>Arkansas</option>\n"
                    + "                                <option>California</option>\n"
                    + "                                <option>Colorado</option>\n"
                    + "                                <option>Connecticut</option>\n"
                    + "                                <option>Delaware</option>\n"
                    + "                                <option>District of Columbia</option>\n"
                    + "                                <option>Florida</option>\n"
                    + "                                <option>Georgia</option>\n"
                    + "                                <option>Hawaii</option>\n"
                    + "                                <option>daho</option>\n"
                    + "                                <option>Illinois</option>\n"
                    + "                                <option>Indiana</option>\n"
                    + "                                <option>Iowa</option>\n"
                    + "                                <option>Kansas</option>\n"
                    + "                                <option>Kentucky</option>\n"
                    + "                                <option>Louisiana</option>\n"
                    + "                                <option>Maine</option>\n"
                    + "                                <option>Maryland</option>\n"
                    + "                                <option>Mass</option>\n"
                    + "                                <option>Michigan</option>\n"
                    + "                                <option>Minnesota</option>\n"
                    + "                                <option>Mississippi</option>\n"
                    + "                                <option>Missouri</option>\n"
                    + "                                <option>Montana</option>\n"
                    + "                                <option>Nebraska</option>\n"
                    + "                                <option>Nevada</option>\n"
                    + "                                <option>New Hampshire</option>\n"
                    + "                                <option>New Jersey</option>\n"
                    + "                                <option>New Mexico</option>\n"
                    + "                                <option>New York</option>\n"
                    + "                                <option>North Carolina</option>\n"
                    + "                                <option>North Dakota</option>\n"
                    + "                                <option>Ohio</option>\n"
                    + "                                <option>Oklahoma</option>\n"
                    + "                                <option>Oregon</option>\n"
                    + "                                <option>Pennsylvania</option>\n"
                    + "                                <option>Rhode Island</option>\n"
                    + "                                <option>South Carolina</option>\n"
                    + "                                <option>South Dakota</option>\n"
                    + "                                <option>Tennessee</option>\n"
                    + "                                <option>Texas</option>\n"
                    + "                                <option> Uttah</option>\n"
                    + "                                <option>Vermont</option>\n"
                    + "                                <option>Virginia</option>\n"
                    + "                                <option>Washington</option>\n"
                    + "                                <option>West Virginia</option>\n"
                    + "                                <option>Wisconsin</option>\n"
                    + "                                <option>Wyoming</option>\n"
                    + "                            </select>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Zip Code</label>  \n"
                    + "                    <div class=\"col-md-4 inputGroupContainer\">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-home\"></i></span>\n"
                    + "                            <input name=\"zip\" placeholder=\"Zip Code\" class=\"form-control\"  type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Phone #</label>  \n"
                    + "                    <div class=\"col-md-4 inputGroupContainer\">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-earphone\"></i></span>\n"
                    + "                            <input name=\"phone\" placeholder=\"(123)456-7890\" class=\"form-control\" type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">E-Mail</label>  \n"
                    + "                    <div class=\"col-md-4 inputGroupContainer\">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-envelope\"></i></span>\n"
                    + "                            <input name=\"email\" placeholder=\"E-Mail Address\" class=\"form-control\"  type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Current Degree Level</label>\n"
                    + "                    <div class=\"col-md-8\">\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"degree\" id=\"MS\" value=\"MS\">MS</label>\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"degree\" id=\"PhD\" value=\"PhD\">PhD</label>\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"degree\" id=\"CertificateOnly\" value=\"CertificateOnly\">Certificate Only</label>\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"degree\" id=\"SpecialStudent\" value=\"SpecialStudent\">Special Student</label>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Student type</label>\n"
                    + "                    <div class=\"col-md-8\">\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"studentType\" id=\"International\" value=\"International\">International</label>\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"studentType\" id=\"Domestic\" value=\"Domestic\">Domestic</label>\n"
                    + "\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <hr>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Check all that apply</label>\n"
                    + "                    <div class=\"col-md-4 inputGroupContainer\">\n"
                    + "                        <div class=\"checkbox\">\n"
                    + "                            <label>\n"
                    + "                                <input type=\"checkbox\" name=\"options\" value=\"ElectiveOutsideCoreCurriculum\">\n"
                    + "                                Elective outside core curriculum\n"
                    + "                            </label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"checkbox\">\n"
                    + "                            <label>\n"
                    + "                                <input type=\"checkbox\"  name=\"options\" value=\"CoreCourseWaive\">\n"
                    + "                                Core course waive\n"
                    + "                            </label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"checkbox\">\n"
                    + "                            <label>\n"
                    + "                                <input type=\"checkbox\"  name=\"options\" value=\"ChangeInStatus\">\n"
                    + "                                Change in status\n"
                    + "                            </label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"checkbox\">\n"
                    + "                            <label>\n"
                    + "                                <input type=\"checkbox\"  name=\"options\" value=\"CourseRepeatOfficialSubstitution\">\n"
                    + "                                Course repeat/official substitution\n"
                    + "                            </label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"checkbox\">\n"
                    + "                            <label>\n"
                    + "                                <input type=\"checkbox\"  name=\"options\" value=\"TimeExtensionProgramCompletion\">\n"
                    + "                                Extension of time limit to program completion\n"
                    + "                            </label>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <!-- -->\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">1. For each course concerned, please provide the information</label><br>\n"
                    + "                    <div class=\"col-md-8 inputGroupContainer table-responsive\">\n"
                    + "                        <table class=\"table table-bordered table-striped table-highlight\">\n"
                    + "                            <thead>\n"
                    + "                                <tr>\n"
                    + "                                    <th>Course Name</th>\n"
                    + "                                    <th>Term</th>\n"
                    + "                                    <th>CRN #</th>\n"
                    + "                                    <th>Course # </th>\n"
                    + "                                    <th># Credits</th>\n"
                    + "                                </tr>\n"
                    + "                            </thead>\n"
                    + "                            <tbody>\n"
                    + "                                <tr>\n"
                    + "                                    <td><input type=\"text\" name=\"CourseName\" class=\"form-control\"/></td>\n"
                    + "                                    <td><input type=\"text\" name=\"Term\" class=\"form-control\"/></td>\n"
                    + "                                    <td><input type=\"text\" name=\"CRN\" class=\"form-control\"/></td>\n"
                    + "                                    <td><input type=\"text\" name=\"CourseNumb\" class=\"form-control\"/></td>\n"
                    + "                                    <td><input type=\"text\" name=\"Credits\" class=\"form-control\"/></td>\n"
                    + "                                </tr>\n"
                    + "                                <tr>\n"
                    + "                                    <td><input type=\"text\" name=\"CourseName1\" class=\"form-control\"/></td>\n"
                    + "                                    <td><input type=\"text\" name=\"Term1\" class=\"form-control\"/></td>\n"
                    + "                                    <td><input type=\"text\" name=\"CRN1\" class=\"form-control\"/></td>\n"
                    + "                                    <td><input type=\"text\" name=\"CourseNumb1\" class=\"form-control\"/></td>\n"
                    + "                                    <td><input type=\"text\" name=\"Credits1\" class=\"form-control\"/></td>\n"
                    + "                                </tr>\n"
                    + "                            </tbody>\n"
                    + "                        </table>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">2. What are you petitioning? Please explain</label>\n"
                    + "                    <div class=\"col-md-4 inputGroupContainer\">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-pencil\"></i></span>\n"
                    + "                            <textarea class=\"form-control\" name=\"petiotionExplaination\" placeholder=\"2. What are you petitioning? Please explain\"></textarea>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\" for=\"StudentSignature\">3. Student signature</label>\n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-pencil\"></i></span>\n"
                    + "                            <input type=\"text\" class=\"form-control inputStyle\" name=\"StudentSignature\" id=\"StudentSignature\" placeholder=\"Enter your Signature\" required=\"required\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\" for=\"date\">Date</label>\n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-th\"></i></span>\n"
                    + "                            <input type=\"text\" name=\"date\" class=\"form-control datepicker\"  id=\"date\" placeholder=\"MM/DD/YYY\" required=\"required\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-7 control-label\">SUBMIT PETITION AND ANY SUPPORTING DOCUMENTS TO YOUR PROGRAM ADVISOR</label><br>\n"
                    + "                </div>\n"
                    + "                <hr>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-2 control-label\" >Program Advisor</label>\n"
                    + "                    <label class=\"col-md-2 control-label\" >Recommendation</label>\n"
                    + "                    <div class=\"col-md-8\">   \n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"Recommendation\" id=\"Approved\" value=\"Approved\">Approved</label>\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"Recommendation\" id=\"Denied\" value=\"Denied\">Denied</label>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\" for=\"ProgramAdvisorSignature\">Signature</label>\n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-pencil\"></i></span>\n"
                    + "                            <input type=\"text\" class=\"form-control inputStyle\" name=\"ProgramAdvisorSignature\" id=\"ProgramAdvisorSignature\" placeholder=\"Enter your Signature\" required=\"required\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Print Name</label>  \n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"
                    + "                            <input  name=\"ProgramAdvisorPrintName\" placeholder=\"Print Name\" class=\"form-control\"  type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Advisor’s comments and/or instructions</label>\n"
                    + "                    <div class=\"col-md-4 inputGroupContainer\">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-pencil\"></i></span>\n"
                    + "                            <textarea class=\"form-control\" name=\"ProgramAdvisorComments\" placeholder=\"Advisor’s comments and/or instructions\"></textarea>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">ECE Graduate Committee Chair (ECE students only)</label>  \n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"
                    + "                            <input  name=\"ECEStudent\" placeholder=\"ECE Graduate Committee Chair (ECE students only)\" class=\"form-control\"  type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\" for=\"date\">Date</label>\n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-th\"></i></span>\n"
                    + "                            <input type=\"text\" name=\"adate\" class=\"form-control datepicker\"  id=\"adate\" placeholder=\"MM/DD/YYY\" required=\"required\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <hr>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-2 control-label\">Graduate School</label>\n"
                    + "                    <div class=\"col-md-10\">   \n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"GraduateSchool\" id=\"gApproved\" value=\"Approved\">Approved</label>\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"GraduateSchool\" id=\"gDenied\" value=\"Denied\">Denied</label>\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"GraduateSchool\" id=\"NoAction\" value=\"NoAction\">No Action</label>\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"GraduateSchool\" id=\"AdditionalInfo\" value=\"AdditionalInfo\">Returned for additional information</label>\n"
                    + "                        <label class=\"radio-inline\"> <input type=\"radio\" name=\"GraduateSchool\" id=\"ASCReportFiled\" value=\"ASCReportFiled\">ASC Report filed</label>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Comments to student</label>\n"
                    + "                    <div class=\"col-md-4 inputGroupContainer\">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-pencil\"></i></span>\n"
                    + "                            <textarea class=\"form-control\" name=\"GraduateSchoolComments\" placeholder=\"Comments to student\"></textarea>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Graduate school authorization</label>  \n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"
                    + "                            <input  name=\"GraduateSchoolAuthorization\" placeholder=\"Graduate school authorization\" class=\"form-control\"  type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\" for=\"date\">Date</label>\n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-th\"></i></span>\n"
                    + "                            <input type=\"text\" name=\"bdate\" class=\"form-control datepicker\"  id=\"bdate\" placeholder=\"MM/DD/YYY\" required=\"required\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <label class=\"col-md-4 control-label\">Effective Term</label>  \n"
                    + "                    <div class=\"col-md-4 \">\n"
                    + "                        <div class=\"input-group\">\n"
                    + "                            <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"
                    + "                            <input  name=\"EffectiveTerm\" placeholder=\"Effective Term\" class=\"form-control\"  type=\"text\">\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group\">\n"
                    + "                    <div class=\"col-md-12 text-center\"> \n"
                    + "                        <button type=\"submit\" class=\"btn btn-primary\" id=\"submitBtn\">\n"
                    + "                            Submit</button>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </form>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");
        }
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
