<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Thêm vai trò</title>
<div class="container row mt-3 mw-100">
	<h1 class="h3 text-dark col-12 bg-info">Thêm vai trò</h1>
	<div class="card-body">
		<form method="post" action="<c:url value = "/admin/1/quan-ly-vai-tro/insertRole"/>">
			<div class="form-group">
				<label for="roleNew">Vai trò</label> <input type="text" id="roleBew"
					class="form-control" name="role" placeholder="Nhập vai trò"
					required>
			</div>
		<input class="btn btn-secondary" value="Thêm vai trò" type="submit">
		</form>
	</div>
</div>
