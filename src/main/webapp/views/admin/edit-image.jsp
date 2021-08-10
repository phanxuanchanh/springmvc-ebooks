<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Trang quản trị/Thêm hình ảnh cho
		sách</h1>
	<a href="<c:url value="/quan-tri/tao-moi-sach"></c:url>"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
		<i class="fas fa-download fa-sm text-white-50"></i> Tạo mới
	</a>
</div>

<div class="row">
	<div class="col-lg-12 mb-4">
		<c:if test="${ state != null }">
			<div class="card bg-secondary text-white shadow">
				<div class="card-body">
					${ state }
					<div>
						<a class="text-white-50 small"
							href="<c:url value="/quan-tri/hinh-anh-cua-sach/${ book.ID }"></c:url>">Tắt
							thông báo này</a>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Thêm hình ảnh cho
			sách "${ book.name }"</h6>
	</div>
	<div class="card-body">
		<c:url var="post_url" value="/quan-tri/them-hinh-anh-cua-sach"></c:url>
		<form:form method="POST" action="${ post_url }" modelAttribute="imageUpload"
			enctype="multipart/form-data">
			<div class="form-horizontal">

				<form:hidden path="bookId"/>
				<div class="form-group">
					<label class="control-label" for="commonsMultipartFile">Chọn hình ảnh</label>
					<div>
						<input type="file" id="commonsMultipartFile" name="commonsMultipartFile" class="form-control"> 
						<form:errors path="commonsMultipartFile" cssClass="field-validation-valid text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-offset-2 col-md-10">
						<input type="submit" value="Thêm hình ảnh" class="btn btn-success">
					</div>
				</div>
			</div>
		</form:form>

		<h6 class="m-0 font-weight-bold text-primary">Hình ảnh hiện tại
			của sách</h6>

		<div class="table-responsive">
			<div id="dataTable" class="dataTables_wrapper dt-bootstrap4">
				<table class="table table-bordered table table-hover">
					<tbody>
						<tr>
							<th style="width: 25%;">Hình ảnh</th>
							<td><img
								src="<c:url value="/file-upload/images/${ book.img }"></c:url>"
								width="145" height="232" /></td>
						</tr>
						<tr>
							<th style="width: 25%;">Xóa hình ảnh</th>
							<td><c:url var="post_url" value="/quan-tri/xoa-hinh-anh-cua-sach"></c:url>
								<form:form id="deleteBookImage" method="POST"
									action="${ post_url }">
									<input type="hidden" name="id" value="${ book.ID }" />
									<button type="submit" class="btn btn-danger">Xóa</button>
								</form:form></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<div class="card-footer">
		<a class="btn btn-primary"
			href="<c:url value="/quan-tri/danh-sach-sach"></c:url>">Quay về
			danh sách</a>
		<a class="btn btn-primary"
			href="<c:url value="/quan-tri/chi-tiet-sach/${ book.ID }"></c:url>">Xem chi tiết</a>
		<a class="btn btn-success"
			href="<c:url value="/quan-tri/chinh-sua-sach/${ book.ID }"></c:url>">Chỉnh sửa</a>
		<a class="btn btn-success"
			href="<c:url value="/quan-tri/pdf-cua-sach/${ book.ID }"></c:url>">PDF</a>
		<a class="btn btn-success"
			href="<c:url value="/quan-tri/tac-gia-cua-sach/${ book.ID }"></c:url>">Tác giả</a>
	</div>
</div>