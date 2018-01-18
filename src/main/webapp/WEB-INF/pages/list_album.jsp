<%@include file="layout/user/_header.jsp"%>
<%@include file="layout/user/_head_menu.jsp"%>
<%@include file="layout/user/_left_menu.jsp"%>
<div id="main">
    <h3><em>Big</em> sale</h3>
    <ul id="album-list">
        <c:forEach items="${listAlbums}" var="album">
            <li>
                <a href="${pageContext.request.contextPath}/album/detail/${album.getAlbumId()}">
                    <img src="${pageContext.request.contextPath}/${album.getImagePath()}" width="100px" height="75px" alt="">
                    <span>${album.getTitle()}</span>
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
<%@include file="layout/user/_footer.jsp"%>