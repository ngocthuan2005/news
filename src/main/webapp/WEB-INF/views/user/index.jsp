<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Trang chủ</title>
<body>
	<!-- Main Content Section Start -->
	<div class="main-content--section pbottom--30">
		<div class="container">
			<!-- Main Content Start -->
			<div class="main--content">
				<!-- Post Items Start -->
				<div class="post--items post--items-1 pd--30-0">
					<div class="row">

						<c:forEach items="${ newSixs }" var="nexSix">
							<div class="col-sm-12 col-md-6 col-lg-4">
								<!-- Post Item Start -->
								<div class="post--item post--layout-1 post--title-large">
									<div class="post--img">
										<a 
											class = "thumb"
											href="<c:url value = "/tin-tuc/${ nexSix.newSlug }"/>">
											<img class="img-fluid" height="400" style="width: 100%;"
											src='<c:url value = "/public/user/uploads/tintuc/${ nexSix.image }"/>'
											alt="">
										</a>
									
										<div class="post--info">
											<ul class="nav meta">
												<li><span class="d-inline bg-black">${ nexSix.author }</span></li>

												<li><span class="d-inline bg-black">${ nexSix.approvalDate }</span></li>
											</ul>

											<div class="title">
												<h2 class="h4 d-inline bg-black">
													<a href="<c:url value = "/tin-tuc/${ nexSix.newSlug }"/>"
														class="btn-link">${ nexSix.newTitle }</a>
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
			<c:forEach items="${ categoriesNews }" var="category">

				<div class="row mt-2">
					<div class="post--items post--items-1">

						<!-- Post Items Title Start -->
						<div class="post--items-title col-md-2 col-sm-3 col-lg-2 ms-2"
							style="margin-left: (1rem* .25);" data-ajax="tab">
							<h2 class="h4">Tin ${ category.title }</h2>
							<!-- Post Items Title End -->
						</div>
					</div>
				</div>

				<div class="row">
					<!-- Post Items Start -->
					<c:forEach items="${ allNewByCategories}" var="newByCategory">
						<c:if test="${newByCategory.idCategory == category.id }">

							<div class="col-sm-12 col-md-6 col-lg-4 pbottom--30">
								<!-- Post Item Start -->
								<div class="post--item post--layout-1 post--title-large">
									<div class="post--img">
										<a 
											class = "thumb"
											href="<c:url value = "/tin-tuc/${ newByCategory.newSlug }"/>">
											<img class="img-fluid" height="400" style="width: 100%;"
											src='<c:url value = "/public/user/uploads/tintuc/${ newByCategory.image }"/>'
											alt="${ newByCategory.image }">
										</a>
										
										<div class="post--info">
											<ul class="nav meta">
												<li><span class="d-inline bg-black">${ newByCategory.author }</span></li>

												<li><span class="d-inline bg-black">${ newByCategory.approvalDate }</span></li>
											</ul>

											<div class="title">
												<h2 class="h4 d-inline bg-black">
													<a href="<c:url value = "/tin-tuc/${ newByCategory.newSlug }"/>"
														class="btn-link">${ newByCategory.newTitle }</a>
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
