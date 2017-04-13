<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search User</title>
    </head>
    <body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<a href="${contextPath}/upload.htm" >Add User</a> <br />
    
        <form action="search.htm" method="post">
            
            Search User <input type="text" name="inputtext" required /> <br><br>
            
            <label>Search By:</label>
            <input type="radio" name="searchkey" value="first" checked="checked"> First Name
            <input type="radio" name="searchkey" value="last"> Last Name
            <input type="radio" name="searchkey" value="email"> Email <br><br>
            
            <input type="hidden" name="action" value="searchuser"/>
            <input type="submit" name="search"/>
        </form>
    </body>
</html>