<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 30/11/2022
  Time: 10:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Calculator$</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form method="post" action="calculator">
    <table>
      <tr>
        <td>Số Thứ nhất: </td>
        <td><input name="firstOperand" type="text"/></td>
      </tr>
      <tr>
        <td>Phép tình: </td>
        <td>
          <select name="operator">
            <option value="+">Cộng</option>
            <option value="-">Trừ</option>
            <option value="*">Nhân </option>
            <option value="/">Chia</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Số thứ 2: </td>
        <td><input name="secondOperand" type="text"/></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Calculate"/></td>
      </tr>
    </table>
  </form>

  </body>
</html>
