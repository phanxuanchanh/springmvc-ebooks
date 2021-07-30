<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Trang quản trị/Chi tiết thể loại</h1>
	<a href="/admin/category-management/create"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
		<i class="fas fa-download fa-sm text-white-50"></i> Tạo mới
	</a>
</div>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Chi tiết thể loại</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable" class="dataTables_wrapper dt-bootstrap4">
				<table class="table table-bordered table table-hover">
					<tbody>
						<tr>
							<th style="width: 25%;">ID thể loại</th>
							<td>${ category.ID }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Tên thể loại</th>
							<td>${ category.name }</td>
						</tr>
						<tr>
							<th style="width: 25%;">Mô tả thể loại</th>
							<td>${ category.description }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="card-footer">
		<a class="btn btn-primary" href="/admin/category-management/edit/1">Chỉnh
			sửa</a> | <a class="btn btn-success"
			href="/admin/category-management/list">Quay về danh sách</a>
	</div>
</div>