<%@include file="layout/user/_header.jsp"%>
<%@include file="layout/user/_head_menu.jsp"%>
<%@include file="layout/user/_left_menu.jsp"%>
<div id="main">
    <c:choose>
        <c:when test="${empty_cart != null}">
            <h3>${empty_cart}</h3>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/checkout/viewShippingInfo" class="btn btn-info">Checkout</a>
            <table class="table table-bordered table-responsive" style="margin-top: 10px">
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${list_cart}" var="cart">
                    <tr>
                        <td><img src="${pageContext.request.contextPath}/${cart.getImagePath()}" width="100px" height="75px" alt="" /></td>
                        <td>${cart.getTitle()}</td>
                        <td>${cart.getPrice()}</td>
                        <td>${cart.getQuantity()}</td>
                        <td>${cart.getPrice() * cart.getQuantity()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cart/remove/${cart.getAlbumId()}" onclick="return confirm('Are you sure to delete this album?')" class="btn btn-danger glyphicon glyphicon-trash"></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
<%@include file="layout/user/_footer.jsp"%>
