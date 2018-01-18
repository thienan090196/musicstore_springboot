<div id="header">
    <h1><a href="${pageContext.request.contextPath}/">MUSIC STORE</a></h1>
    <ul id="navlist">
        <li class="first"><a href="${pageContext.request.contextPath}/" id="current">Home</a></li>
        <sec:authorize access="hasRole('Administrator')">
            <li><a href="${pageContext.request.contextPath}/album/management/all">Admin Site</a></li>
        </sec:authorize>
        <li><a href="${pageContext.request.contextPath}/cart/getCart">Cart</a></li>
        <sec:authorize access="isAnonymous()">
            <li><a href="${pageContext.request.contextPath}/account/login">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/account/register">Register</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li><a href="${pageContext.request.contextPath}/account/logout">Logout</a> </li>
        </sec:authorize>
    </ul>
</div>
