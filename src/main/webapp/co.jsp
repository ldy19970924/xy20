<%--
  Created by IntelliJ IDEA.
  User: 李东盈
  Date: 2020/9/19
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>投诉</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/complaint" method="post">
    <input type="hidden" value="findAllComplaint" name="findAllComplaint">
    <input type="submit" value="查询">
</form>
</body>
</html>
