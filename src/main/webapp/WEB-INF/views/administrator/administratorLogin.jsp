<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/9/16
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录页面</title>
</head>
<body>
<h3>尊敬的用户，欢迎您使用管理员登录功能</h3>
<form method="post" action="/administratorLogin">
    用户名:<input type="text" name="aname"/><br/>
    密码:<input type="password" name="apassword"/><br/>
    <input type="submit" value="登录"/><br/>
</form>
</body>
</html>
