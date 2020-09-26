
<%--
  Created by IntelliJ IDEA.
  User: 李东盈
  Date: 2020/9/16
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        管理员列表
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
              <a><cite>管理员管理</cite></a>
              <a><cite>管理员列表</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">

    <xblock>
    <button class="layui-btn layui-btn-danger" id="del">
            <i class="layui-icon">&#xe640;</i>批量删除</button>
    <button class="layui-btn" id="add"><i class="layui-icon">&#xe608;</i>添加</button>
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
                角色名
            </th>
            <th>
                密码
            </th>
            <th>
                电话
            </th>
            <th>
                权限
            </th>
            <th>
                操作
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${admainlists}" var="list">
            <tr>
                <td><input type="checkbox" name="id" value="${list.aid}"></td>
                <td>${list.aid}</td>
                <td>${list.aname}</td>
                <td>${list.apassword}</td>
                <td>${list.phone}</td>
                <td>
                    <c:if test="${fn:contains(list.right,4)}">超级管理员</c:if>
                    <c:if test="${fn:contains(list.right,1)}">处理投诉</c:if>
                    <c:if test="${fn:contains(list.right,2)}">账号管理</c:if>
                    <c:if test="${fn:contains(list.right,3)}">审核商品权限</c:if>
                    <c:if test="${fn:contains(list.right,5)}">通用权限</c:if>
                </td>
                <td class="td-manage">
                    <a title="编辑" href="${pageContext.request.contextPath}/WEB-INF/views/administrator/pro_add.jsp?aid=${list.aid}"
                        class="ml-5" style="text-decoration:none">
                        <i class="layui-icon">&#xe642;</i>
                   </a>
                        <a title="删除" href="javascript:confirm('是否删除${list.aname}的用户？')?location.href='${pageContext.request.contextPath}/admin/deleteAdmins?id=${list.aid}':void(0)"
                            style="text-decoration:none">
                                 <i class="layui-icon">&#xe640;</i>
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
    const BASE_PATH="${pageContext.request.contextPath}";
    let allCheckbox = document.querySelector("#all");
    let aidCheckboxList = Array.from(document.querySelectorAll("input[name=id]"));
    allCheckbox.addEventListener("change",e=>{
        aidCheckboxList.forEach(c=>{
            c.checked=allCheckbox.checked
        })
    })
    let addBtn = document.querySelector("#add");
    addBtn.addEventListener("click",e=>{
        location.href=BASE_PATH+"/administrator/pro_add.jsp";
    })
    let delBtn = document.querySelector("#del");
    delBtn.addEventListener("click",e=>{
        let queryString = aidCheckboxList.filter(c=>c.checked).map(c=>"id="+c.value).join("&")
        if (confirm("是否删除选中的用户？")){
            location.href=BASE_PATH+"/admin/deleteAdmins?"+queryString;
        }
    })

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