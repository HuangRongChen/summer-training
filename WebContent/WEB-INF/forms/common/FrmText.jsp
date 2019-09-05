<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
    <style>
        header {
            background-color:gray;
            color:white;
            text-align:center;
            padding:5px;
        }
        nav {
            line-height:30px;
            background-color:#eeeeee;
            height:300px;
            width:100px;
            float:left;
            padding:5px;
        }
        section {
            width:350px;
            float:left;
            padding:10px;
        }
        footer {
            background-color:black;
            color:white;
            clear:both;
            text-align:center;
            padding:5px;
        }
    </style>
</head>

<body>

<header> <h1>城市介绍</h1> </header>

<nav>
    伦敦<br>
    巴黎<br>
    北京<br>
</nav>

<section>
    <h1>伦敦：</h1>
    <p>伦敦是英格兰的首都。它是英国人口最多的城市，拥有超过1300万居民的大都市区。</p>
    <p>伦敦站在泰晤士河上，已经成为两千年来的主要定居点，
       其历史可以追溯到罗马人的建立，他们将其命名为Londinium。
    </p>
</section>

<footer>
    网页底部
</footer>


</body>
</html>
