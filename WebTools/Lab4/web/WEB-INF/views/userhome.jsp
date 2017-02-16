<%-- 
    Document   : userhome
    Created on : Feb 8, 2017, 6:30:21 PM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Welcome User:  <c:out value="${sessionScope.userName}"></c:out> </h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>From</th>
                        <th>Message</th>
                        <th>Date</th>
                        <th>Reply</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.messageList}" var="message">
                    <tr>
                        <td>${message.fromUser}</td>
                        <td>${message.message}</td>
                        <td>${message.messageDate}</td>
                        <td><a href="reply.htm?action=reply&to=${message.fromUser}">Reply</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body> 
</html>
