<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<body>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">
                <form method="post" action="" id="quiz" enctype="multipart/form-data">
                    <label for="file">Файл накладной</label>
                    <input type="file" id="file" name="file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-primary">Next</button>
                </form>
            </div>
            <div id="listDiv">
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td>Дата поставки</td>
                        <td>Сумма поставки</td>
                        <td>Сотрудник</td>
                    </tr>
                    <c:forEach items="${waybills}" var="waybill">
                        <tr>
                            <td> ${waybill.id} </td>
                            <td> ${waybill.date} </td>
                            <td> ${waybill.sum} </td>
                            <td> ${waybill.worker.surname} ${waybill.worker.name}</td>
                            <td><a href="/waybills/info/${waybill.id}">Подробнее</a></td>
                                <%--<td><a href="/orders/edit/${order.id}">Изменить</a></td>--%>
                                <%--<td><a href="/orders/remove/${order.id}">Удалить</a></td>--%>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file='../../parts/footer.jsp'%>

