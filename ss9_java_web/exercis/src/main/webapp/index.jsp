<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 28/11/2022
  Time: 9:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Discount Calculator</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
<h2> Discount Calculator</h2>
  <form action="display" method="post" >
    <label>Product Description: </label><br/>
    <input type="text" name="Description" placeholder="Enter your word: "/>
    <br>
    <label>List Price: </label>
    <br/>
    <input type="text" name="price" placeholder="Price" value="0"/>
    <br/>
    <label>Discount Percent: </label>
    <br/>
    <input type="text" name="Percent" placeholder="Percent" value="0"/>
    <br/>
    <input type="submit" id="submit" value="Calculate Discount"/>
  </form>


  </body>
</html>
