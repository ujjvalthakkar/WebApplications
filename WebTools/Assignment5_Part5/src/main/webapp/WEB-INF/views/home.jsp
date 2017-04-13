<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Store</title>
</head>
<body>
	<h1>Welcomme to our Book Store</h1>
	<p>Please make your selection below</p>
	<form name="booksForm" action="book.htm" method="POST">
		<select name="booksOption">
			<option>Browse Books</option>
			<option>Add New Books to DB</option>
		</select> <input type="hidden" name="path" value="booksServlet" /> <input
			type="submit" value="Send" name="books" />
	</form>
</body>
</html>
