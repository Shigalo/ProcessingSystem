<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<body>
<div class="container-fluid">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-6 offset-3">
            <form method="post" action="" id="quiz">
                <div id="customer">
                    <label for="name" class="nubex1">Заказчик:</label>
                    <input type="text"class="form-control" id="name" name="name" required>
                    <label for="address" class="nubex1">Адрес:</label>
                    <input type="text"class="form-control" id="address" name="address" required>
                </div>

                <table id="order">
                    <tr id="prod">
                        <td>
                            <label for="nomenclature" class="nubex1">Номенклатура:</label>
                            <select id="nomenclature" name="nomenclature" onchange="info()">
                                <c:forEach items="${nomenclatures}" var="nomenclature">
                                    <option value="${nomenclature.id}">${nomenclature.name} ${nomenclature.collection}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <label for="count" class="nubex1">Количество:</label>
                            <input type="number" min="1" step="1" class="form-control" id="count"  name="count" required>
                        </td>
                    </tr>
                </table>
                <button type="button" onclick="add()" class="btn btn-primary">Добавить товар</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary">Отправить заказ</button>
            </form>
        </div>
    </div>
</div>
</body>

<script>
    var prod = document.getElementById("prod");
    function add() {
        var order = document.getElementById("order");
        var row = order.insertRow(-1);
        row.innerHTML = prod.innerHTML;
    }
</script>
<%@include file='../../parts/footer.jsp'%>
