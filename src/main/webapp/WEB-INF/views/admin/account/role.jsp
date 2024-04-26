<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Quản lý vai trò</title>
<body>
	<div class="container row">
		<a href="<c:url value = "/admin/1/quan-ly-vai-tro/insertRole"/>"
			class="btn btn-success m-3">Thêm vai trò mới</a>
	</div>

	<div class=" row mt-3 col-12">
		<table class="container rotable table-bordered col-12 text-center">
			<thead>
				<tr>
					<th>STT</th>
					<th>Tên vai trò</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="roleAll" items="${ roles }" varStatus="loop">

					<c:if test="${ role.id != roleAll.id }">

						<tr>
							<td>${ loop.index + 1 }</td>
							<td>${ roleAll.name }</td>

							<td>
								<div class="btn-group">
									<a
										href="<c:url value = "/admin/1/quan-ly-vai-tro/updateRole/${ roleAll.id }"/>"
										type="button" class="btn btn-warning"> <i
										class="fa fa-edit"></i>
									</a> <a type="button" class="btn btn-danger" data-toggle="modal"
										data-target="#roleModel${ roleAll.id }"> <i class="fa fa-trash"></i>
									</a>
								</div>
							</td>
						</tr>
						
							<!-- delete role Modal-->
						<div class="modal fade justify-content-center" id="roleModel${ roleAll.id }"
							tabindex="-1" role="dialog"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title">Bạn có
											chắc muốn xóa không?</h5>
										<button class="close" type="button" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">×</span>
										</button>
									</div>
									<div class="modal-body">
										Bạn có muốn xóa vai trò ${ roleAll.name } không?<br />Dữ
										liệu sẽ bị xóa vĩnh viễn.<br /> Bạn có chắc không?
									</div>
									<div class="modal-footer">
										<button class="btn btn-secondary" type="button"
											data-dismiss="modal">Hủy</button>
										<a class="btn btn-primary"
											href="<c:url value = "/admin/1/quan-ly-vai-tro/deleteRole/${ roleAll.id }"/>">Xóa
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