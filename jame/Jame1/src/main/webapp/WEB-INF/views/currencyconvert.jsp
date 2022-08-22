<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/08/2022
  Time: 11:23 SA
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/currency">
    <input type="number" value="" placeholder="input USD your want convert to VND" name="USD">
    <input type="submit" value="submid">
</form>
<h1>${USD*23000} VND</h1>
<%--<h1>${parseFloat(USD*23000*1.0).toFixed(2)}</h1>--%>
</body>
</html>
