<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<script defer="defer" src='<c:url value="/resources/javascript/product.js"/>'></script>

<div class="container" style="margin-top: 140px;margin-bottom: 50px">
	<div class="row gx-4">
		<div class="col-5 bg-image hover-zoom">
			<div class="row gx-3 gy-3">
				<div class="col-12">
					<img class="w-100" src="<c:url value="/resources/image/product/${product.getImageName()}"/>" style="height: 350px; object-fit: cover">
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
			<p class="fs-3 fw-normal" style="color: #d26b31"> $${product.getCost()}</p>
			
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
			</div>
			
			
			<p> ${product.getDescription()}</p>
			<form data-form method="POST" class="d-flex flex-column gap-3">
			<div class="row gy-3 gx-3">
			
			
				<p>Select Size</p>
				<c:forEach items="${product.getProductSizes()}" var="productSize">

					<div class="col-2">
			
						<c:choose>
						    <c:when test="${productSize.getQuantity() == 0}">
						        <input disabled="disabled" hidden="true" name="radio-size" id="${productSize.getSize().getIdSize()}" value="${productSize.getSize().getIdSize()}" type="radio">
						    </c:when>

						    <c:otherwise>
						        <input hidden="true" name="radio-size" id="${productSize.getSize().getIdSize()}" value="${productSize.getSize().getIdSize()}" type="radio">
						    </c:otherwise>
						</c:choose>
			
						<label for="${productSize.getSize().getIdSize()}" class="text-center d-block rounded-2">	
							${productSize.getSize().getNameSize()}
						</label>	
					</div>
					
				</c:forEach>	
				
				
			</div>
			
			<div class="d-flex gap-3 align-items-center">
				<span>quantity: </span>

				<div class="border border-1 p-2 rounded-5 d-flex align-items-center py-2 px-3 gap-2">
					<button type="button" data-plus class="border-0 bg-white">
						+
					</button>
					<input name="quantity" class="border-0" style="width: 36px;text-align: center" type="text" value="0">
					<button type="button" data-subtraction class="border-0 bg-white">
						-
					</button>
				</div>
				
				<button type="submit" class="text-white border-0 px-4 py-2 rounded-5" style="background-color: #87b106; font-size: 18px">
					Add To Cart
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