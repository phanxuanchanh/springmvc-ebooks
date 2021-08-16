<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="breadcrumb-container">
	<div class="container">
		<ul class="breadcrumb pull-left">
			<li><a href="#">Hiện tại chúng tôi đang có ${ bookNumber }
					sách điện tử</a></li>
		</ul>
		<!-- /.breadcrumb -->
		<!-- ========================================= BREADCRUMB SEARCH BOX ========================================= -->
		<ul class="list-unstyled search-box pull-right">
			<li data-target="#search" data-toggle="sub-header">
				<button type="button" class="btn btn-primary-dark search-button">
					<i class="fa fa-search icon"></i>
				</button>
				<div class="row search-action sub-header" id="search">
					<form action="<c:url value="/tim-kiem-sach"></c:url>" method="get">
						<div class="col-sm-8 col-xs-12 no-padding-right">
							<div class="input-group">
								<span class="input-group-btn"><button
										class="btn btn-search" type="button">
										<i class="fa fa-search icon"></i>
									</button></span> <input type="text" name="keyword"
									class="form-control search-book" placeholder="Tìm kiếm sách...">
							</div>
							<!-- /.input-group -->
						</div>
						<!-- /.col -->
						<div class="select-wrapper col-sm-4" style="padding: 0px;">
							<div class="btn-group bootstrap-select">
								<select name="categoryId" class="selectpicker" tabindex="-98">
									<option value="all" selected="">Tất cả thể loại</option>
								</select>
							</div>
						</div>
						<!-- /.col -->
					</form>
				</div> <!-- /.row -->
			</li>
		</ul>
		<!-- /.search-box -->
		<!-- ========================================= BREADCRUMB SEARCH BOX : END ========================================= -->

	</div>
	<!-- /.container -->
</div>
