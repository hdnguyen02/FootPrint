<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div>${ product.getProductSizes().size() }</div>

<div class="container">
	<div class="row">
		<div class="col-5">
			<div class="row">
				<div class="col-12">
					<img class="w-100" src="<c:url value="/resources/image/product/${product.getImageName()}"/>">
				</div>
				
				<c:forEach items="${product.getThumbnails()}" var="thumbnail">
					<div class="col-3">
						<img class="w-100" src="<c:url value="/resources/image/thumbnail/${thumbnail.getName()}"/>">
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="col-7">
			<h3>${product.getName()}</h3>
			<p>${product.getCategory().getName()}</p>
			<p>${product.getCost()}</p>
			<p>${product.getDescription()}</p>
			<p>Số lượng trong kho</p>
			<div>
			</div>
			
			
			
		</div>
	</div>
</div>