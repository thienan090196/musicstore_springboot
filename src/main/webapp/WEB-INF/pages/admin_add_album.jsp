<%@include file="layout/admin/_header.jsp"%>
<%@include file="layout/admin/_head_menu.jsp"%>
<div style="margin-left: 60px;">
    <h3>Create New Album</h3>
    <form:form style="width: 50%; margin-left: 30px;" method="POST" action="${pageContext.request.contextPath}/album/management/save" modelAttribute="album" enctype="multipart/form-data">
        <form:hidden path="albumId" />
        <form:hidden path="createdAt" />
        <form:hidden path="modifiedAt" />
        <form:hidden path="imagePath" />
        <div class="form-group">
            <label for="title">Title (*)</label>
            <form:input path="title" id="title" type="text" class="form-control" placeholder="Enter album title" required="required" />
            <form:errors path="title" cssClass="text-danger"></form:errors>
        </div>
        <div class="form-group">
            <label for="price">Price (*)</label>
            <form:input path="price" type="number" class="form-control" id="price" min="0.01" step="0.01" placeholder="Enter price" required="required" />
            <form:errors path="price" cssClass="text-danger"></form:errors>
        </div>
        <div class="form-group">
            <label for="genre">Genre (*)</label>
            <form:select path="genre.genreId" id="genre" required="required" class="form-control">
                <form:option value="" disabled="disabled" selected="selected">--Please select genre--</form:option>
                <form:options items="${genres_list}" itemValue="genreId" itemLabel="name"></form:options>
            </form:select>
            <form:errors path="genre.genreId" cssClass="text-danger"></form:errors>
        </div>
        <div class="form-group">
            <label for="artist">Artist (*)</label>
            <form:select path="artist.artistId" id="artist" required="required" class="form-control">
                <form:option value="" disabled="disabled" selected="selected">--Please select artist--</form:option>
                <form:options items="${artists_list}" itemValue="artistId" itemLabel="name"></form:options>
            </form:select>
            <form:errors path="artist.artistId" cssClass="text-danger"></form:errors>
        </div>
        <div class="form-group">
            <label for="file">Image (*)</label>
            <input type="file" class="form-control" id="file" name="file" accept="image/*" />
            <h5>(Max size is 5MB, only jpg, jpeg, png and gif are accepted)</h5>
            <div class="text-danger">${imageError}</div>
        </div>
        <h5>(*) is required</h5>
        <div class="form-group preview-image" style="display: none;">
        </div>
        <c:if test="${!album.getImagePath().trim().isEmpty() && album.getImagePath() != null}">
            <div class="form-group load-exists-image">
                <img src="${pageContext.request.contextPath}/${album.getImagePath()}" width="100px" height="75px" alt="" />
            </div>
        </c:if>
        <button type="submit" class="btn btn-success">Save</button>
        <a class="btn btn-default" href="${pageContext.request.contextPath}/album/management/all">Cancel</a>
    </form:form>
</div>
<%@include file="layout/admin/_footer.jsp"%>