<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/9/17
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详情</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/myCartServlet" method="post">
    <c:if test="${not empty product}">
    <input type="hidden" name="method" value="addCart">
    <input type="hidden" name="id" value="${product.productid}">
        <ul>
            <li>${product.productname}</li>
            <li><img id="img" src="${pageContext.request.contextPath}/${product.productimage}"></li>
            <li>${product.productprice}</li>
            <li>${product.origin}</li>
            <li>购买数量：<input type="text" name="count"/></li>
            <li><input type="submit" value="加入购物车"></li>
     </ul>
    </c:if>
</form>
</body>
</html>
