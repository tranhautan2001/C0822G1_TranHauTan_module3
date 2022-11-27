<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 25/11/2022
  Time: 3:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row" style="height: 100px">
        <div class="col-2" style="background-color: white;display: flex;justify-content: center">
            <img src="logo@2x.png" style="height: 100px;width: 70px">
        </div>
        <div class="col-7" style="background-color: white;display: flex;justify-content: center">
            <div class="row1">
                <span style="font-size: 12px">103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ,</span>
                <br>
                <span style="font-size: 12px">  Quận Ngũ hành Sơn, Tp. Đà Nẵng, Việt Nam</span><br>
                <span style="font-size: 12px"> 7.0 km từ Sân bay Quốc tế Đà Nẵng</span><br>
                <span style="font-size: 12px">  84-236-3847 333/888</span><br>
                <span style="font-size: 12px">  reservation@furamavietnam.com</span>
            </div>
        </div>
        <div class="col-3" style="background-color: white;display: flex;justify-content: center">
            <a  style="margin-top: 35px;font-size: 23px"> Trần Hậu Tân</a>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Facility</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Contract</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="row"></div>
<table class="table table-striped table-bordered" id="tableCustomer">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">ID_Customer_Type</th>
        <th scope="col">Name</th>
        <th scope="col">Date Of Brith</th>
        <th scope="col">Gender</th>
        <th scope="col">ID Card</th>
        <th scope="col">Phone Number</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">DELETE</th>
        <th scope="col">UPDATE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td><c:out value="${customer.id}"/></td>
            <td><c:out value="${customer.id_customer_type}"/></td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.date_of_birth}"/></td>
            <td><c:out value="${customer.gender}"/></td>
            <td><c:out value="${customer.id_card}"/></td>
            <td><c:out value="${customer.phone_number}"/></td>
            <td><c:out value="${customer.email}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td>
                <button type="button" onclick="infoDelete('${customer.getId()}','${customer.getName()}')" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
            <td>
                <a type="button" class="btn btn-primary" href="/customer?action=edit&id_customer=${customer.id}">
                    UPDATE
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <div style="margin-left: 700px">
        <a class="btn btn-primary" style="padding: 15px; width: 200px" href="/customer?action=create ">ADD CUSTOMER</a>
    </div>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="id_customer">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit"  class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</table>
</body>
</html>
