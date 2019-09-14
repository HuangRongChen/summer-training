<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="head.jspf" %>

<div><a href="FrmPartInfo">返回</a></div>
<form method="post" action="FrmPartInfo.append">
    <div>
        <label>编号</label>
        <input id="code" name="code" value="${param.code}"/>
    </div>
    <div>
        <label>名称</label>
        <input id="name" name="name" value="${param.name}"/>
    </div>
    <div>
        <label>价格</label>
        <input id="price" name="name" value="${param.price}"/>
    </div>
    <div>
        <label>库存</label>
        <input id="age" name="age" value="${param.number}"/>
    </div>
    <button name="submit" value="append">保存</button>
</form>
</body>
</html>