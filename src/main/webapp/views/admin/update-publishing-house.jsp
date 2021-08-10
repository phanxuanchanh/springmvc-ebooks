<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Trang quản trị/Chỉnh sửa nhà xuất bản</h1>
	<a href="<c:url value="/quan-tri/tao-moi-nha-xuat-ban"></c:url>"
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
					<div><a class="text-white-50 small" href="<c:url value="/quan-tri/chinh-sua-nha-xuat-ban/${ publishingHouse.ID }"></c:url>">Tắt thông báo này</a></div>
				</div>
			</div>
		</c:if>
	</div>
</div>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Chỉnh sửa nhà xuất bản "${ publishingHouse.name }"</h6>
	</div>
	<div class="card-body">
		<c:url var="post_url" value="/quan-tri/chinh-sua-nha-xuat-ban/${ publishingHouse.ID }"></c:url>
		<form:form method="POST" action="${ post_url }"
			modelAttribute="publishingHouse">
			<div class="form-horizontal">
				
				<form:hidden path="ID"/>
				<div class="form-group">
					<label class="control-label" for="name">Tên nhà xuất bản</label>
					<div>
						<form:input path="name"
							cssClass="form-control text-box single-line" />
							<form:errors path="name" cssClass="field-validation-valid text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label" for="description">Mô tả nhà xuất bản</label>
					<div>
						<form:textarea path="description" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label" for="name">Email nhà xuất bản</label>
					<div>
						<form:input path="email"
							cssClass="form-control text-box single-line" />
							<form:errors path="email" cssClass="field-validation-valid text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label" for="name">Địa chỉ nhà xuất bản</label>
					<div>
						<form:input path="address"
							cssClass="form-control text-box single-line" />
							<form:errors path="address" cssClass="field-validation-valid text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-offset-2 col-md-10">
						<input type="submit" value="Chỉnh sửa" class="btn btn-success">
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<div class="card-footer">
		<a class="btn btn-primary"
			href="<c:url value="/quan-tri/danh-sach-nha-xuat-ban"></c:url>">Quay về danh
			sách</a>
		<a class="btn btn-primary"
			href="<c:url value="/quan-tri/chi-tiet-nha-xuat-ban/${ publishingHouse.ID }"></c:url>">Xem chi tiết</a>
	</div>
</div>