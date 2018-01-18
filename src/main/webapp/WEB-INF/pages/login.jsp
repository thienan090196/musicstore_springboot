<%@include file="layout/user/_header.jsp"%>
<%@include file="layout/user/_head_menu.jsp"%>
<%@include file="layout/user/_left_menu.jsp"%>
<div id="main">
    <div>
        <fieldset>
            <legend>Login</legend>
            <form action="${pageContext.request.contextPath}/account/login" method="POST">
                <div class="editor-label">
                    Email
                </div>
                <div class="editor-field">
                    <input type="text" name="email" />
                </div>

                <div class="editor-label">
                    Password
                </div>
                <div class="editor-field">
                    <input type="password" name="password" />
                </div>
                <p>
                    <input type="submit" value="Login" name="submit" />
                </p>
            </form>
        </fieldset>
    </div>
</div>
<%@include file="layout/user/_footer.jsp"%>