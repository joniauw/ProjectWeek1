<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Formulier - HangingOut</title>
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
    <h2>Start hanging out right now!</h2>
    <form title="Woord Toevoegen" method="POST" action="Controller?command=add" novalidate>

        <p class="form-group ${woordClass}">
            <label class="control-label" for="woord">Nieuw woord*: </label>
            <input type="text" id="woord" name="woord" value="${woordPreviousValue}" required>
        </p>

        <p class="form-group ${niveauClass}">
            <label class="control-label" for="niveau">Niveau:</label>
            <input type="radio" id="expert" name="niveau" value="${niveauPreviousValue}">
            <input type="radio" id="beginner" name="gender" value="male">
        </p>

        <input type="submit" value="Add">
    </form>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
