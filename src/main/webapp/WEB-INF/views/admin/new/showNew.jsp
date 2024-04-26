<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Quản lý tin tức</title>
<body>
	<div class="container row">
		<a
			href="<c:url value = "/admin/new-admin/write-new/addNew/"/>"
			class="btn btn-success m-3">Thêm tin tức</a>
	</div>

	<div class=" row mt-3 col-12">
		<table
			class="container rotable table-bordered col-12 text-center ml-2">
			<thead>
				<tr>
					<th>Tiêu đề</th>
					<th>Thuộc tính</th>
					<th>Danh mục</th>
					<th>Ngày duyệt</th>
					<th>Tạng thái</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="newAdmin" items="${ newAdmins }">

					<tr>
						<td class="col-3">${ newAdmin.newTitle }</td>
						<td class="col-2">${ newAdmin.property }</td>
						<td>${ newAdmin.category }</td>
						<td>${ newAdmin.approvalDate }</td>
						<c:if test="${ newAdmin.status == true }">
							<td>Đã được duyệt</td>
						</c:if>
						<c:if test="${ newAdmin.status == false }">
							<td>Chưa được duyệt</td>
						</c:if>
						
						<td>
							<div class="btn-group">
								<a type="button"
									href="<c:url value = "/admin/new-admin/write-new/showNew/${ newAdmin.idNew }"/>"
									class="btn btn-info"> <i class="fa fa-eye"></i>
								</a> <a type="button" class="btn btn-warning"
									href="<c:url value = "/admin/new-admin/write-new/updateNew/${ newAdmin.idNew }"/>">
									<i class="fa fa-edit"></i>
								</a> <a type="button" data-toggle="modal"
									data-target="#newModel${ newAdmin.idNew }" class="btn btn-danger">
									<i class="fa fa-trash"></i>
								</a>
							</div>
						</td>
					</tr>
					
					<!-- delete role Modal-->
						<div class="modal fade justify-content-center"
							id="newModel${ newAdmin.idNew }" tabindex="-1" role="dialog"
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
										Bạn có muốn xóa tin tức với tiêu đề là ${ newAdmin.newTitle } không?<br/> 
									</div>
									<div class="modal-footer">
										<button class="btn btn-secondary" type="button"
											data-dismiss="modal">Hủy</button>
										<a class="btn btn-primary"
											href="<c:url value = "/admin/new-admin/write-new/deleteNew/${ admin.id_role }/${ newAdmin.idNew }"/>">Xóa
										</a>
									</div>
								</div>
							</div>
						</div>
						<!-- end delete role modal -->
				</c:forEach>
			</tbody>
		</table>
	</div>

	<ul class="pagination justify-content-center mt-3">
		<li class="page-item disabled"><a class="page-link">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
	</ul>
</body>