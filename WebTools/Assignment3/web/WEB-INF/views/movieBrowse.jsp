<%-- 
    Document   : movieBrowse
    Created on : Feb 11, 2017, 9:14:17 PM
    Author     : ujjva
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: #80CBC4">
        <p>You Searched for: <b>${sessionScope.keyword}</b></p>
        <p>Criteria:<b>${sessionScope.criteria}</b></p>
        <c:if test="${not empty sessionScope.movieList}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Lead Actor</th>
                        <th>Lead Actress</th>
                        <th>Genre</th>
                        <th>Year</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sessionScope.movieList}" var="movie">
                        <tr>
                            <td>${movie.title}</td>
                            <td>${movie.actor}</td>
                            <td>${movie.actress}</td>
                            <td>${movie.genre}</td>
                            <td>${movie.year}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty sessionScope.movieList}">
            <p>No results returned</p>
        </c:if>
            <br>
        <a href="moviesServlet">Click here to go back to the main page</a>
    </body>
</html>