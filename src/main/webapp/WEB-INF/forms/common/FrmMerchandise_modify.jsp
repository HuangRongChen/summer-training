<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>商品信息</title>
</head>
<body>

<%@ include file="head.jspf" %>
<div><a href="FrmMerchandise">返回</a></div>

<form method="post" action="FrmMerchandise.modify">
    <input type="hidden" id="code" name="code" value="${record.items.code_}">
    <div>
        <label>名称</label>
        <input id="name" name="name" value="${record.items.name_}" readonly="readonly"/>
    </div>
    <div>
        <label>价格</label>
        <input id="price" name="price" value="${record.items.price_}"/>
    </div>
    <div>
        <label>库存</label>
        <input id="number" name="number" value="${record.items.number_}"/>
    </div>
    <button name="submit" value="append">保存</button>
</form>
<div>
    <a href="FrmExample.delete?code=${record.items.code_}">删除</a>
</div>
</body>
</html>