<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2024-09-04
  Time: 오후 5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="/todo/register" method="post">
    <input type="text" name="title" placeholder="INSERT TITLE"><br>
    <input type="date" name="date"><br>
    <button type="reset" name="reset">RESET</button>
    <button type="submit" name="register">REGISTER</button>
</form>
</body>
</html>
