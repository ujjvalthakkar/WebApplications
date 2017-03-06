<%-- 
    Document   : books
    Created on : Feb 21, 2017, 2:54:30 PM
    Author     : ujjva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
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
    <body style="background-color:#DCE775 ">
        <div class="container">
            <c:if test="${path =='1'}">
                <h2>Below are the available books</h2>
                <c:if test="${not empty requestScope.bookList}">
                    <div class="col-md-12">
                        <table class="table table-hover table-condensed" border="1">
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
                        <a class="btn btn-primary" href="index.htm">Click here to go back to the main page</a>
                    </div>
                </c:if>
                <c:if test="${empty requestScope.bookList}">
                    <p>No results returned</p>
                </c:if>
                <br>
                <!-- <a href="booksServlet">Click here to go back to the main page</a> -->
            </c:if>
            <c:if test="${path =='2'}">
                <h1>How many books to be added?</h1>
                <form class="well form-horizontal" name="addBookForm" method="POST" action="book.htm" style="background-color: #EFEBE9;">
                    <div class="form-group">
                        <div class="col-md-8">
                            <input type="hidden" name="formName" value="addBookForm"/>
                            <input type="hidden" name="path" value="books.jsp"/>
                            <input type="text" name="number" value="" />
                            <br><br>
                            <input class="btn btn-primary" type="submit" value="Add Books" name="submit" required/>
                        </div>
                    </div>
                </form>
            </c:if>
            <c:if test="${path =='3'}">
                <h2>Please enter the Book Details</h2>
                <form class="well form-horizontal" name="addBookForm" method="POST" action="book.htm" style="background-color: #EFEBE9;">
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
                            <br>
                            <input class="btn btn-primary"type="submit" value="Add Books" name="submit" required/>
                        </div>
                    </div>
                </form>
            </c:if>
            <c:if test="${path =='4'}">
                <h1>${requestScope.number} Books Added Successfully</h1>
                <a class="btn btn-primary" href="index.htm">Click here to go back to the main page</a>
            </c:if>
        </div>
    </body>
</html>
