<%--
  Created by IntelliJ IDEA.
  User: RoyAlex
  Date: 30.07.2020
  Time: 05.25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student confirmation</title>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName}
<br><br>
country: ${student.country}
<br><br>
favorite language: ${student.favoriteLanguage}
<br><br>
operating system:
<ul>
    <c:forEach var="item" items="${student.operatingSystems}">
    <li> ${item} </li>
    </c:forEach>
</ul>

</body>
</html>
