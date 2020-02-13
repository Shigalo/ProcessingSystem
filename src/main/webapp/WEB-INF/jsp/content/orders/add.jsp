<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>

<div class="container-fluid">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-6 offset-3">
            <form method="post" action="" id="quiz">
                <table id="order">
                    <tr id="prod">
                        <td>
                            <label for="nomenclature" class="nubex1">Номенклатура:</label>
                            <select id="nomenclature" name="nomenclature" onchange="info()">
                                <c:forEach items="${nomenclatures}" var="nomenclature">
                                    <option>${nomenclature.article}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <label for="numeric" class="nubex1">Количество:</label>
                            <input type="number" min="1" step="1" class="form-control" id="numeric"  name="numeric" required>
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
<script>
    var prod = document.getElementById("prod");
    function add() {
        var order = document.getElementById("order");
        var row = order.insertRow(0);
        row.innerHTML = prod.innerHTML;
    }
    function info() {
        alert(this.innerHTML);
        <%--<c:forEach items="${nomenclatures}" var="nomenclature">
        if (${nomenclature.article} === ){
            alert(name);
        }

        </c:forEach>--%>
    }
</script>
<%@include file='../../parts/footer.jsp'%>
