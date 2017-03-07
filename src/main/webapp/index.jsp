<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Daily Statistics</title>
</head>
<body>
    <h3>Press F5 to update</h3>

    <c:if test="${not empty dailyVisits}">
        <table>
            <tr>
                <td><c:out value="Hours ago" /></td>
                <c:forEach var="i" begin="0" end="23">
                    <td><c:out value="${i}" /></td>
                </c:forEach>
            </tr>
            <tr>
                <td><c:out value="Visits" /></td>
                <c:forEach items="${dailyVisits}" var="item">
                    <td>${item}</td>
                </c:forEach>
            </tr>
        </table>
    </c:if>
</body>
</html>