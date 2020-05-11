<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<body>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">
                <form method="post" action="" id="quiz">
                    <label for="date_field">Дата поставки</label><br/>
                    <input type="date" name="date" id="date_field" required>
                    <table border="1">
                        <tr>
                            <td></td>
                            <td>ID</td>
                            <td>Дата заказа</td>
                            <td>Статус</td>
                        </tr>
                        <c:forEach items="${orders}" var="order">
                            <tr>
                                <td>
                                    <label class="up" onclick="up(this)">&#9650;</label><br/>
                                    <input style="text-align: center; width: 50px" value="${order.position}" readonly name="pos"><br/>
                                    <label class="down" onclick="down(this)">&#9660;</label>
                                </td>
                                <td> <input style="text-align: center; width: 50px" value="${order.id}" readonly name="pos"> </td>
                                <td> ${order.startDate} </td>
                                <td> ${order.GetStatus()}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file='../../parts/footer.jsp'%>
<script>
    let today = new Date();
    let dd = today.getDate();
    let mm = today.getMonth() + 1;
    let yyyy = today.getFullYear();
    if(dd<10){ dd='0'+dd }
    if(mm<10){ mm='0'+mm }
    today = yyyy+'-'+mm+'-'+dd;
    document.getElementById("date_field").setAttribute("min", today);

    function up(obj) {
        let td = obj.parentElement;
        if(td.childNodes.item(4).value === "1")
            return;
        let tr = td.parentElement;
        let prev = tr.previousElementSibling;
        let buf = tr.innerHTML;
        tr.innerHTML = prev.innerHTML;
        prev.innerHTML = buf;

        buf = tr.childNodes.item(1).innerHTML;
        tr.childNodes.item(1).innerHTML = prev.childNodes.item(1).innerHTML;
        prev.childNodes.item(1).innerHTML = buf;
    }
    function down(obj) {
        let td = obj.parentElement;
        let tr = td.parentElement;
        let next = tr.nextElementSibling;
        let buf = tr.innerHTML;
        tr.innerHTML = next.innerHTML;
        next.innerHTML = buf;

        buf = tr.childNodes.item(1).innerHTML;
        tr.childNodes.item(1).innerHTML = next.childNodes.item(1).innerHTML;
        next.childNodes.item(1).innerHTML = buf;
    }
</script>