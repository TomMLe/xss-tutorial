<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>

    <head>
        <title> Stored XSS </title>
    </head>
    <body style="background-color: powderblue;">
        <h1 align="center"> Try storing your scripts </h1>

        <form action="" method="post" align="center">
            <div class="form-group">
        	    <textarea type="text" id="comment" rows="10" cols="50" name="comment" placeholder="Comment" maxlength="200" class="form-control"></textarea>
            </div>
            <div class="form-group">
        	    <input align="center" type="submit" value="Comment" class="form-control" />
        	</div>
        </form>
        <tbody>
            <c:forEach var="cmt" items="${commentList}" >
                <tr>
                    <td> Comment: ${cmt}</td>
                </tr>
                <br>
            </c:forEach>
        </tbody>
    </body>
</html>