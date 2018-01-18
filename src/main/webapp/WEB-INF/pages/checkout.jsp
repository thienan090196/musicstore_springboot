<%@include file="layout/user/_header.jsp"%>
<%@include file="layout/user/_head_menu.jsp"%>
<%@include file="layout/user/_left_menu.jsp"%>
<div id="main">
    <div>
        <fieldset>
            <legend>Shipping</legend>
            <form:form modelAttribute="order" action="${pageContext.request.contextPath}/checkout/addShippingInfo" method="POST">
                <form:hidden path="orderId"></form:hidden>
                <form:hidden path="accountId"></form:hidden>
                <form:hidden path="account.accountId"></form:hidden>
                <form:hidden path="totalOrder"></form:hidden>
                <form:hidden path="createdAt"></form:hidden>
                <form:hidden path="modifiedAt"></form:hidden>
                <div class="editor-label">
                    First Name
                </div>
                <div class="editor-field">
                    <form:input path="firstName" placeholder="First Name" type="text" required="required"></form:input>
                </div>

                <div class="editor-label">
                    Last Name
                </div>
                <div class="editor-field">
                    <form:input path="lastName" placeholder="Last Name" type="text" required="required"></form:input>
                </div>

                <div class="editor-label">
                    Address
                </div>
                <div class="editor-field">
                    <form:input path="address" placeholder="Address" type="text" required="required"></form:input>
                </div>

                <div class="editor-label">
                    City
                </div>
                <div class="editor-field">
                    <form:input path="city" placeholder="City" type="text" required="required"></form:input>
                </div>

                <div class="editor-label">
                    Country
                </div>
                <div class="editor-field">
                    <form:input path="country" placeholder="Country" type="text" required="required"></form:input>
                </div>

                <div class="editor-label">
                    Phone
                </div>
                <div class="editor-field">
                    <form:input path="phone" placeholder="Phone" type="text" required="required"></form:input>
                </div>
                <p>
                    <input type="submit" value="Submit" name="submit" />
                </p>
            </form:form>
        </fieldset>
    </div>
</div>
<%@include file="layout/user/_footer.jsp"%>