<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/views/layouts/user/breadcrumb.jsp" %>

<div class="checkout page">
	<div class="container">
		<div class="page-header">
			<h2 class="page-title">Danh sách thể loại</h2>
			<p class="page-subtitle"></p>
		</div>
		<!-- /.page-header -->

		<div class="page-body">
			<div class="panel-group" id="accordion">
				<c:forEach var="item" items="${ categories }">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseCase2_${ item.ID }" aria-expanded="false" class="collapsed">
									<span class="step">+</span>${ item.name }
								</a>
							</h4>
						</div>
						<!-- /.panel-heading -->

						<div id="collapseCase2_${ item.ID }" class="panel-collapse collapse"
							aria-expanded="false" style="height: 0px;">
							<div class="panel-body">
								<div class="row">
									<p>${ item.description }</p>
									<a class="btn btn-success"
										href="<c:url value="/sach-theo-the-loai/${ item.ID }"></c:url>">Truy cập vào thể
										loại</a>
								</div>
								<!-- /.row -->
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel-collapse -->
					</div>
					<!-- /.panel -->
				</c:forEach>
			</div>
			<!-- /.panel-group -->
		</div>
		<!-- /.page-body -->
	</div>
	<!-- /.container -->
</div>