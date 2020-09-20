<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/9/16
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <style type="text/css">
        #img{
            width: 100px;
            height: 80px;
        }
        td{
            margin: 15px;
            padding: 15px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/product" method="post">
    <input type="hidden" name="method" value="findAll">
    <input type="text" name="name">
    <input type="submit" value="搜索">
</form>
    <table>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品图片</th>
            <th>上架时间</th>
            <th>库存</th>
            <th>单价</th>
            <th>产地</th>
            <th>描述</th>
            <th></th>
        <c:forEach items="${requestScope.productList}" var="product">
            <tr>
                <td>${product.productid}</td>
                <td>${product.productname}</td>
                <td><img id="img" src="${pageContext.request.contextPath}/${product.productimage}"></td>
                <td>${product.producttime}</td>
                <td>${product.productcount}</td>
                <td>${product.productprice}</td>
                <td>${product.origin}</td>
                <td>${product.describe}</td>
                <td><a href="<c:url value='/product?method=findByID&id=${product.productid}'/>">购买</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
