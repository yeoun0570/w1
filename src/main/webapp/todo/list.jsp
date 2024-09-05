<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2024-09-04
  Time: 오후 5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%--JSTL--%>
<html>
<head>
    <title>List</title>
</head>
<body>
    <h1>Todo List</h1>
    <ul>
        <c:forEach var="dto" items="${dtoList}"> <%--var : EL에서 사용되는 변수--%>
            <li><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a> ${dto.title} ${dto.dueDate} ${dto.finished}</li>
        </c:forEach>
    </ul>
</body>
</html>
