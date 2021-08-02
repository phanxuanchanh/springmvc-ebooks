<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/views/layouts/user/breadcrumb.jsp"%>

<div class="category page">
	<div class="container">
		<div class="page-header category-page-header">

			<h2 class="page-title">Sách của thể loại: Khoa học</h2>
			<p class="page-subtitle">Danh sách sách, tài liệu thuộc thể loại
				Khoa học</p>
		</div>
		<!-- /.page-header -->

		<div class="page-body">
			<div class="row">
				<!-- ========================================= CONTENT ========================================= -->
				<div class="col-sm-8 col-sm-push-4" id="bookUpdate">



					<div class="category-toolbar">
						<!--<div class="row">
        <div class="col-md-3 col-sm-4">
            <ul id="myTab" class="nav nav-tabs grid-list-view-buttons" role="tablist">
                <li role="presentation" class="active"><a href="#grid" class="btn navbar-btn" role="tab" data-toggle="tab"><span class="glyphicon glyphicon-th active"></span></a></li>
                <li role="presentation"><a href="#list" class="btn navbar-btn" role="tab" data-toggle="tab"><span class="glyphicon glyphicon-th-list"></span></a></li>
            </ul>-->
						<!-- /.nav -->
						<!--</div>-->
						<!-- /.col -->
						<!--<div class="col-md-9 col-sm-8">

    </div>-->
						<!-- /.col -->
						<!--</div>-->
						<!-- /.row -->
					</div>
					<!-- /.category-toolbar -->

					<div class="tab-content">
						<div class="tab-pane active  wow fadeInUp" id="grid"
							role="tabpanel"
							style="visibility: visible; animation-name: fadeInUp;">
							<div class="category-books books grid-view">
								<div class="row">
									<div class="col-md-4 col-sm-6">

										<div class="book">
											<div class="book-cover">
												<div class="book-inner">

													<img
														src="/FileUpload/Images/2021/6/5-phuong-trinh-lam-thay-doi-the-gioi-michael-guillen-ph-d.jpg"
														width="193" height="261" alt="Thử nghiệm 3">
													<div class="fade"></div>
													<div class="book-price">

														<span class="price"> <a
															href="/book-details/5-phuong-trinh-lam-thay-doi-the-gioi/5">Xem
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
														href="/book-details/5-phuong-trinh-lam-thay-doi-the-gioi/5">5
														phương trình làm t...</a>
												</h3>
												<div class="star-rating">
													<i class="fa fa-star color"></i> <i
														class="fa fa-star color"></i> <i class="fa fa-star color"></i>
													<i class="fa fa-star color"></i> <i class="fa fa-star "></i>
												</div>
												<!-- /.star-rating -->

											</div>
											<!-- /.book-details -->
										</div>
										<!-- /.book -->

									</div>
									<div class="col-md-4 col-sm-6">

										<div class="book">
											<div class="book-cover">
												<div class="book-inner">

													<img src="/user_assets/images/no-image-available.png"
														width="193" height="261"
														alt="Sách này hiện tại không có ảnh">
													<div class="fade"></div>
													<div class="book-price">

														<span class="price"> <a
															href="/book-details/thu-nghiem-2/6">Xem ngay</a>
														</span>
													</div>
													<!-- /.book-price -->
												</div>
												<!-- /.book-inner -->
											</div>
											<!-- /.book-cover -->


											<div class="book-details">
												<h3 class="book-title" style="font-size: 16px;">
													<a href="/book-details/thu-nghiem-2/6">Thử nghiệm 2...</a>
												</h3>
												<div class="star-rating">
													<i class="fa fa-star color"></i> <i
														class="fa fa-star color"></i> <i class="fa fa-star color"></i>
													<i class="fa fa-star color"></i> <i
														class="fa fa-star color"></i>
												</div>
												<!-- /.star-rating -->

											</div>
											<!-- /.book-details -->
										</div>
										<!-- /.book -->

									</div>
									<div class="col-md-4 col-sm-6">

										<div class="book">
											<div class="book-cover">
												<div class="book-inner">

													<img src="/FileUpload/Images/2021/6/bi-mat-vu-tru.PNG"
														width="193" height="261" alt="Bí mật vũ trụ">
													<div class="fade"></div>
													<div class="book-price">

														<span class="price"> <a
															href="/book-details/bi-mat-vu-tru/7">Xem ngay</a>
														</span>
													</div>
													<!-- /.book-price -->
												</div>
												<!-- /.book-inner -->
											</div>
											<!-- /.book-cover -->


											<div class="book-details">
												<h3 class="book-title" style="font-size: 16px;">
													<a href="/book-details/bi-mat-vu-tru/7">Bí mật vũ
														trụ...</a>
												</h3>
												<div class="star-rating">
													<i class="fa fa-star "></i> <i class="fa fa-star "></i> <i
														class="fa fa-star "></i> <i class="fa fa-star "></i> <i
														class="fa fa-star "></i>
												</div>
												<!-- /.star-rating -->

											</div>
											<!-- /.book-details -->
										</div>
										<!-- /.book -->

									</div>
									<div class="col-md-4 col-sm-6">

										<div class="book">
											<div class="book-cover">
												<div class="book-inner">

													<img src="/FileUpload/Images/2021/6/danh-bai-pho-wall.PNG"
														width="193" height="261" alt="Đánh bại phố Wall">
													<div class="fade"></div>
													<div class="book-price">

														<span class="price"> <a
															href="/book-details/danh-bai-pho-wall/8">Xem ngay</a>
														</span>
													</div>
													<!-- /.book-price -->
												</div>
												<!-- /.book-inner -->
											</div>
											<!-- /.book-cover -->


											<div class="book-details">
												<h3 class="book-title" style="font-size: 16px;">
													<a href="/book-details/danh-bai-pho-wall/8">Đánh bại
														phố Wall...</a>
												</h3>
												<div class="star-rating">
													<i class="fa fa-star color"></i> <i
														class="fa fa-star color"></i> <i class="fa fa-star color"></i>
													<i class="fa fa-star color"></i> <i
														class="fa fa-star color"></i>
												</div>
												<!-- /.star-rating -->

											</div>
											<!-- /.book-details -->
										</div>
										<!-- /.book -->

									</div>
									<div class="col-md-4 col-sm-6">

										<div class="book">
											<div class="book-cover">
												<div class="book-inner">

													<img
														src="/FileUpload/Images/2021/6/50-cong-ty-lam-thay-doi-the-gioi.PNG"
														width="193" height="261"
														alt="50 công ty làm thay đổi thế giới">
													<div class="fade"></div>
													<div class="book-price">

														<span class="price"> <a
															href="/book-details/50-cong-ty-lam-thay-doi-the-gioi/9">Xem
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
													<a href="/book-details/50-cong-ty-lam-thay-doi-the-gioi/9">50
														công ty làm thay ...</a>
												</h3>
												<div class="star-rating">
													<i class="fa fa-star "></i> <i class="fa fa-star "></i> <i
														class="fa fa-star "></i> <i class="fa fa-star "></i> <i
														class="fa fa-star "></i>
												</div>
												<!-- /.star-rating -->

											</div>
											<!-- /.book-details -->
										</div>
										<!-- /.book -->

									</div>
									<div class="col-md-4 col-sm-6">

										<div class="book">
											<div class="book-cover">
												<div class="book-inner">

													<img
														src="/FileUpload/Images/2021/6/tro-thanh-thien-tai-choi-chung-khoan.PNG"
														width="193" height="261"
														alt="Trở thành thiên tài chơi chứng khoán">
													<div class="fade"></div>
													<div class="book-price">

														<span class="price"> <a
															href="/book-details/tro-thanh-thien-tai-choi-chung-khoan/10">Xem
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
														href="/book-details/tro-thanh-thien-tai-choi-chung-khoan/10">Trở
														thành thiên tài ...</a>
												</h3>
												<div class="star-rating">
													<i class="fa fa-star "></i> <i class="fa fa-star "></i> <i
														class="fa fa-star "></i> <i class="fa fa-star "></i> <i
														class="fa fa-star "></i>
												</div>
												<!-- /.star-rating -->

											</div>
											<!-- /.book-details -->
										</div>
										<!-- /.book -->

									</div>
									<div class="col-md-4 col-sm-6">

										<div class="book">
											<div class="book-cover">
												<div class="book-inner">

													<img src="/FileUpload/Images/2021/6/cuoc-chien-lo-den.PNG"
														width="193" height="261" alt="Cuộc chiến lỗ đen">
													<div class="fade"></div>
													<div class="book-price">

														<span class="price"> <a
															href="/book-details/cuoc-chien-lo-den/11">Xem ngay</a>
														</span>
													</div>
													<!-- /.book-price -->
												</div>
												<!-- /.book-inner -->
											</div>
											<!-- /.book-cover -->


											<div class="book-details">
												<h3 class="book-title" style="font-size: 16px;">
													<a href="/book-details/cuoc-chien-lo-den/11">Cuộc chiến
														lỗ đen...</a>
												</h3>
												<div class="star-rating">
													<i class="fa fa-star "></i> <i class="fa fa-star "></i> <i
														class="fa fa-star "></i> <i class="fa fa-star "></i> <i
														class="fa fa-star "></i>
												</div>
												<!-- /.star-rating -->

											</div>
											<!-- /.book-details -->
										</div>
										<!-- /.book -->

									</div>
									<div class="col-md-4 col-sm-6">

										<div class="book">
											<div class="book-cover">
												<div class="book-inner">

													<img src="/FileUpload/Images/2021/6/lich-su-van-vat.PNG"
														width="193" height="261" alt="Lịch sử vạn vật">
													<div class="fade"></div>
													<div class="book-price">

														<span class="price"> <a
															href="/book-details/lich-su-van-vat/12">Xem ngay</a>
														</span>
													</div>
													<!-- /.book-price -->
												</div>
												<!-- /.book-inner -->
											</div>
											<!-- /.book-cover -->


											<div class="book-details">
												<h3 class="book-title" style="font-size: 16px;">
													<a href="/book-details/lich-su-van-vat/12">Lịch sử vạn
														vật...</a>
												</h3>
												<div class="star-rating">
													<i class="fa fa-star color"></i> <i
														class="fa fa-star color"></i> <i class="fa fa-star color"></i>
													<i class="fa fa-star "></i> <i class="fa fa-star "></i>
												</div>
												<!-- /.star-rating -->

											</div>
											<!-- /.book-details -->
										</div>
										<!-- /.book -->

									</div>
									<div class="col-md-4 col-sm-6">

										<div class="book">
											<div class="book-cover">
												<div class="book-inner">

													<img src="/FileUpload/Images/2021/6/so-do.jpg" width="193"
														height="261" alt="Số đỏ">
													<div class="fade"></div>
													<div class="book-price">

														<span class="price"> <a
															href="/book-details/so-do/13">Xem ngay</a>
														</span>
													</div>
													<!-- /.book-price -->
												</div>
												<!-- /.book-inner -->
											</div>
											<!-- /.book-cover -->


											<div class="book-details">
												<h3 class="book-title" style="font-size: 16px;">
													<a href="/book-details/so-do/13">Số đỏ...</a>
												</h3>
												<div class="star-rating">
													<i class="fa fa-star "></i> <i class="fa fa-star "></i> <i
														class="fa fa-star "></i> <i class="fa fa-star "></i> <i
														class="fa fa-star "></i>
												</div>
												<!-- /.star-rating -->

											</div>
											<!-- /.book-details -->
										</div>
										<!-- /.book -->

									</div>
								</div>
							</div>
							<!-- /.category-books -->
						</div>
						<!-- /.tab-pane -->

					</div>
					<!-- /.tab-content -->

					<ul class="pagination book-pagination">

						<div class="pagination-container">
							<ul class="pagination">
								<li class="page-item active"><span class="page-link">1</span></li>
								<li class="page-item"><a class="page-link" data-ajax="true"
									data-ajax-method="GET" data-ajax-mode="replace"
									data-ajax-update="#bookUpdate"
									href="/book-by-category/khoa-hoc/1/2">2</a></li>
								<li class="page-item PagedList-skipToNext"><a
									class="page-link" data-ajax="true" data-ajax-method="GET"
									data-ajax-mode="replace" data-ajax-update="#bookUpdate"
									href="/book-by-category/khoa-hoc/1/2" rel="next">&gt;</a></li>
							</ul>
						</div>
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
									<li><a href="<c:url value="/sach-theo-the-loai/${ item.ID }"></c:url>">${ item.name }</a></li>
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