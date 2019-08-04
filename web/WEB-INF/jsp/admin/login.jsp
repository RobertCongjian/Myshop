<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登录页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="/css/admin/login.css">


</head>
<body>
<div class="login">
    <div class="box">
        <div class="zhuangshi"><img src="/images/admin/background2.png" height="100", width="85"></div>
        <div class="wenzi">管理员登录</div>
        <div class="form">
            <form action="admin/login" method="post">
                <div class="name">
                    <label>用户名</label><input type="text" name="aname" placeholder="用户名" class="text"><br>
                </div>
                <div class="paw">
                    <label>密　码</label><input type="password" name="apwd" placeholder="密码" class="text"><br>
                    <input type="submit" value="登录" class="submit">
                </div>
                <div align="left" style="color: red; font-size:18px">${msg}</div>
            </form>

        </div>
    </div>
</div>
</body>
</html>
