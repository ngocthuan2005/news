<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<c:set var="cate" value="${ newUpdate.id_category }"></c:set>
<c:set var="image" value="${ newUpdate.image }"></c:set>

<title>SỬa tin</title>
<body>
	<div class="row">
		<div class="col">
			<div class="container">
				<!-- form start -->
				<form method="POST"
					action="<c:url value = "/admin/new-admin/write-new/updateNew/"/>"
					id="form">
					<div class="form-group">
						<div class="row">
							<div class="col">
								<label for="title">Tên bài viết <i
									class="fa-duotone fa-asterisk"></i></label> <input type="text"
									class="form-control" id="title" name="title"
									value="${newUpdate.title }" placeholder="Nhập tên bài viết"
									required>
							</div>
							<div class="col">
								<label for="slug">Đường dẫn <i
									class="fa-duotone fa-asterisk"></i></label> <input type="text"
									class="form-control" id="slug" name="slug"
									value="${ newUpdate.slug }" readonly>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="tomtat">Tóm tắt (Ngắn)<i
							class="fa-duotone fa-asterisk"></i></label>
						<textarea id="tomtat" name="tomtat"
							placeholder="Nhập tóm tắt ngắn" class="form-control" required>${ newUpdate.summary }</textarea>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col">
								<label for="danhmuc">Danh mục <i
									class="fa-duotone fa-asterisk"></i>

								</label> <select name="danhmuc" id="danhmuc" class="form-control"
									required>
									<option value="0">-- Chọn danh mục --</option>
									<c:forEach var="category" items="${ categories }">
										<c:if test="${ category.id == cate }">
											<option selected value="${ category.id }">${ category.title }</option>
										</c:if>
										<c:if test="${ category.id != cate }">
											<option value="${ category.id }">${ category.title }</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<div class="col">
								<label for="thuoctinh">Thuộc tính danh mục <i
									class="fa-duotone fa-asterisk"></i>
								</label> <select name="thuoctinh" id="thuoctinh"
									class="form-control thuoctinh">
									<c:forEach var="property" items="${ properties }">
										<!-- KIểm tra property có bằng category -->
										<c:if test="${ cate == property.id_category }">

											<c:if test="${ property.id == newUpdate.id_property }">
												<option selected value="${ property.id }">${ property.title }</option>
											</c:if>
											<c:if test="${ property.id != newUpdate.id_property }">
												<option value="${ property.id }">${ property.title }</option>
											</c:if>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>

					<div class="form-group">

						<div class="row">
							<div class="col">
								<label for="examleInput"> Thêm hình ảnh <i
									class="fa-duotone fa-asterisk"></i>
								</label> <input type="file" id="hinhanh" name="hinhanh"
									class="form-control" accept="image/*" required> <img
									alt="${ image }" class="mt-1"
									style="max-width: 200px; max-height: 200px;"
									src="<c:url value = "/public/user/uploads/tintuc/${ image }"/>">
							</div>
							<div class="col">
								<label for="examleInput">Thêm video(Không bắt buộc)</label> <input
									type="file" id="video" name="video" class="form-control" 
									src="<c:url value = "/public/user/uploads/tintuc/${ video }"/>"
									accept="video/*">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="content"> Nội dung bài biết <i
							class="fa-duotone fa-asterisk"></i>
						</label>
						<textarea id="content" name="content" class="form-control"
							required>${ newUpdate.content }</textarea>
					</div>
					<input type = "hidden" value = "${ admin.id }" id = "idAdmin">

					<h1 class="h3" id="error"></h1>

					<div class="form-group mb-3 clearfix">
						<input type="submit" class="btn btn-primary" value="Sửa">
						<a class="btn btn-outline-info"
							href="<c:url value = "/admin/new-admin/write-new/${ admin.id_role }"/>"><i
							class="fa-solid fa-arrow-left"></i>Quay lại</a>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>