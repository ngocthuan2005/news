
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Thêm tin tức</title>
<body>	
	<div class="container">
		<!-- form start -->
		<div class="form-group">
			<div class="row">
				<div class="col">
					<label for="title">Tên bài viết <i
						class="fa-duotone fa-asterisk"></i></label> <input type="text"
						class="form-control" id="title" placeholder="Nhập tên bài viết"
						required>
				</div>
				<div class="col">
					<label for="slug">Đường dẫn <i
						class="fa-duotone fa-asterisk"></i></label> <input type="text"
						class="form-control" id="slug" readonly>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="tomtat">Tóm tắt (Ngắn)<i
				class="fa-duotone fa-asterisk"></i></label>
			<textarea id="tomtat" placeholder="Nhập tóm tắt ngắn"
				class="form-control" required></textarea>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col">
					<label for="danhmuc">Danh mục <i
						class="fa-duotone fa-asterisk"></i>
					</label> <select id="danhmuc" class="form-control" required>
						<option value="0">-- Chọn danh mục --</option>
						<c:forEach var="cate" items="${ categoriesAdmin }">
							<option value="${ cate.id }">${ cate.title }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col">
					<label for="thuoctinh">Thuộc tính danh mục <i
						class="fa-duotone fa-asterisk"></i>
					</label> <select id="thuoctinh" class="form-control thuoctinh">

					</select>
				</div>
			</div>
		</div>

		<div class="form-group">

			<div class="row">
				<div class="col">
					<label for="hinhanh"> Thêm hình ảnh <i
						class="fa-duotone fa-asterisk"></i>
					</label> <input type="file" id="hinhanh" class="form-control"
						accept="image/*" required>
				</div>
				<div class="col">
					<label for="video">Thêm video(Không bắt buộc)</label> <input
						type="file" id="video" class="form-control" accept="video/*">
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="content"> Nội dung bài biết <i
				class="fa-duotone fa-asterisk"></i>
			</label>
			<textarea id="content" class="form-control" required></textarea>
		</div>

		<input id="author" type="hidden" value="${ admin.id }"> <input
			id="id_role" type="hidden" value="${ admin.id_role }">

		<h1 class="h3 text-danger mb-3" id="error"></h1>

		<div class="form-group mb-3 clearfix">
			<input type="submit" id="btnAddNew" class="btn btn-primary"
				value="Thêm"> <a class="btn btn-outline-info"
				href="<c:url value = "/admin/new-admin/write-new/${ admin.id_role }/"/>"><i
				class="fa-solid fa-arrow-left"></i>Quay lại</a>
		</div>
	</div>
	
	<div id="toast"></div>
</body>