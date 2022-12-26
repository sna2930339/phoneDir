<%--
  Created by IntelliJ IDEA.
  User: 遂宁彭于晏
  Date: 2022/5/14
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>登录页面 welcome</title>
    <style type="text/css">
        body{
            background-size: 100%;
        }
    </style>
</head>
<body background="R-C.jpg">
<h1>欢迎来到snpyy的世界</h1>
<%--<h3>servlet + jsp + EL表达式 + jstl标签库 + Filter过滤器 的单表CRUD操作</h3>--%>

<hr>
<h1 align="center">通讯簿管理系统</h1>
<div style="border:1px solid;position: absolute;top:25%;left:40%;width: 20%;height: 30%;font-size: 25px" >
    <h3>&nbsp&nbsp 用户登录</h3>
    <div align="center">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <table >
                <tr>
                    <td><font size="5px">用户名:</font> </td>
                    <td><input type="text" name="user"></td>
                </tr>
                <tr>
                    <td><font size="5px"> 密 码:</font></td>
                    <td><input type="password" name="psw"></td>
                </tr>
                <tr>
                    <th><input type="submit" value="登录"></th>
                    <th><input type="checkbox" name="f" value="1">三天免登陆</th>
                </tr>
                <tr>
                    <th colspan="2"><a  href="reg.jsp">没有账户?点击立即注册</a> </th>
                </tr>
            </table>
        </form>
    </div>
</div>

<h3 style="position: absolute;right: 10%;bottom: 10%;color: palegreen"> 2040102155李瑜   snpyy</h3>
</body>
</html>
