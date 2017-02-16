<%-- 
    Document   : movies
    Created on : Feb 10, 2017, 2:35:09 AM
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
        <title>JSP Page</title>
        <script type="text/javascript">
            function validateForm()
            {
                if (validateRadio(document.forms["searchMovieForm"]["searchBy"]))
                {
                    return true;
                } else
                {
                    alert('Please Select your criteria');
                    return false;
                }
            }
            function validateRadio(searchBy)
            {
                for (i = 0; i < searchBy.length; ++i)
                {
                    if (searchBy [i].checked)
                        return true;
                }
                return false;
            }
            function isNumber(evt) {
                evt = (evt) ? evt : window.event;
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body style="background-color: #80CBC4;">

        <div class="container">
            <c:if test="${path =='1'}">
                <h1>Search Movie</h1>
                <form class="well form-horizontal" name="searchMovieForm" method="POST" action="moviesServlet" onsubmit="return validateForm()" style="background-color: #E1F5FE;">
                    <div class="form-group">
                        <input type="hidden" name="path" value="movies.jsp"/>
                        <input type="hidden" name="formName" value="searchMovieForm"/>
                        <label class="col-md-4 control-label" for="nuid">Keyword:</label>
                        <div class="col-md-8">
                            <input type="text" name="keyword" value="" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Select Search Criteria:</label>
                        <div class="col-md-8">
                            <label class="radio"><input type="radio" name="searchBy" value="Search by Title" />Search by Title</label>
                            <label class="radio"><input type="radio" name="searchBy" value="Search by Actor" />Search by Actor</label>
                            <label class="radio"><input type="radio" name="searchBy" value="Search by Actress" />Search by Actress</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-10 text-center"> 
                            <input type="submit" value="Search Movie" name="submit"/>
                        </div>
                    </div>
                </form>
            </c:if>
            <c:if test="${path =='2'}">
                <h1>Add Movie</h1>
                <h2>Please enter the details below:</h2>    
                <form class="well form-horizontal" name="addMovieForm" method="POST" action="moviesServlet" style="background-color: #E1F5FE;">

                    <input type="hidden" name="formName" value="addMovieForm"/>
                    <input type="hidden" name="path" value="movies.jsp"/>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Movie Title:</label>
                        <div class="col-md-4 ">
                            <input type="text" name="movieTitle" value="" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Lead Actor:</label>
                        <div class="col-md-4 "><input type="text" name="leadActor" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Lead Actress:</label>
                        <div class="col-md-4 ">
                            <input type="text" name="leadActress" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Genre:</label>
                        <div class="col-md-4 ">
                            <input type="text" name="movieGenre" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Year:</label>
                        <div class="col-md-4 ">
                            <input type="text" name="movieYear" value="" onkeypress="return isNumber(event)" maxlength="4"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-10 text-center">
                            <input type="submit" value="Add Movie" name="submit" />
                        </div>
                    </div> 
                </form> 
            </c:if>
        </div>
    </body>
</html>
