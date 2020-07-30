<%--
  Created by IntelliJ IDEA.
  User: RoyAlex
  Date: 30.07.2020
  Time: 05.18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName" />
    <br><br>
    Last name: <form:input path="lastName" />
    <br><br>
    Country: <form:select path="country">
<%--        <form:option value="Brazil" label="Brazil"/>--%>
<%--        <form:option value="Norge" label="Norge"/>--%>
<%--        <form:option value="Sverige" label="Sverige"/>--%>
        <form:options items="${student.countryOptions}"/>
    </form:select>
    <br><br>
    Favorite Language:
    Java <form:radiobutton path="favoriteLanguage" value="Java"/>
    C# <form:radiobutton path="favoriteLanguage" value="C#"/>
    <br><br>
    Operating systems:
    Linux <form:checkbox path="operatingSystems" value="Linux" />
    Microsoft <form:checkbox path="operatingSystems" value="Microsoft" />
    IOS <form:checkbox path="operatingSystems" value="IOS" />
    <input type="submit" />

</form:form>

</body>
</html>
