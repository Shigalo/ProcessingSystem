<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<body>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">
                <div id="order">
                    <label>Order id: ${order.id}</label><br/>
                    <label>Order date: ${order.startDate}</label><br/>
                    <label>Order cost: ${order.sum}</label><br/>
                    <label>Ordered by: ${order.manager.surname} ${order.manager.name}</label><br/>
                    <label>Date of receipt: ${order.ready}</label><br/>
                    <label>Date of sending: ${order.customer.send}</label><br/>
                    <label>Status: ${order.getStatusText()}</label><br/>
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

