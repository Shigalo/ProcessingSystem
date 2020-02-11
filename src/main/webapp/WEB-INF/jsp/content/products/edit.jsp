<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>

<div class="container-fluid">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-6 offset-3">
            <div class="myclass">
                <form method="post" action="" id="quiz">
                    <div class="form-group">
                        <label for="name" class="nubex1">Наименование:</label>
                        <input type="text" class="form-control" id="name"  name="name" required value="${product.name}">
                    </div>
                    <div class="form-group">
                        <label for="factory" class="nubex1">Фабрика:</label>
                        <input type="text" class="form-control" id="factory" name="factory" required value="${product.factory}">
                    </div>
                    <div class="form-group">
                        <label for="count" class="nubex1">Количество: </label>
                        <input type="number" step="1" min="1" class="form-control" id="count" name="count" required value="${product.count}">
                    </div>
                    <div class="form-group">
                        <label class="nubex1">Коллекция: </label>
                        <select id="collection" name="collection" required><c:forEach items="${collections}" var="collection">
                            <option
                                    <c:if test="${collection.name == product.collection.name}">selected</c:if>>
                                    ${collection.name}
                            </option>
                        </c:forEach></select>
                    </div>
                    <div class="form-group">
                        <label for="wholesale" class="nubex1">Оптовая цена: </label>
                        <input type="number" step="0.01" min="0" class="form-control" id="wholesale" name="wholesale" required value="${product.wholesale}">
                    </div>
                    <div class="form-group">
                        <label for="retail" class="nubex1">Розничная цена: </label>
                        <input type="number" step="0.01" min="0" class="form-control" id="retail" name="retail" required value="${product.retail}">
                    </div>
                    <div class="form-group">
                        <label for="article" class="nubex1">Артикул: </label>
                        <input type="text" class="form-control" id="article" name="article" required value="${product.article}">
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file='../../parts/footer.jsp'%>
