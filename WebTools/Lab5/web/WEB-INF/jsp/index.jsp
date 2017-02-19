<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab5</title>
    </head>

    <body>
        <form action="login.htm" method="post">
            <p>UserName : <input type="text" name='user' /></p>
            <p>Password : <input type="password" name="password" /></p>             
            <input type="submit" value="Submit"/> &nbsp;&nbsp;<a href="login.htm?action=signUp">SignUp</a>
            <c:if test="${!empty requestScope.error}">
                <p style="color:red"> Invalid Credentials</p>
            </c:if>
            <input type="hidden" name="action" value="login">
        </form>  
    </body>
</html>
