
<%--
  Created by IntelliJ IDEA.
  User: 李东盈
  Date: 2020/9/16
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>
        投诉列表
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" media="all">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>投诉管理</cite></a>
              <a><cite>投诉列表</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">

    <xblock>
        <button class="layui-btn layui-btn-danger" id="del">
            <i class="layui-icon">&#xe640;</i>批量删除</button>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <input type="checkbox" id="all">
            </th>
            <th>
                ID
            </th>
            <th>
                用户名
            </th>
            <th>
                头像
            </th>
            <th>
                手机号码
            </th>
            <th>
                状态
            </th>
            <th>
                身份证号
            </th>
            <th>
                封禁时间
            </th>
            <th>
                解封时间
            </th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allUserList}" var="list">
            <tr>
                <td><input type="checkbox" name="id" value="${list.uid}"></td>
                <td>${list.uid}</td>
                <td>${list.uname}</td>
                <td>${list.password}</td>
                <td><img src="${pageContext.request.contextPath}/image/user/${list.image}" width="50" height="30"></td>

                <td>
<%--                        ${list.ustate}--%>
                    <c:if test="${list.ustate eq 0}">正常</c:if>
                    <c:if test="${list.ustate eq 1}">封禁</c:if>
                    <c:if test="${list.ustate eq 2} ">申请解封</c:if>
                </td>
                <td>${list.ucdcard}</td>
                <td>${list.freezetime}</td>
                <td>${list.unlocktime}</td>
                <td class="td-manage">
<%--                    <a class="layui-btn layui-btn-danger" href="${pageContext.request.contextPath}/userInfo/updateUserState?uid=${list.uid}&state=启用">启用</a>--%>
<%--                    <a class="layui-btn layui-btn-danger" href="${pageContext.request.contextPath}/userInfo/updateUserState?uid=${list.uid}&state=禁用">禁用</a>--%>
                    <a title="编辑" href="${pageContext.request.contextPath}/WEB-INF/views/administrator/userstate.jsp?uid=${list.uid}"
                       class="ml-5" style="text-decoration:none">
                        <i class="layui-icon">&#xe642;</i>
                    </a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div id="page">
    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>
<script>
    <%--const BASE_PATH="${pageContext.request.contextPath}";--%>
    <%--let allCheckbox = document.querySelector("#all");--%>
    <%--let aidCheckboxList = Array.from(document.querySelectorAll("input[name=id]"));--%>
    <%--allCheckbox.addEventListener("change",e=>{--%>
    <%--    aidCheckboxList.forEach(c=>{--%>
    <%--        c.checked=allCheckbox.checked--%>
    <%--    })--%>
    <%--})--%>
    <%--let delBtn = document.querySelector("#del");--%>
    <%--delBtn.addEventListener("click",e=>{--%>
    <%--    let queryString = aidCheckboxList.filter(c=>c.checked).map(c=>"id="+c.value).join("&")--%>
    <%--    if (confirm("是否删除选中的用户？")){--%>
    <%--        location.href=BASE_PATH+"/complaint/delectComplaint?"+queryString;--%>
    <%--    }--%>
    <%--})--%>

    layui.use(['laydate','element','laypage','layer'], function(){
        $ = layui.jquery;//jquery
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层

        //以上模块根据需要引入
    });

</script>

</body>
</html>