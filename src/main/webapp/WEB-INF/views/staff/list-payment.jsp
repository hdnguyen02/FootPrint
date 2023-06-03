<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<div class="container-fluid p-5 bg-white shadow-lg" style="min-height: 100vh">
	<div class="row align-items-center mb-5">
		<h3 class="fs-5 col-5 mb-0">Danh sách thanh toán</h3> 
		<div class="row col-5">
			<div class="col-6"> 
				<span>Từ :</span> 
				<input name="from" value="${from}" type="date" class=""/>
			</div>
			<div class="col-6"> 
				<span>Đến :</span> 
				<input name="to" value="${to}" type="date" class=""/>
			</div>
		</div>

		<div class="col-2">
			<button class="btn btn-primary w-100">Lọc</button>
		</div>
	</div>
	

	<div class="mt-4">
		<div class="row text-uppercase text-center mb-3" style="font-size: 13px">
			<div class="col-1">
				<p class="fw-bolder" style="color: #999999">Mã</p>
			</div>
			<div class="col-2">
				<p class="fw-bolder" style="color: #999999">Ngày</p>
			</div>
			<div class="col-1">
				<p class="fw-bolder" style="color: #999999">method</p>
			</div>
			
			<div class="col-2">
				<p class="fw-bolder" style="color: #999999">Số tiền</p>
			</div>
			<div class="col-1">
				<p class="fw-bolder" style="color: #999999">Mã PX</p>
			</div>

			<div class="col-3">
				<p class="fw-bolder" style="color: #999999">Nhân viên tạo phiếu</p>
			</div>

		</div>
		
		<c:forEach items="${payments}" var="payment">
			<div class="row mt-3 align-items-center text-center">
				<div class="col-1">
					<p>${payment.getIdPayment()}</p>
				</div>
				<div class="col-2">
					<c:set var="myDate" value="${payment.getDate()}" />
					<p>
						<fmt:formatDate value="${myDate}" pattern="dd-MM-yyyy"
							var="formattedDate" />
						${formattedDate}
					</p>

				</div>
				
			<%-- 	<div class="col-1">
					<p>${payment.getExport().getIdExport()}</p>
				</div> --%>
		

				<div class="col-1">
					<p>${payment.getMethod()}</p>
				</div>
				<div class="col-2">
					<p>${payment.getAmount()}</p>
				</div>
				<div class="col-1">
					<p>${payment.getExport().getIdExport()}</p>
				</div>


				<div class="col-3">
					<p>${payment.getEmployee().getFirstName()} ${payment.getEmployee().getLastName()}</p>
				</div>

				<div class="col-2">
					<a
						style="text-decoration: underline !important; color: blue !important"
						href='<c:url value='/staff/export/detail.htm?id=${payment.getExport().getIdExport()}'/>'>
						Detail Export</a>
				</div>
			</div>
			<hr>
		</c:forEach>

		
	</div>
</div>


<style>

p { 
 margin-bottom: 0px;
}

input { 
	outline: none;
	border: 1px solid #ccc;
	border-radius: 6px;
	height: 42px; 
	padding: 6px; 
}


</style>
