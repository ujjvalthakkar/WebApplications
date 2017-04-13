<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<a href="${contextPath}/search.htm" >Search User</a> <br />

<form:form commandName="user" method="post" enctype="multipart/form-data">
First Name: <form:input path="fname"/><br/>
Last Name: <form:input path="lname"/><br/>
Email: <form:input path="email"/><br/>
Create Album:<input type="text" name="filename" /><br/>
Select photo: <input type="file" name="photo"/><br/>
<input type="submit" value="Upload Button"/>
</form:form>
</body>
</html>