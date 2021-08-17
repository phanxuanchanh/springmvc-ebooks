<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/views/layouts/user/breadcrumb.jsp"%>

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
						<c:forEach var="item" items="${ booksByKeyword }">
							<tr class="cart-book">
								<td style="width: 50%;">
									<div class="media">
										<a href="<c:url value="/chi-tiet-sach/${ item.ID }"></c:url>"
											class="cart-thumbnail-image media-left">
											<div class="book-cover small-book-cover">

												<img
													src="<c:url value="/file-upload/images/${ item.img }"></c:url>"
													alt="${ item.name }" class="media-object" width="72"
													height="99">
												<div class="fade"></div>
											</div>
										</a>
										<div class="media-body">
											<p class="media-heading" style="font-size: 16px;">
												<a
													href="<c:url value="/chi-tiet-sach/${ item.ID }"></c:url>">${ item.name }</a>
											</p>
										</div>
									</div>
								</td>
								<td>${ item.views }</td>
								<td>${ item.upvote }</td>
								<td>${ item.downvote }</td>
								<td>
									<p style="font-size: 16px">
										<a href="<c:url value="/sach-theo-the-loai/${ item.category.ID }"></c:url>">${ item.category.name }</a>
									</p>
								</td>
							</tr>
						</c:forEach>
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