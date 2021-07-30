<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
										rowspan="1" colspan="1" aria-sort="ascending">T&#234;n
										thể loại</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1" aria-sort="ascending">Ng&#224;y
										tạo</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1" aria-sort="ascending">Ng&#224;y
										cập nhật</th>
									<th>Công cụ</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th rowspan="1" colspan="1">ID thể loại</th>
									<th rowspan="1" colspan="1">T&#234;n thể loại</th>
									<th rowspan="1" colspan="1">Ng&#224;y tạo</th>
									<th rowspan="1" colspan="1">Ng&#224;y cập nhật</th>
									<th rowspan="1" colspan="1">Công cụ</th>
								</tr>
							</tfoot>
							<tbody>
								<tr role="row">
									<td>1</td>
									<td>Khoa học</td>
									<td>5/29/2021 9:24:05 PM</td>
									<td>6/5/2021 3:00:51 PM</td>
									<td><a href="/admin/category-management/edit/1">Chỉnh
											sửa</a> | <a href="/admin/category-management/details/1">Xem
											chi tiết</a> | <a href="/admin/category-management/delete/1">X&#243;a</a>
									</td>
								</tr>
								<tr role="row">
									<td>3</td>
									<td>Văn học nước ngo&#224;i</td>
									<td>6/5/2021 3:02:37 PM</td>
									<td>6/5/2021 3:02:37 PM</td>
									<td><a href="/admin/category-management/edit/3">Chỉnh
											sửa</a> | <a href="/admin/category-management/details/3">Xem
											chi tiết</a> | <a href="/admin/category-management/delete/3">X&#243;a</a>
									</td>
								</tr>
								<tr role="row">
									<td>4</td>
									<td>Trinh th&#225;m</td>
									<td>6/21/2021 8:35:58 PM</td>
									<td>6/21/2021 8:35:58 PM</td>
									<td><a href="/admin/category-management/edit/4">Chỉnh
											sửa</a> | <a href="/admin/category-management/details/4">Xem
											chi tiết</a> | <a href="/admin/category-management/delete/4">X&#243;a</a>
									</td>
								</tr>
								<tr role="row">
									<td>5</td>
									<td>H&#236;nh sự</td>
									<td>6/21/2021 8:40:53 PM</td>
									<td>6/21/2021 8:56:22 PM</td>
									<td><a href="/admin/category-management/edit/5">Chỉnh
											sửa</a> | <a href="/admin/category-management/details/5">Xem
											chi tiết</a> | <a href="/admin/category-management/delete/5">X&#243;a</a>
									</td>
								</tr>
								<tr role="row">
									<td>7</td>
									<td>Văn học Việt Nam</td>
									<td>6/22/2021 9:06:35 PM</td>
									<td>6/22/2021 9:06:35 PM</td>
									<td><a href="/admin/category-management/edit/7">Chỉnh
											sửa</a> | <a href="/admin/category-management/details/7">Xem
											chi tiết</a> | <a href="/admin/category-management/delete/7">X&#243;a</a>
									</td>
								</tr>
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

