<%--
  Created by IntelliJ IDEA.
  User: 遂宁彭于晏
  Date: 2022/5/15
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>编辑联系人</title>
    <style type="text/css">
        body{
            background-size: 100%;
        }
    </style>
</head>
<body background="R-C.jpg">
    <h1 align="center">编辑联系人..</h1>

    <div align="center">
        <form action="${pageContext.request.contextPath}/domodify" method="get">
            <table>
                <tr>
                    <th>ID:</th>
                    <th><input type="text" name="id" readonly value="${phoneDirDetail.id}"></th>
                </tr>
                <tr>
                    <th>联系人名字:</th>
                    <th><input type="text" name="contact" value="${phoneDirDetail.contact}"></th>
                </tr>
                <tr>
                    <th>联系人电话号码 :</th>
                    <th><input type="text" name="number" value="${phoneDirDetail.number}"></th>
                </tr>
                <tr>
                    <th>号码归属地 :</th>
                    <th><input type="text" name="homeloc" value="${phoneDirDetail.homeLoc}"></th>
                </tr>
                <tr>
                    <th>地址备注 :</th>
                    <th><input type="text" name="address" value="${phoneDirDetail.address}"></th>
                </tr>
                <th colspan="2"><input type="submit" value="修改"> <input type="button" value="返回" onclick="window.history.back()"></th>
            </table>
        </form>
    </div>
<hr>

    <h3 style="position: absolute;right: 10%;bottom: 10%;color: palegreen"> 2040102155李瑜   snpyy</h3>
</body>
</html>
