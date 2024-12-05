<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<h3>Find By Price</h3>
<form method="get" action="${pageContext.request.contextPath}/product">
    Keyword <input type="text" name="keyword">
    <br>
    <button type="submit">Search</button>
    <input type="hidden" name="action" value="search-by-keyword">
</form>

<h3>Find By Price</h3>
<form method="get" action="${pageContext.request.contextPath}/product">
    Min <input type="text" name="min">
    <br>
    Max <input type="text" name="max">
    <button type="submit">Search</button>
    <input type="hidden" name="action" value="search-by-price">
</form>
<br><br>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Created</th>
        <th>Photo</th>
        <th>Quantity</th>
        <th>Note</th>
        <th>Sub total</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <c:set var="subTotal" value="${product.price * product.quantity}"/>
        <tr>
            <td>${product.id}</td>
            <td>
                <a
                        href="${pageContext.request.contextPath}/product?action=details&id=${product.id}
">${product.name}</a>
            </td>
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
</table>