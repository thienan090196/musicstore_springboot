<%@include file="layout/user/_header.jsp"%>
<%@include file="layout/user/_head_menu.jsp"%>
<%@include file="layout/user/_left_menu.jsp"%>
<div id="main">
    <%--<div>--%>
        <%--<fieldset>--%>
            <%--<legend>Login</legend>--%>
            <%--<form action="/account/login" method="POST">--%>
                <%--<div class="editor-label">--%>
                    <%--Email--%>
                <%--</div>--%>
                <%--<div class="editor-field">--%>
                    <%--<input type="text" name="email" />--%>
                <%--</div>--%>

                <%--<div class="editor-label">--%>
                    <%--Password--%>
                <%--</div>--%>
                <%--<div class="editor-field">--%>
                    <%--<input type="password" name="password" />--%>
                <%--</div>--%>
                <%--<p>--%>
                    <%--<input type="submit" value="Login" name="submit" />--%>
                <%--</p>--%>
            <%--</form>--%>
        <%--</fieldset>--%>
    <%--</div>--%>
        <div>
            <fieldset>
                <legend>Register</legend>
                <form:form action="/account/login" method="POST" modelAttribute="account" enctype="multipart/form-data">
                    <div class="editor-label">
                        First Name
                    </div>
                    <div class="editor-field">
                        <form:input path="firstName" id="firstName" type="text" placeholder="Enter first name" required="required" />
                    </div>
                    <div class="editor-label">
                        <form:errors path="firstName" cssClass="text-danger"></form:errors>
                    </div>

                    <div class="editor-label">
                        Last Name
                    </div>
                    <div class="editor-field">
                        <form:input path="lastName" id="lastName" type="text" placeholder="Enter last name" required="required" />
                    </div>
                    <div class="editor-label">
                        <form:errors path="lastName" cssClass="text-danger"></form:errors>
                    </div>

                    <div class="editor-label">
                        Email
                    </div>
                    <div class="editor-field">
                        <form:input path="email" id="email" type="text" placeholder="Enter email" required="required" />
                    </div>
                    <div class="editor-label">
                        <form:errors path="email" cssClass="text-danger"></form:errors>
                    </div>

                    <div class="editor-label">
                        Password
                    </div>
                    <div class="editor-field">
                        <form:input path="password" id="password" type="password" placeholder="Enter password" required="required" />
                    </div>
                    <div class="editor-label">
                        <form:errors path="password" cssClass="text-danger"></form:errors>
                    </div>

                    <div class="editor-label">
                        Confirm Password
                    </div>
                    <div class="editor-field">
                        <input path="password" id="confirmPassword" type="password" placeholder="Re-enter password" required="required" />
                    </div>
                    <div class="editor-label">
                        <div class="text-danger">${passwordNotMatch}</div>
                    </div>
                    <p>
                        <input type="submit" value="Register" />
                    </p>
                </form:form>
            </fieldset>
        </div>
</div>
<%@include file="layout/user/_footer.jsp"%>
