<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Delete Confirmation - repTracker</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <h2>Confirmation</h2>
    <p>Are you sure you want to delete the user ${user.name} ?</p>
    <form action="Controller?command=delete&naam=${user.name}" method="POST">
        <input type="submit" value="Yes"/>
    </form>
    <p><a href="Controller?command=overview">Cancel</a> if you don't want to delete
        ${user.name}
    </p>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>