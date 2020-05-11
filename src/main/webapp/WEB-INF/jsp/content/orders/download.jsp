<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../../parts/header.jsp'%>
<body>
<div class="container-fluid" >
    <div class="row" style="margin-top: 30px">
        <div class="col-md-offset-3 col-md-6">
            <div class="myclass">

                <c:forEach items="${files}" var="file">
                    <a href="${pageContext.request.contextPath}/orders/file/${file.id}" download>Скачать на ${file.sendDate}</a><br/>
                </c:forEach>

            </div>
        </div>
    </div>
</div>
</body>
