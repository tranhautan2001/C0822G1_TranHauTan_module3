<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 25/11/2022
  Time: 11:05 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
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
            <a class="nav-link active" aria-current="page" href="/employee">Employee</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/customer">Customer</a>
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
  <div class="container-fluid">
    <div class="row">
      <div class="col-3">
        <div class="card" style="width: 23rem;">
          <img src="https://furamavietnam.com/wp-content/uploads/2018/07/CULIRARY.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 style="margin-left: 110px" class="card-title">Ẩm Thực</h5>
            <a style="margin-left: 75px" href="#" class="btn btn-primary">Khám Phá Ngay</a>
          </div>
        </div>
        <div class="card" style="width: 23rem;">
          <img src="https://furamavietnam.com/wp-content/uploads/2018/07/RECREATION.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 style="margin-left: 110px" class="card-title">Giải Trí</h5>
            <a style="margin-left: 70px" href="#" class="btn btn-primary">Khám Phá Ngay</a>
          </div>
        </div>
        <div class="card" style="width: 23rem;">
          <img src="https://furamavietnam.com/wp-content/uploads/2018/07/CULIRARY.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 style="margin-left: 110px" class="card-title">Sự Kiên</h5>
            <a style="margin-left: 70px" href="#" class="btn btn-primary">Khám Phá Ngay</a>
          </div>
        </div>
      </div>
      <div class="col-9">
        <img src="Ariyana-Tourism-Complex-Danang-FINAL.jpg" height="1000" width="1227"/></div>
    </div>
  </div>
  <div>
    <div class="container-fluid">
      <div class="row" style="height:300px">
        <div class="col-1 " style="background-color: cadetblue">
        </div>
        <div class="col-3" style="background-color: white">
          <span style="font-size: 25px; display: flex; justify-content: center">Hướng Dẫn Di Chuyển</span><br>
          <span style="font-size: 12px">Khu nghỉ dưỡng Furama là cơ sở hàng đầu để</span>
          <span style="font-size: 12px">khám phá một trong những điểm đến hấp dẫn</span>
          <span style="font-size: 12px">nhất Châu Á. Chỉ cách Đà Nẵng một quãng lái xe</span>
          <span style="font-size: 12px">ngắn là bốn Di sản Văn hóa Thế giới được</span>
          <span style="font-size: 12px">UNESCO công nhận:</span>
          <br>
          <br>

          <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
            <path d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A31.493 31.493 0 0 1 8 14.58a31.481 31.481 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94zM8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10z"/>
            <path d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
          </svg>
          <button style="background-color:darkgreen; color: white" > Xem Trên Bản Đồ</button>
          <br>
          <a style="font-size: 25px; display: flex; justify-content: center">Địa Điểm</a>
        </div>
        <div class="col-8" style="background-color:cadetblue">


        </div>
      </div>
    </div>
  </div>
  </body>
</html>
