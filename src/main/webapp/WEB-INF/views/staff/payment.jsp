<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<script defer="defer" src='<c:url value="/resources/javascript/payment.js"/>'></script>
<form method="post" class="container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Tạo thanh toán</h3>

	<div class="row gx-4 gy-4 mt-4">
		<div class="col-12 col-md-4 container-input"> 
				<label for="id-payment" class="form-label">Mã thanh toán </label>
				<input name="id-payment" type="text" required="required" class="ct-input" id="id-payment"/> 
		</div>
		<div class="col-12 col-md-4 container-input"> 
				<label for="date" class="form-label">Ngày ngày thanh toán</label>
				<input name="date" type="date" required="required" class="ct-input" id="date"/> 
		</div>	
		
		 <div class="col-12 col-md-4 container-input"> 
				<label for="supplier" class="form-label">Phương thức thanh toán</label>
				<select name="method" class="ct-input">	
					<option value="CASH">Tiền mặt</option>
					<option value="TRANSFER">Chuyển khoản</option>
				</select>
		</div> 
		
		<div class="col-12 col-md-4 container-input"> 
				<label for="amount" class="form-label">Số tiền thanh toán</label>
				<input name="amount" type="number" required="required" class="ct-input" id="amount"/> 
		</div>	
		
		<div class="col-12 mt-5 col-md-4 container-input">
			<button style="height: 46px" type="button" class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#exampleModal" data-bs-whatever="@mdo">Chọn phiếu xuất thanh toán</button>
		</div> 
		
		
		<div class="col-12 col-md-4 container-input"> 
				<label for="id-export" class="form-label">Mã Phiếu xuất</label>
				<input readonly name="id-export" type="text" required="required" class="ct-input" id="id-export"/> 
		</div>	
			
		
		
		
		
		<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5">Phiếu xuất chưa thanh toán</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="mt-4">
						<div class="row text-uppercase text-center mb-3"
							style="font-size: 13px">
							<div class="col-1">
								<p class="fw-bolder" style="color: #999999">#</p>
							</div>
							<div class="col-1">
								<p class="fw-bolder" style="color: #999999">Mã PX</p>
							</div>
							<div class="col-2">
								<p class="fw-bolder" style="color: #999999">Date</p>
							</div>
							<div class="col-4">
								<p class="fw-bolder" style="color: #999999">Đơn vị vận chuyển</p>
							</div>

							<div class="col-2">
								<p class="fw-bolder" style="color: #999999">Zip code</p>
							</div>
							
							<div class="col-1">
								<p class="fw-bolder" style="color: #999999">Mã DH</p>
							</div>
					

						</div>	
						</div>

						<c:forEach items="${exports}" var="export">
							<div class="row mt-3 align-items-center text-center">
								<div class="col-1">
									<a
										style="text-decoration: underline !important; color: blue !important"
										href='<c:url value='/staff/export/detail.htm?id=${export.getIdExport()}'/>'>
										Detail </a>
								</div>
								<div class="col-1">
									<p>${export.getIdExport()}</p>
								</div>

								<div class="col-2">
									<c:set var="myDate" value="${export.getDate()}" />
									<p>
										<fmt:formatDate value="${myDate}" pattern="dd-MM-yyyy"
											var="formattedDate" />
										${formattedDate}
									</p>
								</div>
								<div class="col-4">
									<p>${export.getInfoShipment()}</p>
								</div>

								<div class="col-2">
									<p>${export.getZipCode()}</p>
								</div>

								<div class="col-1">
									<p>${export.getOrder().getIdOrder()}</p>
								</div>
				

								<div class="col-1">
									<button data-bs-dismiss="modal" type="button" onclick="handleSubmit(event)" data-id-export="${export.getIdExport()}" class="btn btn-success">Chọn</button>
								</div>
							</div>
							<hr>
							
							
						</c:forEach>
					</div>
				</div>
			</div>

	</div>
		
		
		
		
		
</div>

<div class="w-100 mt-4">
			<button type="submit"
				class="btn btn-primary rounded-0 border-0 w-100"
				style="background-color: #87b106 !important">Tạo thanh toán
			</button>
		</div>
		
		<jsp:include page="/WEB-INF/views/general/notification.jsp" />
</form>





<jsp:include page="/WEB-INF/views/general/notification.jsp" />

<style>
	p {
		margin-bottom: 0px;
	}
</style>







