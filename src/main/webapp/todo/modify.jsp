<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2024-09-04
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify/Remove</title>
</head>
<body>
<form action="/todo/modify" method="post">
<div><input type="text" name="tno" placeholder="${dto.tno}"></div>
<div><input type="text" name="title" placeholder="${dto.title}"></div>
<div><input type="date" name="date" placeholder="${dto.dueDate}"></div>
<div><input type="text" name="finished" placeholder="${dto.finished}"></div>
    <button type="submit" name="modify">Modify</button>
</form>
<form action="/todo/remove" method="post">
    <input type="hidden" name="tno" value=${dto.tno}>
    <button type="submit" name="remove">Remove</button>
</form>
</body>
</html>
