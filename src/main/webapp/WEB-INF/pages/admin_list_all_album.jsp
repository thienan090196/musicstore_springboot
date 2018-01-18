<%@include file="layout/admin/_header.jsp"%>
<%@include file="layout/admin/_head_menu.jsp"%>
<div style="margin: 0px 10px 0px 10px;">
    <a href="${pageContext.request.contextPath}/album/management/add" class="btn btn-success glyphicon glyphicon-plus" style="margin-bottom: 10px;margin-top: 20px;" title="Add new album"></a>
    <table class="table table-response table-hover table-bordered">
        <thead>
            <tr>
                <th>Image</th>
                <th>Title</th>
                <th>Genre</th>
                <th>Price</th>
                <th>Created At</th>
                <th>Modified At</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listModel}" var="model">
                <tr>
                    <td><img src="${pageContext.request.contextPath}/${model.getImagePath()}" width="100px" height="75px" alt="" /></td>
                    <td>${model.getTitle()}</td>
                    <td>${model.getGenre().getName()}</td>
                    <td>${model.getPrice()}</td>
                    <td>${model.getCreatedAt()}</td>
                    <td>${model.getModifiedAt()}</td>
                    <td><a href="${pageContext.request.contextPath}/album/management/edit/${model.getAlbumId()}" class="btn btn-info glyphicon glyphicon-edit" title="Edit"></a>
                        <a href="${pageContext.request.contextPath}/album/management/delete/${model.getAlbumId()}" onclick="return confirm('Are you sure to delete this album?')" class="btn btn-danger glyphicon glyphicon-trash" title="Delete"></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="pagination">
        <c:url value="/album/management/all" var="first">
            <c:param name="page" value="1"/>
        </c:url>
        <c:url value="/album/management/all" var="prev">
            <c:param name="page" value="${page-1}"/>
        </c:url>
        <c:if test="${page > 1}">
            <a href='<c:out value="${first}" />' class="previous">First</a>
            <span> | </span>
            <a href="<c:out value="${prev}" />" class="previous">Previous</a>
        </c:if>
        <span> Page ${page} of ${maxPages} </span>
        <c:url value="/album/management/all" var="next">
            <c:param name="page" value="${page + 1}"/>
        </c:url>
        <c:url value="/album/management/all" var="last">
            <c:param name="page" value="${maxPages}" />
        </c:url>
        <c:if test="${page + 1 <= maxPages}">
            <a href='<c:out value="${next}" />' class="next">Next</a>
            <span> | </span>
            <a href='<c:out value="${last}" />' class="next">Last</a>
        </c:if>
    </div>
</div>
<%@include file="layout/admin/_footer.jsp"%>