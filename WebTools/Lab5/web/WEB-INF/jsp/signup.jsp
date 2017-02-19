<%-- 
    Document   : signup
    Created on : Feb 18, 2017, 8:37:09 PM
    Author     : ujjva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="signup.htm" method="post">
            <p>UserName:<input type="text" name="name" required/></p>
            <p>Password:<input type="password" name="pwd" required/></p>
            <p>Email:<input type="text" name="email" required/></p>
            <input type="submit" value="Submit"/>
            <input type="hidden" name="action" value="signin">
        </form>
    </body>
</html>
