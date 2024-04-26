<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>${ propertyTitle }</title>
<body>
	<!-- Main Breadcrumb Start -->
	<div class="main--breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="<c:url value = "/"/>" class="btn-link"><i
						class="fa fm fa-home"></i>Trang chủ</a></li>
				<li><a href="<c:url value = "/${slugCategory}"/>"
					class="btn-link"> <span>${ categpryTitle }</span>
				</a></li>
				<li class="active"><span>${ propertyTitle }</span></li>
			</ul>
		</div>
	</div>
	<!-- Main Breadcrumb End -->


	<!-- Main Content Section Start -->
	<div class="main-content--section pbottom--30">
		<div class="container">

			<div class="row">
				<!-- Main Content Start -->
				<div class="main--content col-12" data-sticky-content="true">
					<div class="sticky-content-inner">

						<div class="row">
							<div class="col-md-12 ptop--30 pbottom--30">
								<c:if test="${ not empty propertyBySlugs }">

									<c:forEach items="${ propertyBySlugs }" var="propertyBySlug">

										<!-- Post Items Start -->
										<div class="post--items post--items-2"
											data-ajax-content="outer">
											<ul class="nav" data-ajax-content="inner">
												<li>
													<!-- Post Item Start -->
													<div class="post--item">
														<div class="row">
															<div class="col-md-3">
																<div class="post--img">
																	<a
																		href="<c:url value = "/tin-tuc/${propertyBySlug.newSlug }"/>"
																		class="thumbnail"><img
																		src="<c:url value = "/public/user/uploads/tintuc/${ propertyBySlug.image}"/>"
																		alt=""></a> <a
																		href="<c:url value = "/${propertyBySlug.categorySlug }/${propertyBySlug.propertySlug }"/>"
																		class="cat">${ propertyBySlug.propertyTitle }</a>

																</div>
															</div>

															<div class="col-md-9 mt-1">
																<div class="post--info">
																	<ul class="nav meta">
																		<li><span>${propertyBySlug.author }</span></li>
																		<li><span>${ propertyBySlug.approvalDate }</span></li>
																		<li><span><i class="fa fm fa-eye"></i>${ propertyBySlug.view }</span></li>
																	</ul>

																	<div class="title">
																		<h2 class="h3" style="color: black">
																			<a
																				href="<c:url value = "/tin-tuc/${ propertyBySlug.newSlug }"/>"
																				class="btn-link">${ propertyBySlug.newTitle }</a>
																		</h2>
																	</div>
																</div>

																<div class="post--content">
																	<p>${ propertyBySlug.summary }</p>
																</div>

																<div class="post--action">
																	<a
																		href="<c:url value = "/tin-tuc/${ propertyBySlug.newSlug }"/>">
																		Xem chi tiết</a>
																</div>
															</div>
														</div>
													</div> <!-- Post Item End -->
												</li>


												<li>
													<!-- Divider Start -->
													<hr class="divider"> <!-- Divider End -->
												</li>
											</ul>


										</div>
										<!-- Post Items End -->
									</c:forEach>
								</c:if>
							</div>
						</div>
					</div>
				</div>
				<!-- Main Content End -->
			</div>
		</div>
	</div>
	<!-- Main Content Section End -->

</body>
