<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Trang quản trị/Tạo mới thể loại</h1>
	<a href="/admin/category-management/create"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
		<i class="fas fa-download fa-sm text-white-50"></i> Tạo mới
	</a>
</div>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Tạo mới thể loại</h6>
	</div>
	<div class="card-body">
		<form:form method="POST" action="tao-moi-the-loai"
			modelAttribute="category">
			<div class="form-horizontal">

				<div class="form-group">
					<label class="control-label" for="name">Tên thể loại</label>
					<div>
						<form:input path="name"
							cssClass="form-control text-box single-line" />
						<span class="field-validation-valid text-danger"
							data-valmsg-for="name" data-valmsg-replace="true"></span>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label" for="description">Mô tả thể
						loại</label>
					<div>
						<form:textarea path="description" cssClass="form-control" />
						<span class="field-validation-valid text-danger"
							data-valmsg-for="name" data-valmsg-replace="true"></span>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-offset-2 col-md-10">
						<input type="submit" value="Tạo mới" class="btn btn-success">
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<div class="card-footer">
		<a class="btn btn-primary"
			href="<c:url value="danh-sach-the-loai"></c:url>">Quay về danh
			sách</a>
	</div>
</div>