<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="cart page">
	<div class="container">
		<div class="page-header">
			<h2 class="page-title">Tìm kiếm</h2>
			<p class="page-subtitle">
				Đang tìm kiếm với từ khóa: <span class="text-success">${ keyword }</span>
			</p>
		</div>
		<!-- /.page-header -->

		<div class="page-body" id="searchContent">

			<div class="order-detail table-responsive">
				<table class="table table-cart cart-detail ">
					<thead>
						<tr>
							<th class="dark">Tên sách</th>
							<th>Lượt xem</th>
							<th>Lượt thích</th>
							<th>Lượt không thích</th>
							<th>Thể loại</th>
						</tr>
					</thead>
					<!-- /thead -->
					<tbody class="cart-body-content">

						<tr class="cart-book">
							<td style="width: 50%;">
								<div class="media">
									<a href="/book-details/5-phuong-trinh-lam-thay-doi-the-gioi/5"
										class="cart-thumbnail-image media-left">
										<div class="book-cover small-book-cover">

											<img
												src="/FileUpload/Images/2021/6/5-phuong-trinh-lam-thay-doi-the-gioi-michael-guillen-ph-d.jpg"
												alt="Thử nghiệm 3" class="media-object" width="72"
												height="99">
											<div class="fade"></div>
										</div>
									</a>
									<div class="media-body">
										<p class="media-heading" style="font-size: 16px;">
											<a
												href="/book-details/5-phuong-trinh-lam-thay-doi-the-gioi/5">5
												phương trình làm thay đổi thế giới</a>
										</p>
									</div>
								</div>
							</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>
								<p style="font-size: 16px">
									<a href="/book-by-category/khoa-hoc/1/1">Khoa học</a>
								</p>
							</td>
						</tr>
					</tbody>
					<!-- /.cart-body-content -->
				</table>
				<!-- /.table -->
			</div>
			<!-- /.order-detail -->

		</div>
		<!-- /.page-body -->
	</div>
	<!-- /.container -->
</div>