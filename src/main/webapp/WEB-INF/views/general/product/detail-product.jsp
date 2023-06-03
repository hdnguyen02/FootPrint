<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<script defer="defer" src='<c:url value="/resources/javascript/product.js"/>'></script>

<div class="container" style="margin-top: 140px;margin-bottom: 50px">

	<c:if test="${ not empty result }">
			<c:choose>
			<c:when test="${result == true }">
				<div style="bottom: 24px;right:24px" class="position-fixed  alert alert-success alert-dismissible shadow mt-4" style="width: 300px" role="alert">
					 <div>Thêm vào giỏ hàng thành công</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:when>
			<c:otherwise>
				<div style="bottom: 24px;right:24px" class="position-fixed fixed-right-3 alert alert-danger alert-dismissible shadow mt-4" style="width: 300px" role="alert">
					 <div>Xảy ra lỗi !!!</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>

	<div class="row gx-4">
		<div class="col-5 bg-image hover-zoom">
			<div class="row gx-3 gy-3">
				<div class="col-12">
					<img class="w-100" src="<c:url value="/resources/image/product/${product.getImage()}"/>" style="height: 350px; object-fit: cover">
				</div>
	
				<c:forEach items="${product.getThumbnails()}" var="thumbnail">
					<div class="col-3">
						<img class="w-100" src="<c:url value="/resources/image/thumbnail/${thumbnail.getName()}"/>" >
					</div>
				</c:forEach>
			</div>
			
		</div>
		<div class="col-7 d-flex flex-column gap-3">
			<h3 class="text-uppercase fs-4 fw-medium">
				${product.getName()}
			</h3>
			
			
			<div class="d-flex" style="font-size: 14px;color:#555555">
				<div class="me-3">
					<span><i class="fa fa-star"></i></span> 
					<span><i class="fa fa-star"></i></span>
					<span><i class="fa fa-star"></i></span>
					<span><i class="fa fa-star"></i></span>
					<span><i class="fa fa-star"></i></span>
				</div>
				<p>1 Reviews</p>	
			</div>
			<p class="fs-3 fw-bold" style="color: #d26b31"> <span><i class="fa fa-usd" aria-hidden="true"></i></span>${product.getCost()}</p>
			<div class="d-flex align-items-center gap-3">
				<span>Color: </span>
				<span style="display: inline-block;width: 30px;height: 30px;background: ${product.getColor()}" class="fs-5 fw-normal"></span>
			</div>
			<span class="fs-5 fw-normal"> ${product.getSize()}</span>
			
			
			
			<div>
				<p class="fs-6" style="margin-bottom: 14px">
					<span class="fw-bolder">Hurry up!</span>
					<span>offer ends in:</span>
				</p>
				
				<div class="d-flex gap-3">	
					<div class="px-4 py-2 rounded-2" style="background-color: #eaeaea">
						<span class="d-block text-center">00</span> 
						<span class="d-block text-center" style="font-size: 12px">DAYS</span>
					</div>
					<div class="px-3 py-2 rounded-2" style="background-color: #eaeaea">
						<span class="d-block text-center">00</span> 
						<span class="d-block text-center" style="font-size: 12px">HOURS</span>
					</div>
					<div class="px-4 py-2 rounded-2" style="background-color: #eaeaea">
						<span class="d-block text-center">00</span> 
						<span class="d-block text-center" style="font-size: 12px">MINS</span>
					</div>
					<div class="px-4 py-2 rounded-2" style="background-color: #eaeaea">
						<span class="d-block text-center">00</span> 
						<span class="d-block text-center" style="font-size: 12px">SECS</span>
					</div>
				</div>
				<div class="fw-bold mt-3" style="color: #198754">
					<span><i class="fa fa-check" aria-hidden="true"></i></span>
					<span>${product.getQuantity()} TRONG KHO</span>
				</div>
				<p class="mt-3"> ${product.getDescription()}</p>
			</div>
			
		
			<form method="POST" class="d-flex flex-column gap-3">
			<div class="row gy-3 gx-3">
			</div>
			
			<div class="d-flex gap-3 align-items-center">
				<span>quantity: </span>

				<div class="rounded-5 d-flex align-items-center justify-content-center py-1 gap-1 mx-3" style="background-color: #efefef;width: 150px; height: 50px">
								<button type="button" style="font-weight: 500" data-subtraction class="border-0 px-0">
									<i class="fa-solid fa-minus"></i>
								</button>
								<input name="quantity" class="border-0" style="width: 70px;text-align: center;background-color: #efefef;font-weight: 500" type="text" value="0">
								
								<button type="button" style="font-weight: 500" data-plus class="border-0 px-0">
									<i class="fa-solid fa-plus"></i>
								</button>
					</div>
				
				<button type="submit" class="text-white fw-bold fs-5 border-0 px-4 rounded-5" style="background-color: #87b106;height: 50px">
					Thêm vào giỏ hàng
				</button>
			
				
			</div>
			</form>
			
			<div class="d-flex gap-3" style="font-size:14px">
				<div>	
					<span><i class="fa-solid fa-code-compare"></i></span>
					<span>Compare</span>
				</div>
				<div>	
					<span><i class="fa-regular fa-heart"></i></span>
					<span>Wishlist</span>
				</div>
			</div>
			<hr>
			
			<div class="d-flex gap-2">
				<div style="background-color:#3b5999" class="px-3 py-1 rounded-2 d-flex justify-content-center align-items-center gap-2">
					<i style="font-size:12px" class="fa-brands fa-facebook-f text-white"></i>
					<span style="font-size:12px" class="text-white">Like</span>
				</div>
				<div style="background-color:#1da1f2" class="px-1 py-1 rounded-2 d-flex justify-content-center align-items-center gap-1">
					<i style="fpnt-size:12px" class="fa-brands fa-twitter text-white"></i>
					<span style="font-size:12px" class="text-white">Twitter</span>
				</div>
				<div style="background-color:#cb2028" class="px-3 py-1 rounded-2 d-flex justify-content-center align-items-center gap-2">
					<i style="font-size:12px" class="fa-brands fa-google text-white"></i>
					<span style="font-size:12px" class="text-white">Share</span>
				</div>
			</div>
		
			
		</div>
	</div>
	
</div>


<style>
	p {
		margin-bottom: 0px;
	}
	
	input {
		outline:none;
	}
	
	input[type="radio"][disabled] + label {
		background-color: rgba(234,234,234,0.3);
	}
	
	input[type="radio"]:checked + label {
		background-color: #87b106;
		color: white;
		font-weight: 500;
	}
	
	label {
		background-color: #eaeaea;
		padding-top: 10px; 
		padding-bottom: 10px;
		font-size: 14px;
		
	}
</style>