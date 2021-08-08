<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Outer Row -->
<div class="row justify-content-center">

	<div class="col-xl-10 col-lg-12 col-md-9">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
					<div class="col-lg-6">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Đăng ký</h1>
							</div>
							<c:url var="post_url" value="/tai-khoan/dang-ky"></c:url>
							<form:form method="POST" action="${ post_url }"
								modelAttribute="userRegister" cssClass="user">
								<div class="form-group">
									<form:input path="username"
										cssClass="form-control form-control-user"
										placeholder="Nhập vào tên người dùng..." />
									<form:errors path="username"
										cssClass="field-validation-valid text-danger" />
								</div>
								<div class="form-group">
									<form:input path="email"
										cssClass="form-control form-control-user" type="email"
										placeholder="Nhập vào địa chỉ email..." />
									<form:errors path="email"
										cssClass="field-validation-valid text-danger" />
								</div>
								<div class="form-group">
									<form:input path="password"
										cssClass="form-control form-control-user" type="password"
										placeholder="Nhập vào mật khẩu..." />
									<form:errors path="password"
										cssClass="field-validation-valid text-danger" />
								</div>
								<input type="submit" class="btn btn-primary btn-user btn-block"
									value="Đăng ký">
							</form:form>
							<hr>
							<div class="text-center">
								<a class="small" href="#">Quên mật khẩu?</a>
							</div>
							<div class="text-center">
								<a class="small"
									href="<c:url value="/tai-khoan/dang-nhap"></c:url>">Bạn đã có tài khoản? Đăng nhập</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<c:if test="${ state != null }">
		<script type="text/javascript">
			setTimeout(function(e){
				alert("${ state }");
			}, 1500);
		</script>
	</c:if>

</div>