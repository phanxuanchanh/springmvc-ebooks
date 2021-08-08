<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />

<footer class="footer">
	<div class="main-footer">
		<div class="container">

			<!-- ============================================================= FOOTER NAVBAR ============================================================= -->
			<div class="navbar-footer navbar-static-bottom clearfix">
				<p class="navbar-text">
					Copyright &copy; ${ year } <span class="navbar-inner-text">EBooks</span>
				</p>
				<ul id="example" class="navbar-nav nav ">
					<li><a href="#">Về chúng tôi</a></li>
					<li><a href="#">Báo cáo lỗi</a></li>
					<li><a href="#">Tính năng</a></li>
					<li><a href="#">API</a></li>
					<li>
						<ul class="language-block">
							<li><select class="selectpicker">
									<option selected>VI</option>
							</select></li>
						</ul> <!-- /.language-block -->
					</li>
				</ul>
				<!-- /.navbar-nav -->
			</div>
			<!-- /.navbar -->
			<!-- ============================================================= FOOTER NAVBAR : END ============================================================= -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /.main-footer -->
</footer>
<!-- /.footer -->