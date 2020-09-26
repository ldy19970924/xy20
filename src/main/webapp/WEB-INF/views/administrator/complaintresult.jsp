<%--
  Created by IntelliJ IDEA.
  User: 李东盈
  Date: 2020/9/19
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/complaint/updateComplaint?cid=${param.cid}" method="post">
    <input type="text" name="result" placeholder="请输入处理结果">
    <input type="submit" value="提交">
</form>
</body>
</html>
