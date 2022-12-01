<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 01/12/2022
  Time: 5:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xem chi tiết một sản phẩm</title>
</head>
<body>
<h3>Thông tin sản phẩm</h3>
<pre>Id:            <span>${product.getId()}</span></pre>
<pre>Tên sản phẩm:  <span>${product.getName()}</span></pre>
<pre>Giá :          <span>${product.getPoint()}</span></pre>
<pre>Mô tả:         <span>${product.getDescribe()}</span></pre>
<pre>Nhà sản xuất:  <span>${product.getProducer()}</span></pre>

<a href="/product">< Quay lại trang Danh sách sản phẩm</a>
</body>
</html>
