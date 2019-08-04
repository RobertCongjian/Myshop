<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>addGoods.jsp</title>
    <link href="css/admin/common.css" type="text/css" rel="stylesheet">
    <%-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
     <script type="text/javascript">
         $(document).ready(function () {

             alert(${goodsType.size()});
             var data = new Array();
             data = ${goodsType};
             for (var j = 0; j < data.length; j++)
                 $("#selectId").append("<option value='" + data[j].id + "'>" + data[j].id + "</option>");
         });
     </script>--%>
</head>
<body>
<form action="/adminGoods/addGoods" method="post" enctype="multipart/form-data">
    <table border=1 style="border-collapse: collapse">
        <caption>
            <font size=4 face=华文新魏>添加商品</font>
        </caption>
        <tr>
            <td>名称<font color="red">*</font></td>
            <td>
                <input name="gname" class="text"/>
            </td>
        </tr>
        <tr>
            <td>原价<font color="red">*</font></td>
            <td>
                <input name="goprice" class="text"/>
            </td>
        </tr>
        <tr>
            <td>折扣价</td>
            <td>
                <input name="grprice" class="text"/>
            </td>
        </tr>
        <tr>
            <td>库存</td>
            <td>
                <input name="gstore" class="text"/>
            </td>
        </tr>
        <tr>
            <td>图片</td>
            <td>
                <input type="file" name="multipartFile"/>
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
</body>
</html>
