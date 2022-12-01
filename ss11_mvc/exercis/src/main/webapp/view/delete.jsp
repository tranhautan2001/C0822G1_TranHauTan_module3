<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 01/12/2022
  Time: 4:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xoá một sản phẩm</title>
</head>
<body>
<h1>Xóa sản phẩm</h1>
<form method="post">
    <pre>ID : <span>${product.getId()}</span></pre>
    <pre>Tên sản phẩm : <span>${product.getName()}</span></pre>
    <pre>Giá : <span>${product.getPoint()}</span></pre>
    <pre>mô tả sản  : <span>${product.getDescribe()}</span></pre>
    <pre>nhà sản xuất  : <span>${product.getProducer()}</span></pre>
    <pre>               <button >Xóa sản phẩm</button></pre>
</form>
<a href="/product">< Quay lại trang Danh sách sản phẩm</a>
</body>
</html>
