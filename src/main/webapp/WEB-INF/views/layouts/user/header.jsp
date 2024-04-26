<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!-- Header Section Start -->
<header class="header--section header--style-3">
	<!-- Header Topbar Start -->
	<div class="header--topbar bg--color-1">
		<div class="container">
			<div class="float--left float--xs-none text-xs-center">
				<!-- Header Topbar Info Start -->
				<ul class="header--topbar-info nav">
					<li><i class="fa fm fa-map-marker"></i><span
						id="container__location"></span></li>
					<li><i class="fa fm fa-mixcloud"></i><span
						id="container__tempera"></span><sup>0</sup> C</li>
					<li><i class="fa fm fa-calendar"></i><span
						id="container__date"></span></li>
				</ul>
				<!-- Header Topbar Info End -->
			</div>


			<div class="float--right float--xs-none text-xs-center">
				<!-- Header Topbar Action Start -->

				<c:if test="${ empty user }">
					<ul class="header--topbar-action nav">
						<li><a class="btn bg--color-1"
							href='<c:url value ="/login-signup/login/"/>'><i
								class="fa fm fa-user-o"></i>Đăng nhập/Đăng ký</a></li>
					</ul>
				</c:if>

				<c:if test="${ not empty user }">

					<ul class="header--menu-links nav navbar-nav"
						data-trigger="hoverIntent">
						<li class="dropdown"><span class="btn">${ user.name }</span>
							<ul class="dropdown-menu">
								<c:if test="${ user.id_role == 0 }">
									<li><a href="<c:url value = "/login-signup/signOut/"/>">
											Đăng xuất </a></li>
								</c:if>
							</ul></li>
					</ul>
				</c:if>
				<!-- Header Topbar Action End -->

			</div>
		</div>
	</div>
	<!-- Header Topbar End -->

	<!-- Header Mainbar Start -->
	<div class="header--mainbar">
		<div class="container">
			<!-- Header Logo Start -->
			<div class="header--logo float--left float--sm-none">
				<a href='<c:url value = "/"/>' class="btn-link"> <img
					style="height: 100px;"
					src="<c:url value = "/public/user/uploads/tintuc/LoGo_HTNews.jpg"/>" />
				</a> <span class="hidden">Kcnew - logo</span>
			</div>
			<!-- Header Logo End -->
		</div>
	</div>
	<!-- Header Mainbar End -->

	<!-- Header Navbar Start -->
	<div class="header--navbar navbar bd--color-1 bg--color-0"
		data-trigger="sticky">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#headerNav"
					aria-expanded="false" aria-controls="headerNav">
					<span class="sr-only">Toggle Navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<div id="headerNav" class="navbar-collapse collapse float--left">
				<!-- Header Menu Links Start -->
				<ul class="header--menu-links nav navbar-nav"
					data-trigger="hoverIntent">
					<c:forEach items="${ categories }" var="category">
						<li class="dropdown"><a
							href="<c:url value = "/${ category.slug }"/>">${ category.title }</a>
							<ul class="dropdown-menu">
								<c:forEach items="${properties }" var="property">
									<c:if test="${category.id == property.id_category }">
										<li><a
											href="<c:url value = "/${ category.slug }/${property.slug}"/>">${ property.title }</a></li>
									</c:if>
								</c:forEach>
							</ul></li>

					</c:forEach>

				</ul>
				<!-- Header Menu Links End -->
			</div>

			<!-- Header Search Form Start -->
			<form method="POST" action="#"
				class="header--search-form float--right" data-form="validate">
				<input type="hidden" name="_token"
					value="tN7wwlY5SleuIOoI545rZT8qySnpix8Vd9mMB01v" /> <input
					type="search" name="search" placeholder="Search..."
					class="header--search-control form-control" required />

				<button type="submit" class="header--search-btn btn">
					<i class="header--search-icon fa fa-search"></i>
				</button>
			</form>
			<!-- Header Search Form End -->
		</div>
	</div>
	<!-- Header Navbar End -->
</header>

<!-- Header Section End -->

<!-- Posts Filter Bar Start -->
<div class="posts--filter-bar style--3 hidden-xs">
	<div class="container">
		<ul class="nav">
			<li><a href="#!"> <i
					class="fa fa-star-o"></i> <span>Tin tức mới nhất</span>
			</a></li>

			<li><a href="#!"> <i
					class="fa fa-fire"></i> <span>Tin nóng</span>
			</a></li>
			<li><a href="#!"> <i
					class="fa fa-eye"></i> <span>Xem nhiều nhất</span>
			</a></li>
		</ul>
	</div>
</div>
<!-- Posts Filter Bar End -->

<!-- News Ticker Start -->
<div class="news--ticker">
	<div class="container">
		<div class="title">
			<h2>Tin mới cập nhật</h2>
		</div>

		<div class="news-updates--list" data-marquee="true">
			<ul class="nav">
				<c:forEach items="${ newUpdates }" var="newUpdate">
					<li>

						<h3 class="h3">
							<a href='<c:url value = "/tin-tuc/${ newUpdate.slug }"/>'>${newUpdate.title }</a>
						</h3>

					</li>
				</c:forEach>

			</ul>
		</div>
	</div>
</div>
<!-- News Ticker End -->
