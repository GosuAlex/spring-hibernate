<%--
  Created by IntelliJ IDEA.
  User: RoyAlex
  Date: 30.07.2020
  Time: 06.30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer confirmation</title>
</head>
<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName}
<br>
freePasses: ${customer.freePasses}
<br>
Postal Code: ${customer.postalCode}
<br>
Postal Code: ${customer.courseCode}


</body>
</html>
