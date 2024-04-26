<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<title>Đăng nhập</title>
<body>
	<form class="mt-2" method="POST" action = "<c:url value = "/login-signup/login/"/>">
		<div class="form-group">
			<label for="email">Nhập email</label> <input type="email"
				class="form-control" id="email" name="email" required
				placeholder="Nhập email">
		</div>
		<div class="form-group">
			<label for="password-field">Nhập mật khẩu</label> <input
				id="password-field" type="password" name="password"
				class="form-control pr-4" placeholder="Nhập mật khẩu" required>
			<i toggle="#password-field"
				class="fa fa-fw fa-eye field-icon toggle-password pl-1"></i>
		</div>
		<!-- <a href="#" class="float-right mb-2">Quên mật khẩu?</a>-->
		<label class="text-danger">${ login }</label> <input id type=submit
			" class="btn btn-success w-100 mt-2 text-uppercase" value="Đăng nhập">
		<a href="<c:url value = "/login-signup/signup/"/>" type="submit"
			class="btn btn-success w-100 mt-4 text-uppercase">Đăng ký</a>
	</form>
</body>