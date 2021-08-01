<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="text-center">
	<div class="error mx-auto" data-text="ERROR">ERROR</div>
	<p class="lead text-gray-800 mb-5">${ error.message }</p>
	<p class="text-gray-500 mb-0">${ error.stackTrace }</p>
	<a href="<c:url value="/quan-tri/tong-quan"></c:url>">Quay về trang tổng quan</a>
</div>