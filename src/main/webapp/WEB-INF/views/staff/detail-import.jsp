<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- <script defer="defer"
	src='<c:url value="/resources/javascript/export-product.js"/>'></script> --%>

<div class="container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Chi tiết phiếu nhập hàng</h3>
	<div class="row gx-4 gy-4 mt-4">
		<div class="col-12 col-md-3 container-input"> 
				<label for="id-import" class="fw-bold">Mã đơn nhập hàng</label>
				<span class="fs-5">${importEntity.getIdImport()}</span>
		</div>
		
		
		
		<div class="col-12 col-md-3 container-input"> 
		
				<c:set var="myDate" value="${importEntity.getDate()}" />
					<p>
						<fmt:formatDate value="${myDate}" pattern="dd-MM-yyyy"
							var="formattedDate" />

					</p>
				<label for="date" class="fw-bold">Ngày nhập hàng</label>
				<span class="fs-5">${formattedDate}</span>
		</div>	
		<div class="col-12 col-md-3 container-input"> 
				<label class="fw-bold">Nhà cung cấp</label>
				<span class="fs-5">${importEntity.getSupplier()}</span>
		</div>
			<div class="col-12 col-md-3 container-input"> 
				<label class="fw-bold">Nhân viên tạo phiếu</label>
				<span class="fs-5">${importEntity.getEmployee().getFirstName()} ${importEntity.getEmployee().getLastName()}</span>
		</div>
		<%--  <div class="col-12 col-md-4 container-input"> 
				<label for="supplier" class="form-label">Nhà cung cấp</label>
				<input name="supplier" value="${importEntity.getSupplier()}" type="text" class="ct-input" id="supplier"/> 
		</div>  --%>
		
		
		
		
		<!-- <div>Chi tiết phiếu nhập</div> -->
		<div class="container-product row gx-3 mt-5"> 
	        		<div class="col-1" style=""><p class="ms-1" style="line-height: 32px">Mã</p></div>
	        		<div class="col-4"><p class="fw-bold" style="line-height: 32px">Tên sản phẩm</p></div>
	        		<div class="col-1"><p class="fw-bold" class="ms-1" style="line-height: 32px">Size</p></div>
	        		<div class="col-1"><p class="fw-bold" class="ms-1" style="line-height: 32px">Tồn kho</p></div>
	        		<div class="col-1"><p class="fw-bold" class="ms-1" style="line-height: 32px">Màu</p></div>
	        		<div class="col-1"><p class="fw-bold" class="ms-1" style="line-height: 32px">Disable</p></div>
	        		<div class="col-1"><p class="fw-bold" class="ms-2" style="line-height: 32px">SL nhập</p></div>
	        		<div class="col-2"><p class="fw-bold" class="ms-2" style="line-height: 32px">Giá nhập</p></div>
	      </div>
	      <hr>
		
		<div data-detail-import class="col-12 container-input"> 
		
			 <c:forEach var="importDetail" items="${importEntity.getImportDetails()}">
	        	<div class="container-product row gx-3 mt-3"> 
	        		<div class="col-1"><p style="line-height: 32px">${importDetail.getProduct().getIdProduct()}</p></div>
	        		<div class="col-4"><p style="line-height: 32px">${importDetail.getProduct().getName()}</p></div>
	        	<!-- 	<div class="col-1"><p style="line-height: 32px">$${product.getCost()}</p></div>  -->
	        		
	        		<div class="col-1"><p style="line-height: 32px">${importDetail.getProduct().getSize()}</p></div>
	        		<div class="col-1"><p style="line-height: 32px">${importDetail.getProduct().getQuantity()}</p></div>
	       
	        		<div class="col-1"><p style="line-height: 32px">${importDetail.getProduct().getColor()}</p></div>
	        		<div class="col-1"><p style="line-height: 32px">${importDetail.getProduct().getDisable()}</p></div>
	        		<div class="col-1"><p class="ms-2" style="line-height: 32px">${importDetail.getQuantity()}</p></div>
	        		<div class="col-2"><p class="ms-2" style="line-height: 32px">${importDetail.getCost()}</p></div>
	        	
	        	</div>
	        	<hr>
	        </c:forEach>
			
		</div>
		

		
		
		
	</div>
	
	







</div>

<style>
p {
	margin-bottom: 0px;
}
</style>








