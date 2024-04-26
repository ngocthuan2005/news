<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<li>
		<div class="sidebar-brand-text">
			<c:if test="${ admin.id_role == 1}">

				<a
					href="<c:url value = "/admin/account/showALL/${ admin.id_role }"/>"
					class="sidebar-brand d-flex align-items-center justify-content-center">
					<i class="fa-solid fa-house p-2"></i>
				</a>
			</c:if>
			<c:if test="${ admin.id_role == 2}">

				<a href="#"
					class="sidebar-brand d-flex align-items-center justify-content-center">
					<i class="fa-solid fa-house p-2"></i>
				</a>
			</c:if>
			<c:if test="${ admin.id_role == 3}">
				<a
					href="<c:url value = "/admin/new-admin/write-new/${ admin.id_role }/"/>"
					class="sidebar-brand d-flex align-items-center justify-content-center">
					<i class="fa-solid fa-house p-2"></i>
				</a>
			</c:if>

		</div>
	</li>
	<!-- Divider -->
	<li>
		<hr class="sidebar-divider">
	</li>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><c:if test="${ admin.id_role == 1}">
			<a class="nav-link" href="<c:url value = "/admin/account/showALL/${ admin.id_role }"/>"> <i
				class="fa fa-users"></i> <span> Quản lý tài khoản </span>
			</a>
			<a class="nav-link"
				href="<c:url value = "/admin/1/quan-ly-vai-tro/"/>"> <i
				class="fa fa-users"></i> <span> Quản lý vai trò </span>
			</a>
		</c:if> <c:if test="${ admin.id_role == 2 }">
			<a class="nav-link"
				href="<c:url value = "/admin/new-admin/censorship-new/"/>">
				<i class="fa fa-users"></i> Kiểm duyệt tin tức
			</a>
			<a class="nav-link"
				href="<c:url value = "//admin/new-admin/censorship-new/checkCommentAll/"/>">
				<i class="fa fa-users"></i> Kiểm duyệt bình luận
			</a>
		</c:if> <c:if test="${ admin.id_role == 3}">
			<a class="nav-link"
				href="<c:url value = "/admin/new-admin/write-new/${ admin.id_role }/"/>">
				<i class="fa fa-users"></i> Quản lý tin tức
			</a>
		</c:if></li>
</ul>
<!-- End of Sidebar -->

