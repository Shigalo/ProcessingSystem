<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form method="post" action="${pageContext.request.contextPath}/login" novalidate id="auth" class="form-horizontal">
                <span class="heading">АВТОРИЗАЦИЯ</span>
                <c:if test="${param.error != null}"><div class="form-group">
                    <label id="error"  style="color: red" name="error">Ошибка авторизации</label>
                </div></c:if>
                <div class="form-group">
                    <label for="login"><input type="text" id="login" name="username" class="form-control" placeholder="Введите логин">
                        <i class="fa fa-user"></i>
                    </label>
                </div>
                <div class="form-group">
                    <label for="password"><input type="password" id="password" class="form-control" name="password" placeholder="Введите пароль">
                        <i class="fa fa-lock"></i>
                    </label>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary">Войти</button>
            </form>
        </div>
    </div>
</div>

</body>
<style>
    .validation-text {
        color: red;
    }
    .nubex1 {
        font-weight: bold;
        size: A4;
    }
    .form-horizontal{
        background: #fff;
        padding-bottom: 40px;
        border-radius: 15px;
        text-align: center;
    }
    .form-horizontal .heading{
        display: block;
        font-size: 35px;
        font-weight: 700;
        padding: 35px 0;
        border-bottom: 1px solid #f0f0f0;
        margin-bottom: 30px;
    }
    .form-horizontal .form-group{
        padding: 0 40px;
        margin: 0 0 25px 0;
        position: relative;
    }
    .form-horizontal .form-control{
        background: #f0f0f0;
        border: none;
        border-radius: 20px;
        box-shadow: none;
        padding: 0 20px 0 45px;
        height: 40px;
        transition: all 0.3s ease 0s;
    }
    .form-horizontal .form-control:focus{
        background: #e0e0e0;
        box-shadow: none;
        outline: 0 none;
    }
    .form-horizontal .form-group i{
        position: absolute;
        top: 12px;
        left: 60px;
        font-size: 17px;
        color: #c8c8c8;
        transition : all 0.5s ease 0s;
    }
    .form-horizontal .form-control:focus + i{
        color: #00b4ef;
    }
    .form-horizontal .main-checkbox label{
        width: 20px;
        height: 20px;
        position: absolute;
        top: 0;
        left: 0;
        cursor: pointer;
    }
    .form-horizontal .main-checkbox label:after{
        content: "";
        width: 10px;
        height: 5px;
        position: absolute;
        top: 5px;
        left: 4px;
        border: 3px solid #fff;
        border-top: none;
        border-right: none;
        background: transparent;
        opacity: 0;
        -webkit-transform: rotate(-45deg);
        transform: rotate(-45deg);
    }
    .form-horizontal .text{
        float: left;
        margin-left: 7px;
        line-height: 20px;
        padding-top: 5px;
        text-transform: capitalize;
    }
    .form-horizontal .btn{
        float: top;
        font-size: 14px;
        color: #fff;
        background: #00b4ef;
        border-radius: 30px;
        padding: 10px 25px;
        border: none;
        text-transform: capitalize;
        transition: all 0.5s ease 0s;
    }
    @media only screen and (max-width: 479px){
        .form-horizontal .form-group{
            padding: 0 25px;
        }
        .form-horizontal .form-group i{
            left: 45px;
        }
        .form-horizontal .btn{
            padding: 10px 20px;
        }
    }
    .btn{
        float: top;
        font-size: 14px;
        color: #fff;
        background: #00b4ef;
        border-radius: 30px;
        padding: 10px 25px;
        border: none;
        text-transform: capitalize;
        transition: all 0.5s ease 0s;
    }
    .for{
        float: top;
        padding-bottom: 40px;
        border-radius: 15px;
        text-align: center;
    }
    .otstup{
        display: block;
        font-size: 35px;
        font-weight: 700;
        padding: 35px 0;
        margin-bottom: 30px;
    }
</style>
<%@include file='../../parts/footer.jsp'%>
