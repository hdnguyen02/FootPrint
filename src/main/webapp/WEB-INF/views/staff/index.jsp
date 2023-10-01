<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<div class="container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Tổng quan</h3>

	<div class="row gx-4 gy-4 mt-4">
		<div class="col-12 col-md-6">   
			<div class="d-flex align-items-center shadow-lg justify-content-between px-4" style="height: 80px">
				<div class="d-flex align-items-center gap-3">
					<span><i class="fas fa-pencil-alt fs-1" style="color: #33b5ee"></i></span>
					<span class="fs-4">Số lượng sản phẩm</span>
				</div>
				<span class="fs-4">${sizeProducts}</span>
			</div>
			
			
			
		</div>
		<div class="col-12 col-md-6">   
			<div class="d-flex align-items-center shadow-lg justify-content-between px-4" style="height: 80px">
				<div class="d-flex align-items-center gap-3">
					<span><i class="fas fa-viruses fs-1" style="color: #f6a828"></i></span>
					<span class="fs-4">Số lượng loại sản phẩm</span>
				</div>
				<span class="fs-4">${sizeCategorys}</span>
			</div>
		</div>
		
		
		
		<div class="col-12 col-md-6">   
			<div class="d-flex align-items-center shadow-lg justify-content-between px-4" style="height: 80px">
				<div class="d-flex align-items-center gap-3">
					<span><i class="bi bi-balloon-heart-fill fs-1" style="color: #f56876"></i></span>
					<span class="fs-4">Đơn đặt hàng trong ngày</span>
				</div>
				<span class="fs-4">${sizeOrderDate}</span>
			</div>
		</div>
		
		<div class="col-12 col-md-6">   
			<div class="d-flex align-items-center shadow-lg justify-content-between px-4" style="height: 80px">
				<div class="d-flex align-items-center gap-3">
					<span><i class="bi bi-calendar-date fs-1"></i></span>
					<span class="fs-4">Số phiếu xuất trong ngày</span>
				</div>
				<span class="fs-4">${sizeExportDate}</span>
			</div>
		</div>

		

	</div>

	
</div>








