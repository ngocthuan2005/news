<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<c:set var="newTitle" value="${ newDetail.newTitle }"></c:set>
<c:set var="countComment" value="${ newDetail.countComment }"></c:set>
<c:set var="newSlug" value="${ newDetail.newSlug }"></c:set>
<c:set var="idUser" value="${ user.id }"></c:set>
<title>${ newTitle }</title>
<body>
	<!-- Main Breadcrumb Start -->
	<div class="main--breadcrumb">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="<c:url value = "/" />" class="btn-link"><i
						class="fa fm fa-home"></i>Trang chủ</a></li>
				<li><a class="btn-link"
					href="<c:url value = "/${ newDetail.categorySlug }" />"> <span>${ newDetail.categoryTitle }</span>
				</a></li>
				<li><a
					href="<c:url value = "/${ newDetail.categorySlug }/${ newDetail.propertySlug }" />"
					class="btn-link"> <span>${ newDetail.propertyTitle }</span>
				</a></li>
				<li class="active"><span>${ newTitle }</span></li>
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
						<!-- Post Item Start -->
						<div class="post--item post--single post--title-largest mt-2">
							<div class="post--img" style="width: 50%; margin: 0 auto;">

								<c:if test="${not empty user }">
									<a class="thumb"><img
										src="<c:url value = "/public/user/uploads/tintuc/${ newDetail.image }"/>"
										alt=""></a>
									<a href="<c:url value = "/likes/${newSlug}/${idUser}"/>"
										class="icon"><i class="fa fa-heartbeat" aria-hidden="true"></i>
									</a>
								</c:if>
								<c:if test="${ empty user }">
									<a class="thumb"><img
										src="<c:url value = "/public/user/uploads/tintuc/${ newDetail.image }"/>"
										alt=""></a>
									<a href="<c:url value = "/login-signup/login/"/>" class="icon"><i
										class="fa fa-heartbeat" aria-hidden="true"></i> </a>
								</c:if>
							</div>

							<div class="post--info">
								<ul class="nav meta mt-1">
									<li><span>${ newDetail.author }</span></li>
									<li><span>${ newDetail.approvalDate }</span></li>
									<li><span><i class="fa fm fa-eye"></i>${ newDetail.view }</span></li>
									<li><span><i class="fa fm fa-comments-o"></i>${ countComment }</span></li>
									<li><span><i class="fa fm fa-heart"></i>${ newDetail.likes }</span></li>
								</ul>

								<div class="title">
									<h2 class="h4">${ newDetail.newTitle }</h2>
								</div>
							</div>



							<div class="post--content w-100 text-start">
								<div style="padding-left: 50px; padding-right: 50px;">${ newDetail.content }</div>
							</div>
						</div>
						<!-- Post Item End -->

						<!-- Post Social Start -->
						<div class="post--social pbottom--30">
							<span class="title"><i class="fa fa-share-alt"></i></span>

							<!-- Social Widget Start -->
							<div class="social--widget style--4">
								<ul class="nav">
									<li><a href="#"><i class="fa fa-facebook"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
									<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
									<li><a href="#"><i class="fa fa-rss"></i></a></li>
									<li><a href="#"><i class="fa fa-youtube-play"></i></a></li>
								</ul>
							</div>
							<!-- Social Widget End -->
						</div>
						<!-- Post Social End -->

						<!-- Post Nav Start -->
						<div class="post--nav">
							<ul class="nav row">

								<c:forEach items="${ newByAuthors }" var="newByAuthor">

									<li class="col-lg-4 col-md-6 col-sm-12 ptop--30 pbottom--30">
										<!-- Post Item Start -->
										<div class="post--item" style="text-align: left;">
											<div class="post--img">
												<a style="text-align: center; max-width: none; width: 100%;"
													href="<c:url value = "/tin-tuc/${ newByAuthor.newSlug }"/>"
													class="thumbnail"><img
													src="<c:url value = "/public/user/uploads/tintuc/${ newByAuthor.image }"/>"
													alt="${newByAuthor.image }"> </a>

												<div class="post--info">
													<ul class="nav meta">
														<li><span>${ newByAuthor.author }</span></li>
														<li><span>${ newByAuthor.approvalDate }</span></li>
													</ul>

													<div class="title">
														<h3 class="h4">
															<a
																href="<c:url value = "/tin-tuc/${ newByAuthor.newSlug }"/>"
																class="btn-link">${ newByAuthor.newTitle }</a>
														</h3>
													</div>
												</div>
											</div>
										</div> <!-- Post Item End -->
									</li>
								</c:forEach>
							</ul>
						</div>
						<!-- Post Nav End -->

						<!-- Post Related Start -->
						<div class="post--related ptop--30">
							<!-- Post Items Title Start -->
							<div class="post--items-title" data-ajax="tab">
								<h2 class="h4">Có thể bạn cũng thích</h2>

							</div>
							<!-- Post Items Title End -->

							<!-- Post Items Start -->
							<div class="post--items post--items-2" data-ajax-content="outer">
								<ul class="nav row" data-ajax-content="inner">
									<c:forEach items="${ newByProperties }" var="newByProperty">

										<li class="col-lg-4 col-md-6 col-sm-12 pbottom--30">
											<!-- Post Item Start -->
											<div class="post--item post--layout-1">
												<div class="post--img">
													<a
														href="<c:url value = "/tin-tuc/${ newByProperty.newSlug }"/>"
														class="thumbnail"><img
														src="<c:url value = "/public/user/uploads/tintuc/${ newByProperty.image }"/>"
														alt="${ newByProperty.image }"></a> <a
														href="<c:url value = "/${newByProperty.categorySlug }/${newByProperty.propertySlug }"/>"
														class="cat">${newByProperty.propertyTitle }</a>

													<div class="post--info">
														<ul class="nav meta">
															<li><span>${ newByProperty.author }</span></li>
															<li><span>${ newByProperty.approvalDate }</span></li>
														</ul>

														<div class="title">
															<h3 class="h4">
																<a
																	href="<c:url value = "/tin-tuc/${ newByProperty.newSlug }"/>"
																	class="btn-link">${newByProperty.newTitle }</a>
															</h3>
														</div>
													</div>
												</div>

												<div class="post--content">
													<p>${ newByProperty.summary }</p>
												</div>

												<div class="post--action">
													<a
														href="<c:url value = "/tin-tuc/${ newByProperty.newSlug }"/>">Đọc
														tiếp</a>
												</div>
											</div> <!-- Post Item End -->
										</li>
									</c:forEach>

								</ul>

								<!-- Preloader Start -->
								<div class="preloader bg--color-0--b" data-preloader="1">
									<div class="preloader--inner"></div>
								</div>
								<!-- Preloader End -->
							</div>
							<!-- Post Items End -->
						</div>
						<!-- Post Related End -->

						<!-- Comment List Start -->
						<div class="comment--list pd--30-0">
							<!-- Post Items Title Start -->
							<div class="post--items-title">
								<h2 class="h4">${ countComment }
									<span style="margin-left: 1px">bình luận</span>
								</h2>

								<i class="icon fa fa-comments-o"></i>
							</div>
							<!-- Post Items Title End -->

							<ul class="comment--items nav"
								style="border: 2px #f2f3f5 solid;">
								<li style="margin-bottom: 12px;" ><c:if test="${ comments.size() == 0 }">
										<!-- Comment Item Start -->
										<div class="comment--item clearfix">
											<div class="comment--info">
												<div class="comment--content">
													<p>Chưa có bình luận nào</p>
												</div>
											</div>
										</div>

										<!-- Comment Item End -->

									</c:if> 
									
									<c:if test="${ comments.size() != 0 }">

										<c:forEach items="${ comments }" var="comment">

											<c:if test="${ not empty user }">

												<c:if test="${comment.idUser == user.id }">
													<!-- Comment Item Start -->
													<div class="comment--item clearfix">
														<div class="comment--info pull-right mt-2">
															<div class="comment--header clearfix">
																<p class="name">${ comment.userName }</p>
																<p class="date">${ comment.commentDate }</p>
															</div>
															<div class="comment--content">
																<p>${comment.contentComment }</p>
															</div>
														</div>
													</div>
													<!-- Comment Item End -->
												</c:if>
												<c:if test="${comment.idUser != user.id }">
												<!-- Comment Item Start -->
												<div class="comment--item clearfix">
													<div class="comment--info pull-left">
														<div class="comment--header clearfix">
															<p class="name">${ comment.userName }</p>
															<p class="date">${ comment.commentDate }</p>
														</div>
														<div class="comment--content">
															<p>${comment.contentComment }</p>
														</div>
													</div>
												</div>
												<!-- Comment Item End -->
												
												</c:if>
											</c:if>
											
											<c:if test="${ empty user }">
												<!-- Comment Item Start -->
												<div class="comment--item clearfix">
													<div class="comment--info">
														<div class="comment--header clearfix">
															<p class="name">${ comment.userName }</p>
															<p class="date">${ comment.commentDate }</p>
														</div>
														<div class="comment--content">
															<p>${comment.contentComment }</p>
														</div>
													</div>
												</div>
												<!-- Comment Item End -->
											</c:if>
										</c:forEach>

									</c:if></li>
							</ul>
						</div>
						<!-- Comment List End -->

						<!-- Comment Form Start -->
						<div class="comment--form pd--30-0">
							<!-- Post Items Title Start -->
							<div class="post--items-title">
								<h2 class="h4">Viết bình luận</h2>

								<i class="icon fa fa-pencil-square-o"></i>
							</div>
							<!-- Post Items Title End -->

							<div class="comment-respond">
								<div data-form="validate">
									<p>Đừng lo ! Địa chỉ email của bạn sẽ không được công bố
										(*).</p>

									<div class="row">
										<div class="col">
											<label> <span>Comment *</span> <textarea id="comment"
													class="form-control" required></textarea>
											</label>
										</div>
										<div class="col-12">
											<c:if test="${ not empty user }">
												<button class="btn btn-primary"
													onclick="comment(`${ newSlug }`, `${ idUser }`)">
													Đăng</button>
											</c:if>
											<c:if test="${ empty user }">
												<a href="<c:url value = "/login-signup/login/"/>"
													class="btn btn-primary">Đăng</a>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Comment Form End -->
					</div>
				</div>
				<!-- Main Content End -->
			</div>
		</div>
	</div>
	<!-- Main Content Section End -->
</body>