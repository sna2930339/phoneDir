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
    <title>修改密码</title>
    <style type="text/css">
        body{
            background-size: 100%;
        }
    </style>
</head>
<body background="R-C.jpg">
<h1 align="center">修改密码..</h1>
<script src="js/modifypsw.js"></script>
<script src="js/register.js"></script>
<div align="center">
    <form action="${pageContext.request.contextPath}/modifypsw" method="get" onsubmit="return smt('oldspan','newspan','confspan')">
        <table>
            <tr><th colspan="2">用户:${user.username}</th> </tr>
            <tr>
                <td>账号原密码:</td>
                <td><input type="text" id="oldpsw" onblur="matchpsw('${user.password}')" onfocus="removeText('oldspan')"><span id="oldspan"></span></td>
            </tr>
            <tr>
                <td>账号新密码:</td><td>
                <input type="text" id="newpsw" onblur="doReg('newpsw','newspan')" onfocus="removeText('newspan')"><span id="newspan">   </span></td>
            </tr>
            <tr>
                <td>确认新密码:</td><td>
                <input type="text" id="configpsw" name="newpsw" onblur="doConfig('newpsw','configpsw','confspan')" onfocus="removeText('confspan')"><span id="confspan" >   </span></td>
            </tr>
            <tr><td colspan="2"><input type="submit"  value="修改"> &nbsp<input type="button" value="返回" onclick="window.history.back()"></td> </tr>
        </table>
    </form>
</div>
<hr>

<h3 style="position: absolute;right: 10%;bottom: 10%;color: palegreen"> 2040102155李瑜   snpyy</h3>
</body>
</html>
