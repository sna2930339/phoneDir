<%--
  Created by IntelliJ IDEA.
  User: 遂宁彭于晏
  Date: 2022/5/14
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>联系人列表</title>
    <style type="text/css">
        body{
            background-size: 100%;
        }
        .select{
            height: 25px;
            font-size: 20px;
            padding-left: 5px;
        }
        .button{
            height: 25px;
            font-size: 15px;

        }
        .input1{
            width: 250px;
            height: 25px;
            font-size: 20px;
            padding-left: 5px;
        }
        .div1 {
            width: 260px;
            border: 1px solid lightgray;
            background-coLor: antiquewhite;
            display: none;
        }
        .div1 p {
            padding-Left: 5px;
            margin-top: 2px;
            margin-bottom: 2px;
        }
        .div1 p:hover{
            cursor: pointer ;
            border: 1px bLue soLid;
            background-coLor: aliceblue;
        }
    </style>
</head>
<body background="R-C.jpg">
<script src="js/mainpage.js"></script>
<h1 align="center">${user.username} 的通讯录 </h1>
    <div  style="position: absolute;right: 15%">
        <h4 align="right">用户:[${user.username}]</h4>
        <h4 align="right">在线人数:${onlineCount}</h4>
        <h4 align="right"><a href="javascript:void(0)" onclick="window.location = '${pageContext.request.contextPath}/modifypsw.jsp'">修改密码</a></h4>
        <h4 align="right"><a href="javascript:void(0)" onclick="window.location = '${pageContext.request.contextPath}/exit'">退出登录</a> </h4>
    </div>
    <div style="position: absolute;left: 25%;top:25%"><a href="${pageContext.request.contextPath}/add.jsp">联系人新增</a></div>
    <div style="position: absolute;left: 47%;top:25%">
        <select id="condition" name="condition" class="select">
            <option value="number">电话号码</option>
            <option value="homeLoc">地区</option>
        </select>
    </div>
    <div style="position: absolute;left: 54%;top:25%">
        <input type="text" id="search" name="value" class="input1" onkeyup="searchAssociation()">
        <button class="button" onclick="doSearch()">搜索</button>
        <button class="button" onclick="window.location = '${pageContext.request.contextPath}/list'">返回</button>
        <div id="mydiv" class="div1"></div>
    </div>
<br/><br/><br/><br/><br/><br/><br/>
<table align="center" width="50%" border="1px" style="font-size: 20px">
    <thead>
        <tr>
            <th>序号</th>
            <th>电话簿主人</th>
            <th>联系人</th>
            <th>电话号码</th>
            <th>归属地</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="tbody">
        <c:forEach  items="${phoneDirList}" var="phoneDir" varStatus="Status">
            <tr>
                <td>${Status.index + 1}</td>
                <td>${phoneDir.master}</td>
                <td>${phoneDir.contact}</td>
                <td>${phoneDir.number}</td>
                <td>${phoneDir.homeLoc}</td>
                <th>
                    <a href="javascript:void(0)" onclick="dispatch('${phoneDir.id}','${pageContext.request.contextPath}')">删除</a>
                    <a href="${pageContext.request.contextPath}/dispatchmodify?id=${phoneDir.id}">修改</a>
                    <a href="${pageContext.request.contextPath}/detail?id=${phoneDir.id}">详细</a>
                </th>
            </tr>
        </c:forEach>
    </tbody>
</table>
<hr>
<h3 style="position: absolute;right: 10%;bottom: 10%;color: palegreen"> 2040102155李瑜   snpyy</h3>
</body>
</html>
