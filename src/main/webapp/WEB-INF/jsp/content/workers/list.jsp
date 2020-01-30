<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">
                <a class="command" href="${pageContext.request.contextPath}/user/add">Добавить сотрудника</a>
                <c:if test="${param.massage != null}"><div class="form-group">
                    <label id="error"  style="color: red" >${param.massage}</label>
                </div></c:if>
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td>Логин</td>
                        <td>Пароль</td>
                        <td>Должность</td>
                        <td>Имя</td>
                        <td>Фамилия </td>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td> ${user.id} </td>
                            <td> ${user.login} </td>
                            <td> ${user.password} </td>
                            <td> ${user.getRoleName()} </td>
                            <td> ${user.name} </td>
                            <td> ${user.surname} </td>
                            <td><a href="/user/remove/${user.id}">Удалить</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file='../../parts/footer.jsp'%>

