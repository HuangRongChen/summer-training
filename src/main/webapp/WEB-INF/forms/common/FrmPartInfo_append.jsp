<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>商品信息</title>
</head>
<body>

<%@ include file="head.jspf" %>

<div>
    <a href="FrmPartInfo">返回</a>
</div>

<form method="post" action="FrmPartInfo.append">
    <div>
        <label for="code">编号</label>
        <input id="code" name="code" value="${param.code}"/>
    </div>
    <div>
        <label for="desc">名称</label>
        <input id="desc" name="desc" value="${param.desc}"/>
    </div>
    <div>
        <label for="spec">规格</label>
        <input id="spec" name="spec" value="${param.spec}"/>
    </div>
    <div>
        <label for="unit">单位</label>
        <input id="unit" name="unit" value="${param.unit}"/>
    </div>
    <div>
        <label for="remark">备注</label>
        <input id="remark" name="remark" value="${param.remark}"/>
    </div>
    <button id="submit" name="submit" value="append">保存</button>
</form>

</body>
</html>