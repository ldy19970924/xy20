<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/9/17
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的购物车</title>
</head>
<body>
    <h2>我的购物车</h2>
<p><a href="<c:url value='${pageContext.request.contextPath}/myCartServlet?method=clearCart'/>">清空</a></p>

    <table border="1" width="100%" cellspacing="0">
        <tr>
            <td>图片</td>
            <td>商品名称</td>
            <td>单价</td>
            <td>数量</td>
            <td>小计</td>
            <td>加|减</td>
            <td>操作</td>
        </tr>
        <c:if test="${not empty sessionScope.cart}">
            <!-- 遍历cart成员变量map映射里面的CartItem集合（value），getCartItems() -->
            <c:if test="${not empty sessionScope.cart.cartItems}">
                <c:forEach items="${sessionScope.cart.cartItems}" var="item">
                    <tr>
                        <td><img src="${pageContext.request.contextPath}/${item.product.productimage}" width="120px" height="100px"></td>
                        <td>${item.product.productname}</td>
                        <td>${item.product.productprice}</td>
                        <td>${item.count}</td>
                        <td>${item.subtotal}</td>
                        <td>
                            <a href="<c:url value='/myCartServlet?method=changeCount&count=1&id=${item.product.productid}'/>">+</a>&nbsp;&nbsp;
                            <a href="<c:url value='/myCartServlet?method=changeCount&count=-1&id=${item.product.productid}'/>">-</a>
                        </td>
                        <td>
                            <a href="<c:url value='/myCartServlet?method=removeItem&id=${item.product.productid}'/>">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <tr>
                <td colspan="7">总计：<span style="color:red;font-size:18px">${sessionScope.cart.total}</span>
                   <%-- <span><a href="<c:url value='/order/OrderServlet?method=addOrder'/>">生成订单</a></span>--%>
                </td>
            </tr>
        </c:if>
    </table>

</body>
</html>
