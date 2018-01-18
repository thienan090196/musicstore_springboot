<ul id="categories">
    <c:forEach items="${genreList}" var="item">
        <li><a href="${pageContext.request.contextPath}/genre/${item.getGenreId()}">${item.getName()}</a> </li>
    </c:forEach>
</ul>