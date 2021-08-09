<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Trang quản trị/Chi tiết sách</h1>
	<a href="<c:url value="/quan-tri/tao-moi-sach"></c:url>"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
		<i class="fas fa-download fa-sm text-white-50"></i> Tạo mới
	</a>
</div>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Chi tiết sách</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable" class="dataTables_wrapper dt-bootstrap4">
				<table class="table table-bordered table table-hover">
					<tbody>
						<tr>
							<th style="width: 25%;">ID sách</th>
							<td>${ bookInfo.ID }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Tên sách</th>
							<td>${ bookInfo.name }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Mô tả sách</th>
							<td>${ bookInfo.description }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Thể loại</th>
							<td><c:if test="${ bookInfo.category != null }">
								${ bookInfo.category.name }
								</c:if></td>
						</tr>
						<tr>
							<th style="width: 25%;">Nhà xuất bản</th>
							<td><c:if test="${ bookInfo.publishingHouse != null }">
								${ bookInfo.publishingHouse.name }
								</c:if></td>
						</tr>
						<tr>
							<th style="width: 25%;">Tác giả</th>
							<td>
								<ul>
									<c:forEach var="item" items="${ bookInfo.bookAuthorInfos }">
										<li>${ item.name } -- Vai trò: ${ item.roleName }</li>
									</c:forEach>
								</ul>
							</td>
						</tr>
						<tr>
							<th style="width: 25%;">Lượt xem</th>
							<td>${ bookInfo.views }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Lượt thích</th>
							<td>${ bookInfo.upvote }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Lượt không thích</th>
							<td>${ bookInfo.downvote }</td>
						</tr>
						<tr>
							<th style="width: 25%;">PDF</th>
							<td>${ bookInfo.pdf }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Hình ảnh</th>
							<td>${ bookInfo.img }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="card-footer">
		<a class="btn btn-primary"
			href="<c:url value="/quan-tri/chinh-sua-sach"></c:url>">Chỉnh sửa</a>
		| <a class="btn btn-success"
			href="<c:url value="/quan-tri/danh-sach-sach"></c:url>">Quay về
			danh sách</a>
	</div>
</div>