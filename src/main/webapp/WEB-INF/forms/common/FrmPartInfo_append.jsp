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
    <button>保存</button>
</form>

</body>
</html>