<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 02/12/2022
  Time: 11:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trang Tìm Kiếm</title>
</head>
<body>
<pre> Tìm Kiếm </pre>
<form action="/user" method="post">
<table border="1" cellpadding="5">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Country</td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td><c:out value="${user.getId()}"/> </td>
            <td><c:out value="${user.getName()}"/> </td>
            <td><c:out value="${user.getEmail()}"/> </td>
            <td><c:out value="${user.getCountry()}"/> </td>
        </tr>
    </c:forEach>

</table>
</form>
</body>
</html>
