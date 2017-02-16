<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="Bean.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        <h3> Courses Added:</h3>
        <a href="logoutServlet">Logout</a>&nbsp;&nbsp;
        <a href="courseView.jsp">My Courses</a>
        <br/><br/>
        <!--if there are no course in the set-->
        <%
            if (session.getAttribute("myCourseSet") == null) {
        %>
        <div id='div'>
            <p> No Course Added for you.</p>
            <a href='searchCourse.jsp'> Go to Search page </a>
        </div>
        <%
        } else {
            HashSet<Course> courseSet = (HashSet<Course>) session.getAttribute("myCourseSet");
            for (Course c : courseSet) {
        %>
        <p>Course Name:<%=c.getName()%></p>
        <p>Course Crn:<%=c.getCrn()%></p>
        <p>Course Instructor:<%=c.getInstructor()%></p>
        <p>Course Description:<%=c.getCourseDescription()%></p>
        <a href="addCourse.htm?action=remove&crn=<%=c.getCrn()%>">Remove Course</a>
        <br>
        <%            }
        %><a href='searchCourse.jsp'> Go to Search page </a>
        <%
            }
        %>
    </body>
</html>
