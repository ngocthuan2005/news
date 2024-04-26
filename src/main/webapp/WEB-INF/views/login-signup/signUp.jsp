<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<title>Đăng ký</title>
<body>
	<form method="POST" id ="frmSignUp" action="<c:url value = "/login-signup/login-signup/signUp/"/>">
		<div class="form-group">
			<label for="name">Họ và tên</label> <input type="text"
				class="form-control" id="name" placeholder="Họ và tên" name="name"
				required>
		</div>
		<div class="form-group">
			<label for="email">Nhập email</label> <input type="email"
				class="form-control" id="email" placeholder="Nhập email"
				name="email" required>
		</div>
		<div class="form-group">
			<label for="password">Nhập mật khẩu</label> <input id="password"
				type="password" class="form-control pr-4"
				placeholder="Nhập mật khẩu" name="password" required> <i
				toggle="#password"
				class="fa fa-fw fa-eye field-icon toggle-password pl-1"></i>
		</div>
		<div class="form-group">
			<label for="repassword">Nhập lại mật khẩu</label> <input
				id="repassword" type="password" class="form-control pr-4"
				placeholder="Nhập lại mật khẩu" required> <i toggle="#repassword"
				class="fa fa-fw fa-eye field-icon toggle-password pl-1"></i>
		</div>
		<h1 id = "error" class = "h6 text-danger"></h1>
		<input type="submit" class="btn btn-success w-100 mt-1 text-uppercase" id = "btnSignUp"
			value="Đăng ký"> <a
			href="<c:url value = "/login-signup/login/"/>"
			class="btn btn-success w-100 mt-4 text-uppercase">Đăng nhập</a>
	</form>
</body>