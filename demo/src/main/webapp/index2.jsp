<%--
  Created by IntelliJ IDEA.
  User: Phuong Anh
  Date: 22-Nov-24
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.demo.entity.Product" %>
<%@ page import="com.demo.models.ProductModel" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>

<%
    ProductModel productModel = new ProductModel();
    Product product = productModel.findById(1);
    List<Product> products = productModel.findAll();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>

<h3>Product Info</h3>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Create</th>
    </tr>
    <tr>
        <td>
            <%= product.getId()%>
        </td>
        <td>
            <%= product.getName()%>
        </td>
        <td>
            <%= product.getPrice()%>
        </td>
        <td>
            <%= simpleDateFormat.format(product.getCreated())%>
        </td>
    </tr>
</table>


<h3>Product List</h3>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Create</th>
        <th>Photo</th>
        <th>Quantity</th>
    </tr>
    </tr>
    <% for (Product p : products) { %>
    <tr>
        <td><%= p.getId() %>
        </td>
        <td><%= p.getName() %>
        </td>
        <td><%= p.getPrice()%>
        </td>
        <td><%= simpleDateFormat.format(p.getCreated())%>
        </td>
        <td><%= p.getPhoto()%>
        </td>
        <td><%= p.getQuantity()%>
        </td>
    </tr>
    <% } %>
</table>

