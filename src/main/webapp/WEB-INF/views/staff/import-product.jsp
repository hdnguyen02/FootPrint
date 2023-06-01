<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<script defer="defer" src='<c:url value="/resources/javascript/import-product.js"/>'></script>
<form method="post" class="container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Nhập hàng</h3>

	<div class="row gx-4 gy-4 mt-4">
		<div class="col-12 col-md-4 container-input"> 
				<label for="id-import" class="form-label">Mã đơn nhập hàng</label>
				<input name="id-import" type="text" required="required" class="ct-input" id="id-import"/> 
		</div>
		<div class="col-12 col-md-4 container-input"> 
				<label for="date" class="form-label">Ngày nhập hàng</label>
				<input name="date" type="date" required="required" class="ct-input" id="date"/> 
		</div>	
		
		<div class="col-12 col-md-4 container-input"> 
				<label for="nv" class="form-label">Nhân viên tạo đơn nhập hàng</label>
				<input name="id-employee" value="1" type="text" readonly="readonly" class="ct-input" id="nv"/> 
		</div>
		
		<div class="col-4 col-md-4 container-input"> 	
<!-- 				<span class="d-inline me-5">Chi tiết đơn nhập hàng</span> -->
				<button type="button" class="btn btn-primary"  data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">Chọn sản phẩm</button>			
				
		</div>
		
		<div class="col-4 col-md-4 container-input"> 
<!-- 				<span class="d-inline me-5">Chi tiết đơn nhập hàng</span> -->
				<button class="btn btn-primary">Submit</button>			
				
		</div>
		
		<div data-detail-import class="col-12 container-input"> 
			
		</div>
		
		
		
	</div>
	
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-xl">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5">Sản phẩm</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      
	      <div class="container-product row gx-3 mt-3"> 
	        		<div class="col-2"><p style="line-height: 32px">Mã</p></div>
	        		<div class="col-4"><p style="line-height: 32px">Tên</p></div>
	        		<div class="col-1"><p style="line-height: 32px">Giá</p></div> 
	        		<div class="col-1"><p style="line-height: 32px">Size</p></div>
	        		<div class="col-1"><p style="line-height: 32px">Số lượng</p></div>
	        		<div class="col-1"><p style="line-height: 32px">Màu</p></div>
	        		<div class="col-1"><p style="line-height: 32px">Disable</p></div>
	        		<div class="col-1"><p style="line-height: 32px">Check</p></div>
	        	</div>
	        	<hr>
	        
	        <c:forEach var="product" items="${products}">
	        	<div class="container-product row gx-3 mt-3" data-product="${product.getIdProduct()}"> 
	        		<div class="col-2"><p style="line-height: 32px">${product.getIdProduct()}</p></div>
	        		<div class="col-4"><p style="line-height: 32px">${product.getName()}</p></div>
	        		<div class="col-1"><p style="line-height: 32px">$${product.getCost()}</p></div> 
	        		<div class="col-1"><p style="line-height: 32px">${product.getSize()}</p></div>
	        		<div class="col-1"><p style="line-height: 32px">${product.getQuantity()}</p></div>
	        		<div class="col-1"><p style="line-height: 32px">${product.getColor()}</p></div>
	        		<div class="col-1"><p style="line-height: 32px">${product.getDisable()}</p></div>
	        		<div style="padding-top: 6px" class="col-1">
	        			<input name="products-import" value="${product.getIdProduct()}" type="checkbox">
	        		</div>
	        	</div>
	        	<hr>
	        </c:forEach>
	        
	       
	      </div>
	      <div class="modal-footer border-top-0">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
	        <button data-submit data-bs-dismiss="modal" type="button" class="btn btn-primary">Cập nhập</button>
	      </div>
	    </div>
	  </div>
</div>
</form>








