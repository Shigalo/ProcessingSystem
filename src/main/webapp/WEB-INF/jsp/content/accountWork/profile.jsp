<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>

<div class="container-fluid">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-6 offset-3">
            <div class="myclass">
                <h3> ${user.login}</h3>
                <table>
                    <tr><td>Фамилия: </td><td>${user.surname}</td></tr>
                    <tr><td>Имя: </td><td>${user.name}</td></tr>
                    <tr><td>Логин: </td><td>${user.password}</td></tr>
                    <tr><td>Должность: </td><td>${user.getRoleName()}</td></tr>
                </table>
                <c:if test="${param.access != null}">
                    <a href="${pageContext.request.contextPath}/user/edit">Редактировать</a>
                    <a href="/user/edit_password">Изменить пароль</a>
                </c:if>
            </div>
        </div>
    </div>
</div>
<%@include file='../../parts/footer.jsp'%>
