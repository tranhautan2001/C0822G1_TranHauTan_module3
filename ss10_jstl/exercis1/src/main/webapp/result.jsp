<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29/11/2022
  Time: 11:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<h1> List Customer</h1>
<table class="table  table-bordered border-primary" style="background-color: aquamarine">
    <tr>
        <td>Name</td>
        <td>Date Of Birth</td>
        <td> Address</td>
        <td> IMG</td>
    </tr>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getDate_of_birth()}</td>
            <td>${customer.getAddress()}</td>
            <td><img style="height: 50px ; width: 60px" src="${customer.getImg()}"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
