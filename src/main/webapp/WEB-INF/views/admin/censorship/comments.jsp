<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
    
<title>Kiểm duyệt bình luận</title>
<body>
	<div class=" row mt-3 col-12">
		<table
			class="container rotable table-bordered col-12 text-center ml-2">
			<thead>
				<tr>
					<th>STT</th>
					<th>Tiêu đề</th>
					<th>Nội dung bình luận</th>
					<th>Ngày bình luận</th>
					<th>Người bình luận</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="comment" items="${ comments }" begin="1" varStatus="loop" end="${ comments.size() }">
					<tr>
						<td style="width: 5%;">${ loop.index }</td>
						<td style="width: 30%;">${ comment.newTitle }</td>
						<td>${ comment.contentComment }</td>
						<td>${ comment.commentDate }</td>
						<td>${ comment.userComment }</td>
						<td>
							<div class="btn-group">
							<a type="button" class="btn btn-danger" data-toggle="modal"
										data-target="#roleModel${ comment.id }"> <i class="fa fa-trash"></i>
									</a>
						<!-- delete role Modal-->
						<div class="modal fade justify-content-center" id="roleModel${ comment.id }"
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
										Bạn muốn xóa bình luận tiêu cực với nội dung là ${ comment.contentComment} của ${ comment.userComment}?
									</div>
									<div class="modal-footer">
										<button class="btn btn-secondary" type="button"
											data-dismiss="modal">Hủy</button>
										<a class="btn btn-primary"
											href="<c:url value = "/admin/new-admin/censorship-new/delete-comment-new/${ comment.id }"/>">Xóa
										</a>
									</div>
								</div>
							</div>
						</div>
						<!-- end delete role modal -->
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
				<li class="page-item disabled"><a href="<c:url value="/admin/new-admin/censorship-new/comments/pages/${ loop.index }"/>"
					class="page-link">${loop.index}</a></li>
			</c:if>

			<c:if test="${ (loop.index) != paginateInfo.currentPage }">
				<li class="page-item"><a class="page-link" href="<c:url value="/admin/new-admin/censorship-new/comments/pages/${ loop.index }"/>">${ loop.index }</a></li>
			</c:if>
		</c:forEach>
	</ul>
</body>