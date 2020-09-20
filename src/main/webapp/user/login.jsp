<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/9/15
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h3>尊敬的用户，欢迎您使用登录功能</h3>
<form method="post" action="/login">
    用户名:<input type="text" name="uName"/><br/>
    密码:<input type="password" name="password"/><br/>
    <input type="submit" value="登录"/><br/>
</form>
</body>
</html>
