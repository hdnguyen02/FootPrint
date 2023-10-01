<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<div class="col-12 col-md-5">
			<div class="row gy-3">
				<div class="col-12">
					<img class="w-100"
						src="<c:url value="/resources/image/product/${product.getImageName()}"/>"
						style="height: 350px; object-fit: cover">
				</div>
				<c:forEach items="${product.getThumbnails()}" var="thumbnail">
					<div class="col-3">
						<img class="w-100"
							src="<c:url value="/resources/image/thumbnail/${thumbnail.getName()}"/>">
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="col-12 col-md-7">
			<div class="d-flex flex-column gap-2 justify-content-center h-100">

				<h3 class="text-uppercase" style="font-size: 18px">${product.getName()}
					- ${product.getCategory().getName()}</h3>
				<p class="fs-3 fw-normal" style="color: #d26b31">
					$${product.getCost()}</p>
				<p>
					<span class="fw-bolder">Mô tả:</span> ${product.getDescription()}
				</p>
				<p class="fw-bolder">Số lượng trong kho:</p>
				<div>
					<div class="row">
						<c:forEach items="${productSizes}" var="productSize">
							<div class="col-3 col-md-2 mt-2">
								<label style="font-size: 14px; margin-bottom: 19px">${productSize.getSize().getNameSize()}</label>
								<input readonly value="${productSize.getQuantity()}"
									type="number" class="ct-input" min="0">
							</div>
						</c:forEach>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>