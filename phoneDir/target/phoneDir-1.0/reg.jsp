<%--
  Created by IntelliJ IDEA.
  User: 遂宁彭于晏
  Date: 2022/5/14
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            background-size: 100%;
        }
    </style>
    <script src="js/register.js"></script>
</head>
<body background="R-C.jpg">
<h1>This is Register Page!!</h1>
<h3>Created by snpyy</h3>
<h1 align="center">用户注册</h1>
<div style="position: absolute;left: 40%">
    <form  action="${pageContext.request.contextPath}/register" onsubmit="return smt('namespan','pswspan1','pswspan2')">
        <table >
            <tr>
                <td>用户名:</td>
                <td><input type="text" id="username" name="username" onfocus="removeText('namespan')" onblur="doCheck('username','namespan')"><span id="namespan">         </span></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" id="password" name="password" onfocus="removeText('pswspan1')" onblur="doReg('password','pswspan1')"> <span id="pswspan1"></span>        </td>
            </tr>
            <tr>
                <td>确认密码:</td>
                <td><input type="password" id="config" name="password" onfocus="removeText('pswspan2')" onblur="doConfig('password','config','pswspan2')"><span id="pswspan2">        </span></td>
            </tr>
            <tr><td  colspan="2"><input type="submit" value="注册">&nbsp<input type="reset" value="重置"></td></tr>
            <tr><td  colspan="2"><a href="index.jsp" >已有账号,返回登录.</a></td></tr>
        </table>
    </form>
</div>

<h3 style="position: absolute;right: 10%;bottom: 10%;color: palegreen"> 2040102155李瑜   snpyy</h3>
</body>
</html>
