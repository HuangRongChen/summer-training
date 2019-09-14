<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>商品信息</title>
</head>
<body>

<%@ include file="head.jspf" %>

<form method="post" action="FrmPartInfo">
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

<div><a href="FrmPartInfo.append">增加</a></div>

<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>规格</th>
        <th>单位</th>
        <th>库存</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${dataSet.records}" var="record">
        <tr>
            <td>${record.items.code_}</td>
            <td>${record.items.desc_}</td>
            <td>${record.items.spec_}</td>
            <td>${record.items.unit_}</td>
            <td>${record.items.stock_}</td>
            <td>${record.items.remark_}</td>
            <td><a href="FrmPartInfo.modify?code=${record.items.code_}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>