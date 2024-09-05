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
    <title>Read</title>
</head>
<body>
<div><input type="text" name="tno" placeholder="${dto.tno}"></div>
<div><input type="text" name="title" placeholder="${dto.title}"></div>
<div><input type="date" name="date" placeholder="${dto.dueDate}"></div>
<div><input type="text" name="finished" placeholder="${dto.finished}"></div>
<a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
<a href="/todo/list">List</a>

</body>
</html>
