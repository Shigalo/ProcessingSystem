<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<body>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">
                <div id="order">
                    <label>ID: ${order.id}</label><br/>
                    <label>Дата получения заказа: ${order.startDate}</label><br/>
                    <label>Стоимость: ${order.sum}</label><br/>
                    <label>Оформлено: ${order.manager.surname} ${order.manager.name}</label><br/>
                    <label>Дата готовности: ${order.GetReady()}</label><br/>
                    <label>Date of sending: ${order.GetSend()}</label><br/>
                    <label>Status: ${order.getStatusText()}</label><br/>
                    <br/><br/>
                    Покупатель:
                    <label>Имя: ${order.customer.name}</label><br/>
                    <label>Адрес: ${order.customer.address}</label><br/>
                    <label>Тип оплаты: ${order.customer.GetPayment()}</label><br/>
                </div>
                <br/><br/>
                <div id="products">
                    <h4>Состав:</h4>
                    <ol>
                        <c:forEach items="${products}" var="product">
                            <li>Наименование    ${product.nomenclature.name};
                                Артикул         ${product.nomenclature.article};
                                Коллекция       ${product.nomenclature.collection};
                                Фабрика         ${product.nomenclature.factory};
                                Цена покупки    ${product.nomenclature.wholesale};
                                Цена проджи     ${product.nomenclature.retail};
                                Заказано        ${product.ordered};
                                Изготовлено     ${product.done}
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

