<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>

<div class="container-fluid">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-6 offset-3">
            <div class="myclass">
                <form action="" method="post">
                    <table>
                        <tr><td>Фамилия: </td><td><input type="text" placeholder="Фамилия" name="surname" value="${user.surname}" required></td></tr>
                        <tr><td>Имя: </td><td><input type="text" placeholder="Имя" name="name" value="${user.name}" required></td></tr>
                        <tr><td>Логин: </td><td>${user.login}</td></tr>
                        <tr><td>Должность: </td><td>${user.getRoleName()}</td></tr>
                    </table>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-primary">Применить</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file='../../parts/footer.jsp'%>
