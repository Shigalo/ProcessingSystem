<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">
                <a class="command" href="${pageContext.request.contextPath}/product/add">Добавить товар</a>
                <c:if test="${param.massage != null}"><div class="form-group">
                    <label id="error"  style="color: red" >${param.massage}</label>
                </div></c:if>
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td>Наименование</td>
                        <td>Фабрика</td>
                        <td>Количество</td>
                        <td>Коллекция</td>
                        <td>Оптовая цена</td>
                        <td>Розничная цена</td>
                        <td>Артикул</td>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td> ${product.id} </td>
                            <td> ${product.name} </td>
                            <td> ${product.factory} </td>
                            <td> ${product.count} </td>
                            <td> ${product.collection.name} </td>
                            <td> ${product.wholesale} </td>
                            <td> ${product.retail} </td>
                            <td> ${product.article} </td>
                            <%--<td><a href="/user/remove/${user.id}">Удалить</a></td>--%>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file='../../parts/footer.jsp'%>

