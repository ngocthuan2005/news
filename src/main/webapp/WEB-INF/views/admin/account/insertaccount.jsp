<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Thêm quản trị viên</title>
<body>
	<div class="container row mt-3 mw-100">
		<h1 class="h3 text-dark col-12 bg-info">Thêm quản trị viên</h1>

		<div class="card-body">

			<form method="post"
				action="<c:url value = "/admin/account/insert/"/>"
				accept-charset='UTF-8' id = "form">
				<div class="form-group">
					<div class="row">
						<div class="col">
							<label for="name">Họ và tên<i class="fa-duotone fa-asterisk text-danger"></i></label>  <input type="text" id="name"
								class="form-control" name="name" placeholder="Nhập họ và tên"
								required>
						</div>

						<div class="col">
							<label for="role">Vai trò<i class="fa-duotone fa-asterisk text-danger"></i></label>
							 <select name="role_select"
								id="role" class="form-control">
								<option value="0" selected>-- Chọn vai trò --</option>
								<c:forEach items ="${ roles }" var="role" varStatus="loop">
									<option value="${ loop.index + 1 }">${ role.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col">
							<label for="email">Email<i class="fa-duotone fa-asterisk text-danger"></i></label> <input type="email" id="email"
								class="form-control" name="email" placeholder="Nhập email"
								required>
						</div>

								<div class="col">
							<label for="password">Mật khẩu<i class="fa-duotone fa-asterisk text-danger"></i></label> <input type="password"
								id="password" class="form-control" name="password"
								placeholder="Nhập mật khẩu" required> <i
								toggle="#password"
								class="fa fa-fw fa-eye field-icon toggle-password pl-1"></i>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						
						<div class="col">
							<label for="phone">Số điện thoại</label> <input type="tel"
								id="phone" class="form-control" name="phone"
								placeholder="Nhập số điện thoại"
								 pattern="[0]{1}[0-9]{3}[0-9]{3}[0-9]{3}">
						</div>
						<div class = "col">
							<label for="email_accuracy">Email xác thực</label>
							<input type="email" id="email_accuracy"
								class="form-control" name="email_accuracy" placeholder="Nhập email xác thực">
						</div>
					</div>
				</div>
				<span class="text-danger h3 d-block" id = "error"></span> <input
					class="btn btn-secondary" value="Thêm người dùng" type="submit">
				<a href="<c:url value = "/admin/1"/>" class="btn btn-light ms-2">Quay
					lại</a>
			</form>
		</div>
	</div>
	
	
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

	<!-- End body content -->
</body>