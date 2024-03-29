<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>updateAgoods.jsp</title>
    <link href="css/admin/common.css" type="text/css" rel="stylesheet">
</head>
<body>
<form action="adminGoods/addGoods?updateAct=update" method="post" enctype="multipart/form-data">
    <table border=1 style="border-collapse: collapse">
        <caption>
            <font size=4 face=华文新魏>修改商品</font>
            <input type="hidden" name="id" value="${goods.id}"/>
        </caption>
        <tr>
            <td>名称<font color="red">*</font></td>
            <td>
                <input name="gname" value="${goods.gname}"/>
            </td>
        </tr>
        <tr>
            <td>原价<font color="red">*</font></td>
            <td>
                <input name="goprice" value="${goods.goprice}"/>
            </td>
        </tr>
        <tr>
            <td>折扣价</td>
            <td>
                <input name="grprice" value="${goods.grprice}"/>
            </td>
        </tr>
        <tr>
            <td>库存</td>
            <td>
                <input name="gstore" value="${goods.gstore}"/>
            </td>
        </tr>
        <tr>
            <td>图片</td>
            <td>
                <input type="file" name="multipartFile"/>
                <br>
                <!-- 从数据库取出的文件名 -->
                <c:if test="${goods.gpicture != ''}">
                    <img alt="" width="50" height="50"
                         src="fileUpload/${goods.gpicture}"/>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>类型</td>
            <td>
                <select name="goodstype_id">
                    <c:forEach items="${goodsType}" var="s">
                        <option value=${s.id}>${s.typename}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td align="center">
                <input type="submit" value="提交"/>
            </td>
            <td align="left">
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
${msg }
</body>
</html>
