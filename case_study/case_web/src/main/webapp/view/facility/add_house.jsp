<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 06/12/2022
  Time: 3:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 28/11/2022
  Time: 10:43 SA
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
                    <a class="nav-link active" aria-current="page" href="#">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/facility">Facility</a>
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
<h1> Add facility</h1>
<form method="post" action="/facility?action=createHouse">
<div class="input-group flex-nowrap">
    <input type="text" class="form-control"  name="id_facility" placeholder="SST" aria-label="Username"
           aria-describedby="addon-wrapping">
</div>
<div class="input-group flex-nowrap">
    <input type="text" class="form-control" name="name_facility" placeholder="Name" aria-label="Username"
           aria-describedby="addon-wrapping">
</div>
<div class="input-group flex-nowrap">
    <input type="text" class="form-control" name="area" placeholder="Area" aria-label="Username"
           aria-describedby="addon-wrapping">
</div>
<div class="input-group flex-nowrap">
    <input type="text" class="form-control" name="cost" placeholder="Cost" aria-label="Username"
           aria-describedby="addon-wrapping">
</div>
<div class="input-group flex-nowrap">
    <input type="text" class="form-control" name="max_people" placeholder="Max People" aria-label="Username"
           aria-describedby="addon-wrapping">
</div>
<div class="input-group flex-nowrap">
    <input type="text" class="form-control" name="standard_room" placeholder="Standard room" aria-label="Username"
           aria-describedby="addon-wrapping">
</div>
<div class="input-group flex-nowrap">
    <input type="text" class="form-control" name="description_other_convenience" placeholder="Description Other Convenience" aria-label="Username"
           aria-describedby="addon-wrapping">
</div>
<div class="input-group flex-nowrap">
    <input type="text" class="form-control" name="pool_area" placeholder="Pool Area" aria-label="Username"
           aria-describedby="addon-wrapping">
</div>
<div class="input-group flex-nowrap">
    <input type="text" class="form-control" name="number_of_floors" placeholder="Number of Floors" aria-label="Username"
           aria-describedby="addon-wrapping">
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <select name="name_facility_type">
        <option value="1">Villa</option>
        <option value="2">House</option>
        <option value="3">Room</option>
    </select>
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <select name="name_rent_type">
        <option value="1">Năm</option>
        <option value="2">Tháng</option>
        <option value="3">Ngày</option>
        <option value="4">Giờ</option>
    </select>
</div>
<div class="container-fluid" style="width: 300px; display: flex ; justify-content: center; margin-bottom: 10px">
    <button type="submit" value="Save" class="btn btn-primary" data-bs-toggle="modal">ADD </button>
</div>
</form>
</body>
</html>

