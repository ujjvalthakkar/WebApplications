<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<html>
    <head>
        <title>Select Courses</title>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <!--This is html4 to disable cache-->
        <!--add those line later-->
    </head>
    <body>
        <!--if the user already login-->
        <%
            String user = (String) session.getAttribute("user");
            if (user == null) {
        %>
        <div id="div">
            <p>You are not logged in!!!</p>
        </div>
        <a href="index.html">Go to Home Page</a>
        <%
        } else {
        %>
        <div>
            <h2> Search Courses</h2>
            <form id='form' action="CourseSearch" method="get" >
                <a href="logoutServlet">Logout</a>&nbsp;&nbsp;
                <a href="courseView.jsp">My Courses</a>
                <br />
                <br />                 
                Search Query <input type="text" name="query"/> <br/><br/>
                <input type="radio" name="searchType" value="crn" checked=""/> Search By CRN
                <input type="radio" name="searchType" value="courseInst"/> Search By Instructor
                <input type="radio" name="searchType" value="courseName"/> Search By Course Name
                <input type="radio" name="searchType" value="courseDesc"/> Search By Course Description
                
                <br/><input type="submit" value="SEARCH"/>
            </form>
        </div>
        <%
            }
        %>
    </body>
</html>
