<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Cập nhật tài khoản</title>

<body>
	<div class="container row mt-3 mw-100">
		<h1 class="h3 text-dark col-12 bg-info">Sửa tài khoản</h1>
		<div class="card-body">
			<form method="post" id="formRole"
				action="<c:url value = "/admin/account/updateAccount/"/>"  
				accept-charset='ISO-8859-1,utf-8'>
				<div class="form-group">
					<div class="row">
						<div class="col">
							<input type="hidden" name="id" value="${ userUpdate.id }">
							<label for="name">Họ và tên<i
								class="fa-duotone fa-asterisk text-danger"></i></label> <input
								type="text" id="name" class="form-control" name="name"
								placeholder="Nhập họ và tên" value="${ userUpdate.name }"
								required>
						</div>
						<div class="col">
							<label for="role">Vai trò<i
								class="fa-duotone fa-asterisk text-danger"></i></label> <select
								name="role_select" id="role" class="form-control">
								<option value="0">-- Chọn vai trò --</option>
								<c:forEach items="${ roleAll }" var="role" varStatus="loop">
									<c:if test="${ role.id == userUpdate.id_role }">
										<option selected value="${ role.id }">${ role.name }</option>
									</c:if>
									<c:if test="${ role.id != userUpdate.id_role }">
										<option value="${ role.id }">${ role.name }</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col">
							<label for="email">Email<i
								class="fa-duotone fa-asterisk text-danger"></i></label> <input
								type="email" id="email" class="form-control" name="email"
								placeholder="Nhập email" required value="${ userUpdate.email }">
						</div>

						<div class="col">
							<label for="password">Mật khẩu<i
								class="fa-duotone fa-asterisk text-danger"></i></label> <input
								type="password" id="password" class="form-control"
								name="password" placeholder="Nhập mật khẩu" required value = "${userUpdate.password }"> <i
								toggle="#password"
								class="fa fa-fw fa-eye field-icon toggle-password pl-1"></i>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">

						<div class="col">
							<label for="phone">Số điện thoại</label> <input type="tel"
								id="phone" class="form-control" name="phone" value = "${userUpdate.mobile }"
								placeholder="Nhập số điện thoại"
								pattern="[0]{1}[0-9]{3}[0-9]{3}[0-9]{3}">
						</div>
						<div class="col">
							<label for="email_accuracy">Email xác thực</label> <input value = "${ userUpdate.email_accuracy }"
								type="email" id="email_accuracy" class="form-control"
								name="email_accuracy" placeholder="Nhập email xác thực">
						</div>
					</div>
				</div>

				<span class="text-danger h3 d-block" id="error"></span> <input
					class="btn btn-secondary" value="Sửa tài khoản" type="submit">
			</form>
		</div>
	</div>
</body>