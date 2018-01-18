<%@include file="layout/user/_header.jsp"%>
<%@include file="layout/user/_head_menu.jsp"%>
<%@include file="layout/user/_left_menu.jsp"%>
<div id="main">
    <h2>${detail_album.getTitle()}</h2>
    <p>
        <img alt="" src="${pageContext.request.contextPath}/${detail_album.getImagePath()}" width="100px" height="75px" />
    </p>
    <div id="album-details">
        <form action="${pageContext.request.contextPath}/cart/add" method="POST">
            <input type="hidden" value="${detail_album.getAlbumId()}" name="albumId" />
            <p>
                <em>Genre:</em>
                ${detail_album.getGenre().getName()}
            </p>
            <p>
                <em>Artist:</em>
                ${detail_album.getArtist().getName()}
            </p>
            <p>
                <em>Price:</em>
                ${detail_album.getPrice()}
            </p>
            <input type="submit" value="Add to cart" />
        </form>
    </div>
</div>
<%@include file="layout/user/_footer.jsp"%>