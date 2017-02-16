<%-- 
    Document   : books
    Created on : Feb 12, 2017, 2:56:07 PM
    Author     : ujjva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            function isNumberKey(evt)
            {
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode != 46 && charCode > 31
                        && (charCode < 48 || charCode > 57))
                    return false;

                return true;
            }
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <c:if test="${path =='1'}">
                <h2>Below are the available books</h2>
                <c:if test="${not empty requestScope.bookList}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>ISBN</th>
                                <th>Title</th>
                                <th>Author</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.bookList}" var="book">
                                <tr>
                                    <td>${book.isbn}</td>
                                    <td>${book.title}</td>
                                    <td>${book.authors}</td>
                                    <td>${book.price}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty requestScope.bookList}">
                    <p>No results returned</p>
                </c:if>
                <br>
                <a href="booksServlet">Click here to go back to the main page</a>
            </c:if>
            <c:if test="${path =='2'}">
                <h1>How many books to be added?</h1>
                <form class="well form-horizontal" name="addBookForm" method="POST" action="booksServlet">
                    <div class="form-group">
                        <div class="col-md-8">
                            <input type="hidden" name="formName" value="addBookForm"/>
                            <input type="hidden" name="path" value="books.jsp"/>
                            <input type="text" name="number" value="" />
                            <br><br>
                            <input type="submit" value="Add Books" name="submit" required/>
                        </div>
                    </div>
                </form>
            </c:if>
            <c:if test="${path =='3'}">
                <h2>Please enter the Book Details</h2>
                <form class="well form-horizontal" name="addBookForm" method="POST" action="booksServlet">
                    <div class="form-group">
                        <div class="col-md-8">
                            <input type="hidden" name="formName" value="addBooksForm"/>
                            <input type="hidden" name="path" value="books.jsp"/>
                            <input type="hidden" name="numberOfBooks" value="${requestScope.numberOfBooks}"/>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>ISBN</th>
                                        <th>Title</th>
                                        <th>Author</th>
                                        <th>Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach begin="1" end="${requestScope.numberOfBooks}" step="1" varStatus="status">
                                        <tr>
                                            <td><input type="text" name="isbn${status.count}" value="" required/></td>
                                            <td><input type="text" name="title${status.count}" value="" required/></td>
                                            <td><input type="text" name="author${status.count}" value="" required/></td>
                                            <td><input type="text" name="price${status.count}" value="" onkeypress="return isNumberKey(event)" required/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <input type="submit" value="Add Books" name="submit" required/>
                        </div>
                    </div>
                </form>

            </c:if>
        </div>
    </body>
</html>
