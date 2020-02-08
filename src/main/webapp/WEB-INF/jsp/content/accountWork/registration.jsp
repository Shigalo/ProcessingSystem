<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>

<div class="container-fluid">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-6 offset-3">
            <form method="post" action="" id="quiz">

                <div class="form-group">
                    <label for="username" class="nubex1">Логин:</label>
                    <input type="text" class="form-control" id="username"  name="username" required>
                </div>
                <div class="form-group">
                    <label for="password" class="nubex1">Пароль:</label>
                    <input type="text" class="form-control" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="name" class="nubex1">Имя: </label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="surname" class="nubex1">Фамилия: </label>
                    <input type="text" class="form-control" id="surname" name="surname" required>
                </div>
                <div class="form-group">
                    <label class="nubex1">Должность: </label>
                    <select id="accesslevel" name="role">
                        <option selected value="user">Пользователь</option>
                        <option value="logist">Логист</option>
                        <option value="manager">Менеджер</option>
                        <option value="admin">Администратор</option>
                    </select>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary">Добавить сотрудника</button>
            </form>
        </div>
    </div>
</div>
<%@include file='../../parts/footer.jsp'%>
