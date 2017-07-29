<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>

    <head>
        <title> Reflected XSS </title>
    </head>
    <body style="background-color: powderblue;">
        <h1 align="center"> Put your name in here </h1>

        <form action="hello" method="get" align="center">
            <div class="form-group">
        	    <input type="text" id="name" name="name" placeholder="Your name" maxlength="200" class="form-control"></textarea>
            </div>
            <div class="form-group">
        	    <input align="center" type="submit" value="Submit" class="form-control" />
        	</div>
        </form>
        ${msg}
        <p> This is testing text </p>
    </body>
</html>