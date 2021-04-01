<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Formulier - </title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="add"/>
</jsp:include>
<main>
    <c:if test="${not empty errors}">
        <div class="alert">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <h2>Start counting right now</h2>
    <form method="POST" action="Controller?command=add" novalidate>

        <p class="form-group ${nameClass}">
            <label class="control-label" for="name">New player: </label>
            <input type="text" id="name" name="name" value="${namePreviousValue}">
        </p>

        <p class="form-group ${challengeClass}">
            <label class="control-label" for="challenge">New challenge:</label>
            <input type="text" id="challenge" name="challenge" value="${challengePreviousValue}">
        </p>

        <p class="form-group ${repClass}">
            <label class="control-label" for="rep">New reps:</label>
            <input type="number" id="rep" name="rep" class="error" value="${repPreviousValue}">
        </p>

        <input type="submit" value="Add">
    </form>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
