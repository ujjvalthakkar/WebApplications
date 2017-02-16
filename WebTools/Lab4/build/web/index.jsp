<%-- 
    Document   : index
    Created on : Feb 6, 2016, 1:40:19 PM
    Author     : Manasi Laddha
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab4</title>
    </head>
    <body bgcolor='pink'>
        <h1>Lab 4</h1>
        <form action="login.htm" method="post">
            <p>UserName : <input type="text" name='user' /></p>
            <p>Password : <input type="password" name="password" /></p>             
            <input type="submit" value="Submit"/>
        </form>       
    </body>
</html>
