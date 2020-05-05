<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<body>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">
                <a class="command" href="${pageContext.request.contextPath}/nomenclature/add">Добавить товар</a>
                <c:if test="${param.massage != null}"><div class="form-group">
                    <label id="error"  style="color: red" >${param.massage}</label>
                </div></c:if>
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td>Наименование</td>
                        <td>Фабрика</td>
                        <td>Коллекция</td>
                        <td>Оптовая цена</td>
                        <td>Розничная цена</td>
                        <td>Артикул</td>
                    </tr>
                    <c:forEach items="${nomenclatures}" var="nomenclature">
                        <tr>
                            <td> ${nomenclature.id} </td>
                            <td> ${nomenclature.name} </td>
                            <td> ${nomenclature.factory} </td>
                            <td> ${nomenclature.collection} </td>
                            <td> ${nomenclature.wholesale} </td>
                            <td> ${nomenclature.retail} </td>
                            <td> ${nomenclature.article} </td>
                            <td><a href="/nomenclature/edit/${nomenclature.id}">Изменить</a></td>
                            <td><a href="/nomenclature/remove/${nomenclature.id}">Удалить</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file='../../parts/footer.jsp'%>

