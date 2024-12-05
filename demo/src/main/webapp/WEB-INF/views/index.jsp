<%--
  Created by IntelliJ IDEA.
  User: Phuong Anh
  Date: 25-Nov-24
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<link href="${pageContext.request.contextPath}/asserts/css/styles.css"
      rel="stylesheet">
<script src="${pageContext.request.contextPath}/asserts/js/mylib.js"></script>

<h3>Index EL(Expression Language)</h3>
id: ${id}
<br>
username: ${username}
<br>
<img src="${pageContext.request.contextPath}/asserts/images/${photo}"
     width="${width}"
     height="${height}" onclick="clickMe()">

<h3>Product Info</h3>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Photo</th>
        <th>Create</th>
        <th>Quantity</th>
    </tr>
    <tr>
        <td>
            ${product.id}
        </td>
        <td>
            ${product.name}
        </td>
        <td>
            ${product.price}
        </td>
        <td colspan="2">
            <img src="${pageContext.request.contextPath}/asserts/images/${photo}"
                 width="${width}"
                 height="${height}" onclick="clickMe()">
        </td>
        <td>
            ${product.created}
        </td>
        <td>${product.quantity}</td>
    </tr>
</table>
