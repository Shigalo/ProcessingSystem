<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">
                <a class="command" href="${pageContext.request.contextPath}/orders/add">Добавить заказ</a>
                <c:if test="${param.massage != null}"><div class="form-group">
                    <label id="error"  style="color: red" >${param.massage}</label>
                </div></c:if>
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td>Данные (изменить на дату)</td>
                        <td>Менеджер</td>
                    </tr>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td> ${order.id} </td>
                            <td> ${order.data} </td>
                            <td> ${order.manager.surname} ${order.manager.name}</td>
                            <td><a href="/orders/info/${order.id}">Подробнее</a></td>
                                <%--<td><a href="/orders/edit/${order.id}">Изменить</a></td>--%>
                                <%--<td><a href="/orders/remove/${order.id}">Удалить</a></td>--%>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file='../../parts/footer.jsp'%>

