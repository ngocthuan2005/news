<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<c:set var="nameShow" value="${ userShow.name }"></c:set>
<title>Tài khoản ${ nameShow }</title>
<body>
	<h1>${ text }</h1>
	<div class="container row mt-3 mw-100">
		<table class="container rotable table-bordered col-12 text-center">
			<thead>
				<tr>
					<td>Thuộc tính</td>
					<td>Giá trị</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="col-6 p-4">Email</td>
					<td class="col-6 p-4">${ userShow.email }</td>
				</tr>
				<tr>
					<td class="col-6 p-4">Họ tên</td>
					<td class="col-6 p-4">${ nameShow }</td>
				</tr>
				<tr>
					<td class="col-6 p-4">Mật khẩu</td>
					<td class="col-6 p-4">${ userShow.password }</td>
				</tr>
				<tr>
					<td class="col-6 p-4">Vai trò</td>
					<td class="col-6 p-4">${ nameRole }</td>
				</tr>
				<tr>
					<td class="col-6 p-4">Số điện thoại</td>
					<td class="col-6 p-4">${ userShow.mobile }</td>
				</tr>
				<tr>
					<td class="col-6 p-4">Email xác thực</td>
					<td class="col-6 p-4">${ userShow.email_accuracy }</td>
				</tr>
			</tbody>
		</table>
		<div class = "row justify-content-center w-100 mt-3 mb-2">
			<a type="button" class="btn btn-warning mr-4" href = "<c:url value = "/admin/account/updateAccount/${ userShow.id }"/>"> <i class="fa fa-edit"></i>
			</a> <a type="button" class = "btn btn-secondary ml-4" href = "<c:url value = "/admin/1/"/>">Quay lại</a>
		</div>
	</div>
</body>