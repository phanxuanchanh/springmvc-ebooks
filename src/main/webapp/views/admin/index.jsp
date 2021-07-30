<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Trang quản trị/Danh s&#225;ch
		thể loại</h1>
	<a href="/admin/category-management/create"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
		<i class="fas fa-download fa-sm text-white-50"></i> Tạo mới
	</a>
</div>


<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Danh s&#225;ch thể
			loại</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable" class="dataTables_wrapper dt-bootstrap4">



				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered dataTable" id="dataTable"
							width="100%" cellspacing="0" role="grid"
							aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1" aria-sort="ascending">ID thể loại</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1" aria-sort="ascending">Tên thể
										loại</th>
									<th>Công cụ</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th rowspan="1" colspan="1">ID thể loại</th>
									<th rowspan="1" colspan="1">Tên thể loại</th>
									<th rowspan="1" colspan="1">Công cụ</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="item" items="${ categories }">
									<tr role="row">
										<td>${ item.ID }</td>
										<td>${ item.name }</td>
										<td><a href="/admin/category-management/edit/1">Chỉnh
												sửa</a> | <a href="/admin/category-management/details/1">Xem
												chi tiết</a> | <a href="/admin/category-management/delete/1">X&#243;a</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-5">
						<div class="dataTables_info" id="dataTable_info" role="status"
							aria-live="polite">Đang hiển thị 5 - Tối đa: 10/1 trang -
							Tổng số trang: 1</div>
					</div>
					<div class="col-sm-12 col-md-7">
						<div class="dataTables_paginate paging_simple_numbers"
							id="dataTable_paginate">
							<ul class="pagination">
								<div class="pagination-container">
									<ul class="pagination">
										<li class="page-itemm active"><span class="page-link">1</span></li>
									</ul>
								</div>
							</ul>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
</div>

