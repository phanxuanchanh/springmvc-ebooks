<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Trang quản trị/Thêm tác giả cho
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
							href="<c:url value="/quan-tri/tac-gia-cua-sach/${bookInfo.ID}"></c:url>">Tắt
							thông báo này</a>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Thêm tác giả cho sách "${ bookInfo.name }"</h6>
	</div>
	<div class="card-body">
		<c:url var="post_url" value="/quan-tri/them-tac-gia-cua-sach"></c:url>
		<form:form method="POST" action="${ post_url }" modelAttribute="authorContribute">
			<div class="form-horizontal">

				<input type="hidden" name="bookId" value="${ bookInfo.ID }" />
				<div class="form-group">
					<label class="control-label" for="bookAuthorId">Chọn tác giả</label>
					<div>
						<select name="bookAuthorId" id="bookAuthorId" class="form-control">
							<c:forEach var="item" items="${ bookAuthors }">
								<option value="${ item.ID }">${ item.name }</option>
							</c:forEach>
						</select>
						<form:errors path="bookAuthorId" cssClass="field-validation-valid text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label" for="name">Vai trò cụ thể</label>
					<div>
						<form:input path="role"
							cssClass="form-control text-box single-line" />
							<form:errors path="role" cssClass="field-validation-valid text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-offset-2 col-md-10">
						<input type="submit" value="Thêm tác giả" class="btn btn-success">
					</div>
				</div>
			</div>
		</form:form>

		<h6 class="m-0 font-weight-bold text-primary">Tác giả hiện tại
			của sách</h6>

		<div class="table-responsive">
			<div id="dataTable" class="dataTables_wrapper dt-bootstrap4">
				<table class="table table-bordered table table-hover">
					<tbody>
						<c:forEach var="item" items="${ bookInfo.bookAuthorInfos }">
						<tr>
							<th style="width: 25%;">Tác giả</th>
							<td>${ item.name }</td>
							<td>Vai trò cụ thể: ${ item.roleName }</td>
						</tr>
						</c:forEach>
						<tr>
							<th style="width: 25%;">Xóa tác giả</th>
							<td><c:url var="post_url" value="/quan-tri/xoa-tat-ca-tac-gia-cua-sach"></c:url>
								<form:form id="deleteBookAuthor" method="POST"
									action="${ post_url }">
									<input type="hidden" name="id" value="${ bookInfo.ID }" />
									<button type="submit" class="btn btn-danger">Xóa</button>
								</form:form></td>
							<td></td>
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
			href="<c:url value="/quan-tri/chi-tiet-sach/${ bookInfo.ID }"></c:url>">Xem chi tiết</a>
		<a class="btn btn-success"
			href="<c:url value="/quan-tri/chinh-sua-sach/${ bookInfo.ID }"></c:url>">Chỉnh sửa</a>
		<a class="btn btn-success"
			href="<c:url value="/quan-tri/hinh-anh-cua-sach/${ bookInfo.ID }"></c:url>">Hình ảnh</a>
		<a class="btn btn-success"
			href="<c:url value="/quan-tri/pdf-cua-sach/${ bookInfo.ID }"></c:url>">PDF</a>
	</div>
</div>