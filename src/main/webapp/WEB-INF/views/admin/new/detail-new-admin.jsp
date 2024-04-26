<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<title>Chi tiết bài viết</title>
<div class="container">
	<h4>Chi tiết bài viết</h4>
	<div class="card">
		<div class="card-body">
			<div class="col">
				<img
					src="<c:url value = "/public/user/uploads/tintuc/${ newDetail.image }"/>"
					width="100%" alt="">
				<h3 class="mt-1">${ newDetail.newTitle }</h3>
				<span class = "d-block"> Tác giả: ${ newDetail.author } </span> 
				<span>
					Ngày gửi bài: ${ newDetail.postingDate }
				</span>
				
				<div class = "row justify-content-center text-center mt-1">
					${ newDetail.content }
				</div>
			</div>
		</div>
	</div>
	<div class = "row justify-content-center mt-1 mb-3">
		<a class = "btn btn-success mr-2" href = "<c:url value = "/admin/new-admin/write-new/updateNew/${idNew}"/>">Sửa</a>
		<a class = "btn btn-secondary ml-2" href = "<c:url value = "/admin/new-admin/write-new/${ admin.id_role }/"/>">Quay lại</a>
	</div>
</div>
