<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加联系人</title>
    <style type="text/css">
        body{
            background-size: 100%;
        }
    </style>
</head>
<body background="R-C.jpg">
    <h1 align="center">联系人添加</h1>
<div align="center">
    <form action="${pageContext.request.contextPath}/add" method="get">
        <table>
            <tr>
                <th>联系人名字:</th>
                <th><input type="text" name="contact"></th>
            </tr>
            <tr>
                <th>联系人电话号码 :</th>
                <th><input type="text" name="number"></th>
            </tr>
            <tr>
                <th>号码归属地 :</th>
                <th><input type="text" name="homeloc"></th>
            </tr>
            <tr>
                <th>地址备注 :</th>
                <th><input type="text" name="address"></th>
            </tr>
            <th colspan="2"><input type="submit" value="添加"> <input type="button" value="返回" onclick="window.history.back()"></th>
        </table>
    </form>
</div>

    <h3 style="position: absolute;right: 10%;bottom: 10%;color: palegreen"> 2040102155李瑜   snpyy</h3>
</body>
</html>