<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/08/2022
  Time: 11:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Your Chose: </h2>
<c:forEach items="${sandwich}" var="condiment">
    ${condiment}
</c:forEach>
</body>
</html>
