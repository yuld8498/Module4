<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/sandwich" method="post">
    <div>
        <input type="checkbox" name="sandwich" value="Lettuce">Lettuce
        <input type="checkbox" name="sandwich" value="Tomato">Tomato
        <input type="checkbox" name="sandwich" value="Mustard">Mustard
        <input type="checkbox" name="sandwich" value="Sprouts">Sprouts
    </div>
    <hr>
    <input type="submit" value="Save">
</form>
</body>
</html>