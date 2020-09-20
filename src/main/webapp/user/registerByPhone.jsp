<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/9/15
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>注册页面</title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<body>
<h3>尊敬的用户，欢迎您使用注册功能</h3>
<form action="${pageContext.request.contextPath}/registerByPhone" method="post">
    <input type="text" name="phone" placeholder="输入手机号"/><br/>
    <input type="password" name="password" placeholder="输入密码"/><br/>
    <input type="password" name="aPassword" placeholder="请再输入一次密码"/><br/>
    <input type="text" name="code" placeholder="请输入验证码"/>
    <input type="button" value="获取验证码" id="code"/><br/>
    <input type="text" name="ucdCard" placeholder="输入身份证"/><br/>
    <input type="submit" value="提交注册"/><br/>
</form>
</body>
<script type="text/javascript">
    let time = 60;
    $("#code").click(
        function (){
            let tm = setInterval(function (){
                time--;
                if(time == 0){
                    $("#code").removeAttr("disabled");
                    $("#code").val("获取验证码");
                    clearInterval(tm);
                }else{
                    $("#code").attr("disabled","true");
                    $("#code").val(time+"以后重新发送");
                }

            },1000);
            $.ajax({
                "type":"GET",
                "url":"/CodeServlet",
                "data":{"phone":$("#phone").val()}
            });

        }

    );
</script>
</html>
