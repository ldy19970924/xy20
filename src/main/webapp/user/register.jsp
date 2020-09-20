<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/9/15
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<body>
<h3>尊敬的用户，欢迎您使用注册功能</h3>
<form action="${pageContext.request.contextPath}/register" method="post" enctype="multipart/form-data">
    <input id="uName" type="text" name="uName" placeholder="请输入用户名"/><br/>
    <input type="password" name="password" placeholder="请输入密码"/><br/>
    <input type="password" name="repeatPassword" placeholder="请重复输入密码"/><br/>
    请上传图片头像:<input type="file" name="image"/>${message}<br/>
    <input type="text" name="phone" placeholder="请输入手机号"/><br/>
    <input type="text" name="ucdCard" placeholder="请输入身份证号"/><br/>
    <input type="submit" value="提交注册"/><br/>
</form>
</body>
<script>

</script>
</html>
