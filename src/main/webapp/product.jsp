<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product</title>
</head>


<body>
<form action="${pageContext.request.contextPath}/faramproduct/del">
    <input type="text" name="productId">
    <input type="submit" value="删除">

</form>

<form action="${pageContext.request.contextPath}/faramproduct/add">
    <label>
<input type="text" name="productName" placeholder="请输入商品名称">
<input type="text" name="productImage" placeholder="请输入商品图片">
<input type="text" name="productCount" placeholder="请输入商品数量">
<input type="text" name="productPrice" placeholder="请输入商品单价">
<input type="text" name="origin" placeholder="请输入商品产地">
<input type="text" name="describe" placeholder="请输入商品描述">
<input type="submit" value="提交">
    </label>
</form>

<a href="${pageContext.request.contextPath}/faramproduct/findAll">查询上架商品</a>
</body>
</html>
