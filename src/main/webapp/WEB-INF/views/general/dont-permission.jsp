<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var='home' value='/' />


<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>404 not found</title>
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
	</head>
	<body style="overflow-x: hidden; height: 100vh"
		class="d-flex justify-content-center align-items-center flex-column">
		<div class="fw-bolder" style="font-size:30px">OOPS! Không có quyền  truy cập</div>
		<div class="fw-bolder" style="font-size:120px">404</div>
		<a href="${home}" class="btn btn-primary border-0 round-0 rounded rounded-0" style="padding: 14px 50px !important;background-color: #87b106 !important">Home</a>
	</body>
<style>
</style>

</html>