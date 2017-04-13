<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Servlet moviesServlet</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #80CBC4;">
	<div class="container">
		<h1>Welcome to our Movie Store</h1>
		<h2>
			<p style="background-color: #80CBC4;">Please make your selection below</p>
		</h2>
		<form name="moviesForm" action="movie.htm" method="POST">
			<select name="moviesOption">
				<option>Browse Movies</option>
				<option>Add New movie to DB</option>
			</select> <input type="hidden" name="path" value="moviesServlet" /> <input
				type="submit" value="Send" name="movies" />
		</form>
	</div>
</body>
</html>
