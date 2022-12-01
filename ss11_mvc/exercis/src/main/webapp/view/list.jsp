<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 01/12/2022
  Time: 10:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List </title>
</head>
<body>
<h1> Product List</h1>
<form action="/product" method="get" class="text-center">
    <input type="text" name="nameSearch" placeholder="Nhập tên sản phẩm">
    <button type="submit" name="action" value="search" class="btn btn-secondary btn-sm">Tìm kiếm</button>
</form>
<p>
    <a href="/product?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Describe</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>
        <td>View</td>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.getName()}</td>
            <td>${product.getPoint()}</td>
            <td>${product.getDescribe()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/product?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.getId()}">delete</a></td>
            <td><a href="/product?action=view&id=${product.getId()}">View</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
