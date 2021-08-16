<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/views/layouts/user/breadcrumb.jsp"%>

<div class="category page">
	<div class="container">
		<div class="page-header category-page-header">

			<h2 class="page-title">Sách của thể loại: ${ category.name }</h2>
			<p class="page-subtitle">Danh sách sách, tài liệu thuộc thể loại
				"${ category.name }"</p>
		</div>
		<!-- /.page-header -->

		<div class="page-body">
			<div class="row">
				<!-- ========================================= CONTENT ========================================= -->
				<div class="col-sm-8 col-sm-push-4" id="bookUpdate">
					<div class="category-toolbar"></div>
					<!-- /.category-toolbar -->

					<div class="tab-content">
						<div class="tab-pane active  wow fadeInUp" id="grid"
							role="tabpanel"
							style="visibility: visible; animation-name: fadeInUp;">
							<div class="category-books books grid-view">
								<div class="row">
									<c:forEach var="item" items="${ booksByCategory }">
										<div class="col-md-4 col-sm-6">

											<div class="book">
												<div class="book-cover">
													<div class="book-inner">

														<img
															src="<c:url value="/file-upload/images/${ item.img }"></c:url>"
															width="193" height="261" alt="${ item.name }">
														<div class="fade"></div>
														<div class="book-price">

															<span class="price"> <a
																href="<c:url value="/chi-tiet-sach/${ item.ID }"></c:url>">Xem
																	ngay</a>
															</span>
														</div>
														<!-- /.book-price -->
													</div>
													<!-- /.book-inner -->
												</div>
												<!-- /.book-cover -->


												<div class="book-details">
													<h3 class="book-title" style="font-size: 16px;">
														<a
															href="<c:url value="/chi-tiet-sach/${ item.ID }"></c:url>">${ item.name }</a>
													</h3>
													<div class="star-rating">
														<c:forEach var="i" begin="1" end="${ item.star }">
															<i class="fa fa-star color"></i>
														</c:forEach>
														<c:forEach var="i" begin="1" end="${ 5 - item.star }">
															<i class="fa fa-star"></i>
														</c:forEach>
													</div>
													<!-- /.star-rating -->

												</div>
												<!-- /.book-details -->
											</div>
											<!-- /.book -->

										</div>
									</c:forEach>
								</div>
							</div>
							<!-- /.category-books -->
						</div>
						<!-- /.tab-pane -->

					</div>
					<!-- /.tab-content -->

					<ul class="pagination book-pagination">

					</ul>
					<!-- /.pagination -->

				</div>
				<!-- /.col -->
				<!-- ========================================= CONTENT :END ========================================= -->
				<!-- ========================================= SIDEBAR ========================================= -->
				<div class="col-sm-4 col-sm-pull-8">
					<aside class="sidebar">
						<!-- ========================================= BOOK CATEGORY ========================================= -->
						<section class="module">
							<header class="module-header">
								<h4 class="module-book-category-title">Thể loại</h4>
							</header>
							<!-- /.module-header -->

							<div class="module-body category-module-body">
								<ul class="list-unstyled category-list">
									<c:forEach var="item" items="${ categories }">
										<li><a
											href="<c:url value="/sach-theo-the-loai/${ item.ID }"></c:url>">${ item.name }</a></li>
									</c:forEach>
								</ul>
								<!-- /.list-unstyled -->
							</div>
							<!-- /.module-body -->
						</section>
						<!-- /.module -->
						<!-- ========================================= BOOK CATEGORY : END ========================================= -->
					</aside>
					<!-- /.sidebar -->
				</div>
				<!-- /.col -->
				<!-- ========================================= SIDEBAR :END ========================================= -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-body -->
	</div>
	<!-- /.container -->
</div>