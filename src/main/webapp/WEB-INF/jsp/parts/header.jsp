<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%--<%@  taglib prefix="c" uri="lib/jstl-1.2.jar" %>--%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
    <title>Принятые заказы и доставки</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<%--<c:if test="${isLogin}">--%>
<div class="container">
    <nav class="navbar navbar-default">
        <form action="${pageContext.request.contextPath}/logout" method="post">
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/user/profile">Профиль</a></li>
            <li><a href="${pageContext.request.contextPath}/workers/">Сотрудники</a></li>
            <li><a href="${pageContext.request.contextPath}/nomenclature/list">Товары</a></li>
            <li><a href="${pageContext.request.contextPath}/orders/prepareList">Заказы</a></li>
            <li><a href="/goalPlan">Принятые заказы и доставки</a></li>
            <li><a href="/userForms">Заказы</a></li>
            <li><a href="#" onclick="this.parentNode.submit()">Выход</a></li>
        </ul>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    </nav>
</div>
<%--</c:if>--%>