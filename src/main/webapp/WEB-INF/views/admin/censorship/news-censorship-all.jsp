<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<title>Kiểm duyệt tin tức</title>

<body>
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
									href="<c:url value = "/admin/new-admin/censorship-new/detail-censorship/${ admin.id_role }/${newAdmin.idNew}"/>"
									class="btn btn-info"> <i class="fa fa-eye"></i>
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<ul class="pagination justify-content-center mt-3">
		<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
			varStatus="loop">

			<c:if test="${ (loop.index) == paginateInfo.currentPage }">
				<li class="page-item disabled"><a href="<c:url value="/admin/new-admin/censorship-new/news/pages/${ loop.index }"/>"
					class="page-link">${loop.index}</a></li>
			</c:if>

			<c:if test="${ (loop.index) != paginateInfo.currentPage }">
				<li class="page-item"><a class="page-link" href="<c:url value="/admin/new-admin/censorship-new/news/pages/${ loop.index }"/>">${ loop.index }</a></li>
			</c:if>
		</c:forEach>
	</ul>
</body>