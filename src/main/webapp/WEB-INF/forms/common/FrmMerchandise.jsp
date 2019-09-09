<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>商品信息</title>
</head>
<body>

<%@ include file="head.jspf" %>

<form method="post" action="FrmMerchandise">
    <div>
        <label for="code">编号</label>
        <input id="code" name="code" value="${param.code}"/>
    </div>
    <div>
        <label for="searchText">条件</label>
        <input id="searchText" name="searchText" value="${param.searchText}"/>
    </div>
    <button>查询</button>
</form>

<div><a href="FrmExample.append">增加</a></div>

<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>价格</th>
        <th>库存</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${dataSet.records}" var="record">
        <tr>
            <td>${record.items.code_}</td>
            <td>${record.items.name_}</td>
            <td>${record.items.price_}</td>
            <td>${record.items.number_}</td>
            <td><a href="Frmmerchandise.modify?code=${record.items.code_}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>