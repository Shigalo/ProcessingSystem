<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>

<div class="container-fluid">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-6 offset-3">
            <form method="post" action="" id="quiz">

                <div class="form-group">
                    <label for="old" class="nubex1">Логин:</label>
                    <input type="text" class="form-control" id="old"  name="oldPassword" >
                </div>
                <div class="form-group">
                    <label for="password" class="nubex1">Пароль:</label>
                    <input type="text" class="form-control" id="password" name="password" >
                </div>
                <div class="form-group">
                    <label for="conf" class="nubex1">Имя: </label>
                    <input type="text" class="form-control" id="conf" name="passwordConfirm" >
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary">Применить</button>
            </form>
        </div>
    </div>
</div>
<%@include file='../../parts/footer.jsp'%>
