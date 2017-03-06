<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Welcome to our Book Store</title>
    </head>

    <body>
        <div class="container">
            <h1 style="color: blue;">Welcome to our Book Store</h1>
            <h3> Please make your selection below</h3>
            <div class="row">
                <form class="well" name="booksForm" action="book.htm" method="POST" style="background-color: #8BC34A;">

                    <select name="booksOption">
                        <option>Browse Books</option>
                        <option>Add New Books to DB</option>
                    </select>
                    <input type="hidden" name="path" value="booksServlet"/>
                    <input class="btn btn-primary" type="submit" value="Send" name="books" />
                </form>
            </div>
        </div>
    </body>
</html>
