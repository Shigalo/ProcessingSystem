<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<body>
<div class="container-fluid">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-6 offset-3">
            <div class="form-group">
                <label id="error"  style="color: red">${massage}</label>
            </div>
            <form method="post" action="" id="quiz">

                <div class="form-group">
                    <label for="old" class="nubex1">Введите страый пароль:</label>
                    <input type="password" class="form-control" id="old"  name="oldPassword" required>
                </div>
                <div class="form-group">
                    <label for="password" class="nubex1">Введите новый пароль:</label>
                    <input type="password" class="form-control" id="password" name="password" required oninput="dis()">
                </div>
                <div class="form-group">
                    <label for="conf" class="nubex1">Повторите пароль: </label>
                    <input type="password" class="form-control" id="conf" name="passwordConfirm" required oninput="confirm()">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary" id="but" disabled>Применить</button>
            </form>
        </div>
    </div>
</div>
</body>

<script>
    function confirm() {
        var pass = document.getElementById("password");
        var conf = document.getElementById("conf");
        var but = document.getElementById("but");
        but.disabled = (pass.value !== conf.value);
    }
    function dis() {
        document.getElementById("but").disabled = true;
    }

</script>
<%@include file='../../parts/footer.jsp'%>
