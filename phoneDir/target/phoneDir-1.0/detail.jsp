<%--
  Created by IntelliJ IDEA.
  User: 遂宁彭于晏
  Date: 2022/5/15
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head background="R-C.jpg">
    <title>联系人详细</title>
    <style type="text/css">
        body{
            background-size: 100%;
        }
    </style>
</head>
<body background="R-C.jpg">
<h1 align="center">联系人详细页面..</h1>
<hr>
<div align="center">
    <table style="border: 1px black solid;font-size: 20px">
            <tr>
                <th>联系人名字:</th>
                <th>${phoneDirDetail.contact}</th>
            </tr>
            <tr>
                <th>联系人电话号码:</th>
                <th>${phoneDirDetail.number}</th>
            </tr>
            <tr>
                <th>号码归属地:</th>
                <th>${phoneDirDetail.homeLoc}</th>
            </tr>
            <tr>
                <th>地址备注:</th>
                <th>${phoneDirDetail.address}</th>
            </tr>

    </table>
    <input type="button"  value="返回" onclick="window.history.back()">
</div>
<h3 style="position: absolute;right: 10%;bottom: 10%;color: palegreen"> 2040102155李瑜   snpyy</h3>
</body>
</html>
