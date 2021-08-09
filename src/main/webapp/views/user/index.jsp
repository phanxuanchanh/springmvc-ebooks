<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="home page">

	<!-- .slider -->
	<div class="slider">
		<!-- ========================================== SECTION – HERO : END========================================= -->
		<div id="hero">
			<div id="owl-main" class="owl-carousel owl-theme">
				<c:forEach var="item" items="${ latestBooks }" begin="0" end="2">
					<div class="item">
						<div class="container">
							<div class="content caption">
								<div class="row">
									<div class="col-sm-5 col-sm-push-7">
										<div class="book-in-shelf">
											<div class="book-shelf">
												<div class="add-to-cart-action hidden-xs hidden-sm">
													<a href="#" class="add-to-cart-button"><img
														src="<c:url value="/assets/user/images/shopping-cart.png"></c:url>" alt="" /></a>
												</div>
												<!-- /.add-to-cart-action-->
												<div class="book-cover slider-book-cover">
													<img class="img-responsive" alt="${ item.name }"
														src="<c:url value="/file-upload/images/${ item.img }"></c:url>"
														width="258" height="351">
													<div class="fade"></div>
												</div>
												<!-- /.book-cover -->
											</div>
											<!-- /.book-shelf -->
										</div>
										<!-- /.book-in-shelf -->
									</div>
									<!-- /.col -->

									<div class="col-sm-7 col-sm-pull-5">
										<div class="clearfix slider-caption">
											<div class="slider-caption-heading">
												<h1 class="slider-caption-title fadeInDown-1">${ item.name }</h1>
												<p class="slider-caption-subtitle fadeInDown-2 hidden-xs">
												Nhấn truy cập ngay để xem nội dung
												</p>
											</div>
											<!-- /.slider-caption-heading -->
											<div class="clearfix slider-price fadeInDown-3 hidden-xs">
												<a class="btn btn-secondary btn-price"
													href="/book-details/5-phuong-trinh-lam-thay-doi-the-gioi/5">Truy
													cập ngay</a>
											</div>
											<!-- /.slider-price -->
										</div>
										<!-- /.slider-caption -->
									</div>
									<!-- /.col -->


								</div>
								<!-- /.row -->

							</div>
							<!-- /.content.caption -->
						</div>
						<!-- /.container -->
					</div>
					<!-- /.item -->
				</c:forEach>
			</div>
			<!-- /#owl-main -->

			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="slider-action">
							<div class="row sub-header" id="search">
								<div class='col-md-12'>
									<div class="row">
										<form action="/search" method="get">
											<div class="col-sm-8 no-padding-right">
												<div class="input-group">
													<span class="input-group-btn"><button
															class="btn btn-search" type="button">
															<i class="fa fa-search icon"></i>
														</button></span> <input type="text" name="input"
														class="form-control search-book"
														placeholder="Tìm kiếm sách...">
												</div>
												<!-- /.input-group -->
											</div>
											<!-- /.col -->
											<div class="select-wrapper col-sm-4" style="padding: 0px;">
												<select name="categoryId" class="selectpicker">
													<option value="all" selected>Tất cả thể loại</option>
												</select>
											</div>
											<!-- /.col -->
										</form>
									</div>
									<!-- /.row -->
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->
						</div>
						<!-- /.slider-action -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container -->

		</div>

	</div>
	<!-- /.slider -->
	<!-- /.slider -->


	<div class="container">
		<!-- .block-new-books -->
		<!-- ========================================= NEW BOOKS MODULE ========================================= -->

		<div class="wow fadeInUp">
			<div class="module block-new-books module-block">
				<div class="module-heading">
					<h2 class="module-title">Sách mới nhất</h2>
					<div class="customNavigation">
						<a href="#" data-target="#new-carousel"
							class="btn btn-navigation left-nav-arrow owl-prev"><i
							class='icon fa fa-caret-left'></i></a> <a href="#"
							data-target="#new-carousel"
							class="btn btn-navigation right-nav-arrow owl-next"><i
							class='icon fa fa-caret-right'></i></a>
					</div>
					<!-- /.customNavigation -->
					<p class="module-subtitle">Những sách mới được tải lên</p>
				</div>
				<!-- /.module-heading -->

				<div class="module-body">
					<div class="books">

						<div id="new-carousel" class="owl-carousel home-owl-carousel">
							<c:forEach var="item" items="${ latestBooks }">
								<div class="item item-carousel">
									<div class="books">

										<div class="book">
											<div class="sale-ribbon">
												<div class="sale-ribbon-content">Mới nhất</div>
											</div>
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
													<a href="<c:url value="/chi-tiet-sach/${ item.ID }"></c:url>">${ item.name }</a>
												</h3>
												<div class="star-rating">
													<i class="fa fa-star color"></i> <i
														class="fa fa-star color"></i> <i class="fa fa-star color"></i><i
														class="fa fa-star color"></i> <i class="fa fa-star color"></i>
												</div>
												<!-- /.star-rating -->

											</div>
											<!-- /.book-details -->
										</div>
										<!-- /.book -->

									</div>
									<!-- /.books -->
								</div>
								<!-- /.item -->
							</c:forEach>
						</div>
						<!-- /#new-carousel -->
					</div>
					<!-- /.books -->
				</div>
				<!-- /.module-body -->
			</div>
			<!-- /.module -->
		</div>
		<!-- /.row -->

		<!-- ========================================= NEW BOOKS MODULE : END ========================================= -->
		<!-- /.block-new-books -->
		<!-- .block-best-sellers -->
		<!-- ========================================= BEST SELLER MODULE ========================================= -->

		<div class="wow fadeInUp">
			<div class="module block-best-sellers module-block">
				<div class="module-heading">
					<h2 class="module-title">Sách được xem nhiều nhất</h2>
					<div class="customNavigation">
						<a href="#" data-target="#seller-carousel"
							class="btn btn-navigation left-nav-arrow-seller owl-prev"><i
							class='icon fa fa-caret-left'></i></a> <a href="#"
							data-target="#seller-carousel"
							class="btn btn-navigation right-nav-arrow-seller owl-next"><i
							class='icon fa fa-caret-right'></i></a>
					</div>
					<!-- /.customNavigation -->
					<p class="module-subtitle">Những quyển sách có lượt xem cao
						nhất</p>
				</div>
				<!-- /.module-heading -->

				<div class="module-body">
					<div class="books">

						<div id="seller-carousel" class="owl-carousel home-owl-carousel">
							<c:forEach var="item" items="${ booksByViews }">
								<div class="item item-carousel">

									<div class="book">
										<div class="sale-ribbon">
											<div class="sale-ribbon-content">Phổ biến</div>
										</div>
										<div class="book-cover">
											<div class="book-inner">

												<img
													src="<c:url value="/file-upload/images/${ item.img }"></c:url>"
													width="193" height="261" alt="${ item.name }">
												<div class="fade"></div>
												<div class="book-price">

													<span class="price"> <span
														class="price-before-discount"> <a
															href="<c:url value="/chi-tiet-sach/${item.ID }"></c:url>">Xem
																ngay</a>
													</span>
													</span>
												</div>
												<!-- /.book-price -->
											</div>
											<!-- /.book-inner -->
										</div>
										<!-- /.book-cover -->


										<div class="book-details">
											<h3 class="book-title" style="font-size: 16px;">
												<a href="<c:url value="/chi-tiet-sach/${item.ID }"></c:url>">${ item.name }</a>
											</h3>
											<div class="star-rating">
												<i class="fa fa-star color"></i> <i class="fa fa-star color"></i>
												<i class="fa fa-star color"></i> <i class="fa fa-star color"></i>
												<i class="fa fa-star color"></i>
											</div>
											<!-- /.star-rating -->

										</div>
										<!-- /.book-details -->
									</div>
									<!-- /.book -->

								</div>
								<!-- /.item -->
							</c:forEach>
						</div>
						<!-- /#seller-carousel -->
					</div>
					<!-- /.books -->
				</div>
				<!-- /.module-body -->
			</div>
			<!-- /.module -->
		</div>
		<!-- /.row -->

		<!-- ========================================= BEST SELLER MODULE : END ========================================= -->
		<!-- /.block-best-sellers -->
	</div>
	<!-- /.container -->
</div>
<!-- /.home-page -->
