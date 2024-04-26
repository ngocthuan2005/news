<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Sửa vai trò</title>
<div class="container row mt-3 mw-100">
	<h1 class="h3 text-dark col-12 bg-info">Sửa vai trò</h1>
	<div class="card-body">
		<form method="post" action="<c:url value = "/admin/1/quan-ly-vai-tro/updatRole"/>">
			<div class="form-group">
				<label for="roleUpdate">Vai trò</label> 
				<input type = "hidden" name = "id" value = "${ roleUpdate.id }">
				<input type="text" id="roleUpdate"
					class="form-control" name="roleUpdate" placeholder="Nhập vai trò" value="${ roleUpdate.name }"
					required>
			</div>
		<input class="btn btn-secondary" value="Sửa vai trò" type="submit">
		</form>
	</div>
</div>
    