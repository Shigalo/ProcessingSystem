<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-6 offset-3">

            <a class="command" href="${pageContext.request.contextPath}/addUser">Добавить сотрудника</a>
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
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<%@include file='../../parts/footer.jsp'%>

