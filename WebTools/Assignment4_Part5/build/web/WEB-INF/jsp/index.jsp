<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tlds/newTLD.tld" prefix="csv" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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

        <title>Sales</title>
    </head>

    <body style="background-color:#DCE775 ">

        <c:if test="${requestScope.path=='2'}">
            <div class="container">
                <csv:tagHandler csvName="${requestScope.csvName}"></csv:tagHandler>
                </div>
        </c:if>
        <c:if test="${requestScope.path!='4'}">
            <c:if test="${requestScope.path!='2'}">
                <div class="container">
                    <h1>Welcome, Please fill the following</h1>
                    <form class="well form-horizontal" method="POST" action="csv.htm" style="background-color: #EFEBE9;">
                        <div class="form-group">
                            <div class="col-md-8">
                                <label class="col-md-4 control-label">Enter the name of the CSV file:</label>
                                <div class="col-md-4 ">
                                    <input type="text" name="csvName" value="" required/>
                                    <input type="hidden" name="path" value="1" /><br>
                                </div>
                                <input class="btn btn-primary" type="submit" value="Submit" />
                            </div>
                        </div>
                    </form>  
                </div>
            </c:if>
        </c:if>
        <c:if test="${requestScope.path=='3'}">
            <div class="container">
                <h3>Update successfull!</h3>
            </div>
        </c:if>

    </body>
</html>
