<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<title>${ breadCrumby }</title>
<body>
	<!-- Main Breadcrumb Start -->
	<div class="main--breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="<c:url value = "/"/>" class="btn-link"><i
						class="fa fm fa-home"></i>Trang chủ</a></li>
				<li class="active"><span>${ breadCrumby }</span></li>
			</ul>
		</div>
	</div>
	<!-- Main Breadcrumb End -->

	<!-- Main Content Section Start -->
	<div class="main-content--section pbottom--30">
		<div class="container">
			<!-- Main Content Start -->
			<div class="main--content">
				<!-- Post Items Start -->
				<div class="post--items post--items-1 pd--30-0">
					<div class="row">
						<c:forEach items="${ categoryBySlugsLimits }"
							var="categoryBySlugsLimit">
							<div class="col-sm-12 col-md-6 col-lg-4">
								<!-- Post Item Start -->
								<div class="post--item post--layout-1 post--title-large">
									<div class="post--img">
										<a
											class = "thumb"
											href="<c:url value = "/tin-tuc/${ categoryBySlugsLimit.newSlug }"/>">
											<img class="img-fluid" height="400" style="width: 100%;"
											src='<c:url value = "/public/user/uploads/tintuc/${ categoryBySlugsLimit.image }"/>'
											alt="">
										</a> 
										
										<div class="post--info">
											<ul class="nav meta">
												<li><span class="d-inline bg-black">${ categoryBySlugsLimit.author }</span></li>

												<li><span class="d-inline bg-black">${ categoryBySlugsLimit.approvalDate }</span></li>
											</ul>

											<div class="title">
												<h2 class="h4 d-inline bg-black">
													<a
														href="<c:url value = "/tin-tuc/${ categoryBySlugsLimit.newSlug }"/>"
														class="btn-link">${ categoryBySlugsLimit.newTitle }</a>
												</h2>
											</div>
										</div>
									</div>
								</div>
								<!-- Post Item End -->
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- Post Items End -->
			</div>
			<!-- Main Content End -->




			<!-- Category News Start -->
			<c:forEach items="${ propertiesForCategory }" var="property">

				<div class="row mt-2">
					<div class="post--items post--items-1">

						<!-- Post Items Title Start -->
						<div class="post--items-title col-md-2 col-sm-3 col-lg-2 ms-2"
							style="margin-left: (1rem* .25);" data-ajax="tab">
							<h2 class="h4">${ property.title }</h2>
							<!-- Post Items Title End -->
						</div>
					</div>
				</div>

				<div class="row">
					<!-- Post Items Start -->
					<c:forEach items="${ categoryBySlugs}" var="categoryBySlug">
						<c:if test="${property.id == categoryBySlug.idProperty }">

							<div class="col-sm-12 col-md-6 col-lg-4 pbottom--30">
								<!-- Post Item Start -->
								<div class="post--item post--layout-1 post--title-large">
									<div class="post--img">
										<a
											class = "thumb"
											href="<c:url value = "/tin-tuc/${ categoryBySlug.newSlug }"/>">
											<img class="img-fluid" height="400" style="width: 100%;"
											src='<c:url value = "/public/user/uploads/tintuc/${ categoryBySlug.image }"/>'
											alt="${ categoryBySlug.image }">
										</a>

										<div class="post--info">
											<ul class="nav meta">
												<li><span class="d-inline bg-black">${ categoryBySlug.author }</span></li>

												<li><span class="d-inline bg-black">${ categoryBySlug.approvalDate }</span></li>
											</ul>

											<div class="title">
												<h2 class="h4 d-inline bg-black">
													<a
														href="<c:url value = "/tin-tuc/${ categoryBySlug.newSlug }"/>"
														class="btn-link">${ categoryBySlug.newTitle }</a>
												</h2>
											</div>
										</div>
									</div>
								</div>
								<!-- Post Item End -->
							</div>
						</c:if>
					</c:forEach>
					<!-- Post Items End -->
				</div>
			</c:forEach>
			<!-- Category News End -->
		</div>
	</div>
</body>