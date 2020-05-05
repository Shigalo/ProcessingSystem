<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<body>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">
                <div id="waybill">
                    <label>Waybill id: ${waybill.id}</label><br/>
                    <label>Waybill date: ${waybill.date}</label><br/>
                    <label>Waybill cost: ${waybill.sum}</label><br/>
                    <label>Added by: ${waybill.worker.surname} ${waybill.worker.name}</label><br/>
                </div>
                <br/><br/>
                <div id="deliveries">
                    <h4>Состав:</h4>
                    <ol>
                        <c:forEach items="${deliveries}" var="delivery">
                            <li>Наименование    ${delivery.nomenclature.name};
                                Артикул         ${delivery.nomenclature.article};
                                Коллекция       ${delivery.nomenclature.collection};
                                Фабрика         ${delivery.nomenclature.factory};
                                Цена покупки    ${delivery.nomenclature.wholesale};
                                Цена проджи     ${delivery.nomenclature.retail};
                                Поставлено      ${delivery.count};
                            </li>
                        </c:forEach>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file='../../parts/footer.jsp'%>

