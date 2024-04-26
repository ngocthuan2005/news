<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Quản lý tài khoản</title>
<body>
	<div class="container row">
		<a href="<c:url value = "/admin/account/insertAccount/"/>"
			class="btn btn-success m-3">Thêm người quản trị mới</a>
	</div>

	<div class=" row mt-3 col-12">
		<table class="container rotable table-bordered col-12 text-center ml-2">
			<thead>
				<tr>
					<th>Họ tên</th>
					<th>Email</th>
					<th>Vai trò</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${ users }">
					<c:if test="${ user.id != admin.id && user.id_role != 0 }">
						<tr>
							<td>${ user.name }</td>
							<td>${ user.email }</td>
							<c:forEach items="${ roles }" var="role">
								<c:if test="${ role.id == user.id_role}">
									<td>${ role.name }</td>
								</c:if>
							</c:forEach>
							<td>
								<div class="btn-group">
									<a type="button"
										href="<c:url value = "/admin/account/showAccount/${user.id }"/>"
										class="btn btn-info"> <i class="fa fa-eye"></i>
									</a> <a type="button" class="btn btn-warning"
										href="<c:url value = "/admin/account/updateAccount/${ user.id }"/>">
										<i class="fa fa-edit"></i>
									</a> <a type="button" data-toggle="modal"
										data-target="#accoutModel${ user.id }" class="btn btn-danger">
										<i class="fa fa-trash"></i>
									</a>
								</div>
							</td>
						</tr>

						<!-- delete role Modal-->
						<div class="modal fade justify-content-center"
							id="accoutModel${ user.id }" tabindex="-1" role="dialog"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title">Bạn có chắc muốn xóa không?</h5>
										<button class="close" type="button" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">×</span>
										</button>
									</div>
									<div class="modal-body">
										Bạn có muốn xóa quản trị tên là ${ user.name } không?<br />Dữ
										liệu sẽ bị xóa vĩnh viễn.<br /> Bạn có chắc không?
									</div>
									<div class="modal-footer">
										<button class="btn btn-secondary" type="button"
											data-dismiss="modal">Hủy</button>
										<a class="btn btn-primary"
											href="<c:url value = "/admin/account/delete/${ user.id }"/>">Xóa
										</a>
									</div>
								</div>
							</div>
						</div>
						<!-- end delete role modal -->
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>