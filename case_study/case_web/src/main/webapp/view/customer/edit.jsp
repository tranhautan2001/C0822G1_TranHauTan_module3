<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 25/11/2022
  Time: 3:27 CH
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
            <a style="margin-top: 35px;font-size: 23px"> Trần Hậu Tân</a>
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
                    <a class="nav-link active" aria-current="page" href="/customer">Customer</a>
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
<form method="post" action="/customer?action=edit">
    <div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
        <input type="text" class="form-control" name="id_customer" placeholder="STT" aria-label="Username" aria-describedby="basic-addon1" value="<c:out value='${customer.id}'/>">
    </div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <select name="id_customer_type">
        <option value="1">Diamond</option>
        <option value="2">Platinium</option>
        <option value="3">Gold</option>
        <option value="4">Silver</option>
        <option value="5">Member</option>
    </select>
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center ;margin-bottom: 10px">
    <input type="text" class="form-control" name="name" placeholder="Name" aria-label="Username" aria-describedby="basic-addon1"  value="<c:out value='${customer.name}'/>">
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <input type="date" class="form-control" name="date_of_birth" placeholder="Date Of Birth" value="<c:out value='${customer.date_of_birth}'/>">
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <input type="text" class="form-control" name="gender"  placeholder="Gender" value="<c:out value='${customer.gender}'/>">
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <input type="text" class="form-control" name="id_card" placeholder="ID Card" aria-label="Username" aria-describedby="basic-addon1" value="<c:out value='${customer.id_card}'/>">
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <input type="text" class="form-control" name="phone_number" placeholder="Phone Number" aria-label="Username" aria-describedby="basic-addon1" value="<c:out value='${customer.phone_number}'/>">
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <input type="text" class="form-control" name="email" placeholder="Email" aria-label="Username" aria-describedby="basic-addon1" value="<c:out value='${customer.email}'/>">
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <input type="text" class="form-control" name="address" placeholder="Address" aria-label="Username" aria-describedby="basic-addon1" value="<c:out value='${customer.address}'/>">
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <button type="submit" value="Save" class="btn btn-primary" data-bs-toggle="modal">Update </button>
</div>

</form>
</body>
</html>
