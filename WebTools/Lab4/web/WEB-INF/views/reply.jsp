<%-- 
    Document   : reply
    Created on : Feb 6, 2016, 3:08:01 PM
    Author     : Manasi Laddha
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compose Message</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1> Welcome <c:out value="${sessionScope.userName}"/> </h1>

        <form action='sendmessage.htm' method="post">
            <p><b>From:</b><c:out value="${sessionScope.userName}"/></p>
            <p><b>TO:</b><c:out value="${param.to}"/></p>
            <p>Message:</p>
            <textarea name="message" rows="6" cols="4">
            </textarea><br>
            <input type="submit" value="Send" name="Send" />
            <input type="hidden" name="to" value="${param.to}" />
        </form>
    </body>
</html>
