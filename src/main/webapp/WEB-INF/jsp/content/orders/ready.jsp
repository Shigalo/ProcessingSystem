<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<script>
    function get() {
        let request = "";
        const sel = document.getElementsByClassName("sel");
        for (let i = 0; i < sel.length; i++) {
            if (sel[i].checked == true)
                request += sel[i].parentElement.parentElement.cells[0].innerText + ",";
        }
        if(request.length < 1)
            alert("Заказы не выбраны");
        else
            window.location.href = "route?ids=" + request;
    }
</script>
<body>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">
                <c:if test="${param.massage != null}"><div class="form-group">
                    <label id="error"  style="color: red" >${param.massage}</label>
                </div></c:if>
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td>Дата заказа</td>
                        <td>Статус</td>
                        <td></td>
                    </tr>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td> ${order.id} </td>
                            <td> ${order.startDate} </td>
                            <td> ${order.GetStatus()}</td>
                            <td> <input type="checkbox" id="selected" name="selected" value="selected" class="sel">
                                <label for="selected">Включить в доставку</label><br></td>
                        </tr>
                    </c:forEach>
                </table>

                <button onclick="get()">Перейти к распределению</button>

            </div>
        </div>
    </div>
</div>
</body>
<%@include file='../../parts/footer.jsp'%>