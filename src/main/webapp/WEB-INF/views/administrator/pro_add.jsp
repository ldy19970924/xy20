<%--
  Created by IntelliJ IDEA.
  User: 李东盈
  Date: 2020/9/16
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        ${empty administrator ?'新增管理员':'修改管理员信息'}
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" media="all">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/loading/okLoading.js"></script>
    <style>
        .imgs{display: none;}
    </style>

</head>
<body>

<div class="x-body">
    <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/admin/${empty administrator?'insertAdmains':'updateRight'}" method="post" >
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <div class="layui-tab-content" >
                <div class="layui-tab-item layui-show">
                    <input type="hidden" name="aid" id="aid" value="${param.aid}">
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>姓名
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="aname" autocomplete="off" placeholder="空制在10个汉字，15个字符以内"
                                   class="layui-input" value="${administrator.aname}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>密码
                        </label>
                        <div class="layui-input-block">
                            <input type="password" name="apassword" autocomplete="off" placeholder="空制在10个汉字，15个字符以内"
                                   class="layui-input" value="${administrator.apassword}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>电话
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="phone" autocomplete="off" placeholder="请输入正确的手机号"
                                   class="layui-input" value="${administrator.phone}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>选择权限
                        </label>
                        <div class="layui-input-block">
                            <select name="community_id" id="community_id">
                                <option value="0">---请选择权限---</option>
                                <option name="right" value="1" ${administrator.right=='1'?'checked':''}>处理投诉</option>
                                <option name="right" value="2" ${administrator.right=='2'?'checked':''}>账号管理</option>
                                <option name="right" value="3" ${administrator.right=='3'?'checked':''}>审核管理</option>
                                <option name="right" value="5" ${administrator.right=='5'?'checked':''}>通用管理员</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" type="submit" lay-filter="add" lay-submit="">
                            保存
                        </button>
                    </div>

                    <div style="height:100px;"></div>
                </div>

            </div>

        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>

<script>
    layui.use(['laydate','element','layer','form'], function(){
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form();
        laydate = layui.laydate;//日期插件
        okLoading.close($);
        form.render();


        //监听提交
        // form.on('submit(add)', function(data){
        //     var project_name=$("input[name='project_name']:checked").val();
        //     var community_id=$('#community_id option:selected') .val();//所属栏目ID
        //
        //     if(project_name==""){
        //         layer.msg('项目名称不能为空',{icon:5,time:2000});return false;
        //     }
        //     if(community_id==""){
        //         layer.msg('所属小区不能为空',{icon:5,time:2000});return false;
        //     }
        //
        //
        //     var data=data.field;
        //     $.ajax({
        //         type:"post",
        //         url:"xxx",
        //         data:data,
        //         dataType:"json",
        //         success:function(data){
        //             if(data.status==1){
        //                 layer.msg(data.info, {icon: 6,time:2000},function () {
        //                     window.parent.location.reload();
        //                     var index = parent.layer.getFrameIndex(window.name);
        //                     parent.layer.close(index);
        //                 });
        //                 return false;
        //
        //             }
        //             else{
        //                 layer.msg(data.info,{icon:5,time:2000});return false;
        //             }
        //         }

        //     });
        // });

    })
</script>
<!--栏目缩略图上传-->
<%--<script>--%>
<%--    function upload()--%>
<%--    {--%>
<%--        var formData = new FormData();--%>
<%--        formData.append('images', $('#previewImg')[0].files[0]);--%>
<%--        //console.log(formData);--%>
<%--        layer.msg('图片上传中', {icon: 16});--%>
<%--        $.ajax({--%>
<%--            type:"post",--%>
<%--            processData: false,--%>
<%--            contentType: false,--%>
<%--            url:"xxx",--%>
<%--            data:formData,--%>
<%--            success:function(data){--%>
<%--                if(data.status == 1){--%>
<%--                    console.log(data.image_name);--%>
<%--                    layer.closeAll('loading');--%>
<%--                    //layer.msg(data.info,{icon:1,time:1000});--%>
<%--                    $("#pimages").attr('src',data.image_name);--%>
<%--                    $("#avatar").val(data.image_name);--%>
<%--                    $(".imgs").show();--%>
<%--                    return false;--%>
<%--                }else{--%>
<%--                    layer.msg(data.info,{icon:2,time:1000});--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>
<%-- </script>--%>

</body>
</html>