<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<a href="${pageContext.request.contextPath}/demo3?id=123&username=acc1">To
    Demo3</a>


<h3>Names</h3>
<ul>
    <c:forEach var="name" items="${names}">
        <li>${name}</li>
    </c:forEach>

</ul>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Created</th>
        <th>Photo</th>
        <th>Quantity</th>
        <th>Sub total</th>
    </tr>
    <c:set var="total" value="0"/>
    <c:forEach var="product" items="${products}">
        <c:set var="subTotal" value="${product.price * product.quantity}"/>
        <c:set var="total" value="${total + subTotal}"/>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><fmt:formatDate value="${product.created}"
                                pattern="dd/MM/yyyy"/></td>
            <td>
                <img src="${pageContext.request.contextPath}/asserts/images/${product.photo}">
            </td>
            <td>${product.quantity}</td>
            <td>
                <c:if test="${product.quantity < 10}">
                    <span style="color: red">Gan het hang</span>
                </c:if>
                <c:if test="${product.quantity > 10}">
                    <span style="color: blue">Con hang</span>
                </c:if>
            </td>
            <td>${subTotal}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7">Total</td>
        <td>${total}</td>
    </tr>
    <tr>
        <td colspan="7">Total 2</td>
        <td>${total2}</td>
    </tr>
</table>