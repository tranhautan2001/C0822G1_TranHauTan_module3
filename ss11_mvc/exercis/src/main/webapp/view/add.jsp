<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 01/12/2022
  Time: 10:45 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Thêm mới sản phẩm</h1>
<form method="post">
    <pre>Tên sản phầm : <input type="text" name="name"></pre>
    <pre>Giá: <input type="text" name="point"></pre>
    <pre>Mô tả : <input type="text" name="describe"></pre>
    <pre>Nhà sản xuất : <input type="text" name="producer"></pre>
    <a ><button >Lưu</button> </a>
</form>
<a href="/product">< Quay lại trang Danh sách sản phẩm</a>
</body>
</html>
