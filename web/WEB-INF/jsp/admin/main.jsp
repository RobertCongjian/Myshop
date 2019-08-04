<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>后台主页面</title>
    <link rel="stylesheet" type="text/css" href="/css/admin/main.css">
</head>
<body>
<div id="header">
    <br>
    <br>
    <h1>欢迎${admin.aname}进入后台管理系统！</h1>
</div>
<div id="navigator">
    <ul>
        <li><a>商品管理</a>
            <ul>
                <li><a href="adminGoods/toAddGoods" target="center">添加商品</a></li>
                <li><a href="adminGoods/selectGoods?act=deleteSelect" target="center">删除商品</a></li>
                <li><a href="adminGoods/selectGoods?act=updateSelect" target="center">修改商品</a></li>
                <li><a href="adminGoods/selectGoods" target="center">查询商品</a></li>
            </ul>
        </li>
        <li><a>类型管理</a>
            <ul>
                <li><a href="adminType/toAddType" target="center">添加类型</a></li>
                <li><a href="adminType/toDeleteType" target="center">删除类型</a></li>
            </ul>
        </li>
        <li><a>用户管理</a>
            <ul>
                <li><a href="adminUser/userInfo" target="center">删除用户</a></li>
            </ul>
        </li>
        <li><a>订单管理</a>
            <ul>
                <li><a href="adminOrder/orderInfo" target="center">删除订单</a></li>
            </ul>
        </li>
        <li><a>公告管理</a>
            <ul>
                <li><a href="adminNotice/toAddNotice" target="center">添加公告</a></li>
                <li><a href="adminNotice/deleteNoticeSelect" target="center">删除公告</a></li>
            </ul>
        </li>
        <li><a href="exit">安全退出</a></li>
    </ul>

</div>
<div id="content">
    <iframe src="adminGoods/selectGoods" name="center" frameborder="0"></iframe>
</div>
<div id="footer">后台管理系统</div>
</body>
</html>


