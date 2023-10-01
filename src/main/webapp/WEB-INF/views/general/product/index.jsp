<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Foot Print</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/product.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/global.css"/>" />
<script defer="defer"
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<c:url var='listByPrice1' value='/product/list-by-price/10/15.htm' />
<c:url var='listByPrice2' value='/product/list-by-price/16/20.htm' />
<c:url var='listByPrice3' value='/product/list-by-price/21/25.htm' />
<c:url var='listByPrice4' value='/product/list-by-price/26/30.htm' />
<c:url var='listByPrice5' value='/product/list-by-price/31/35.htm' />

<c:url var='listByColor1' value='/product/list-by-color/RED.htm' />
<c:url var='listByColor2' value='/product/list-by-color/WHITE.htm' />
<c:url var='listByColor3' value='/product/list-by-color/BROWN.htm' />
<c:url var='listByColor4' value='/product/list-by-color/GREEN.htm' />
<c:url var='listByColor5' value='/product/list-by-color/BLACK.htm' />

<c:url var='listBySize1' value='/product/list-by-size/(36).htm' />
<c:url var='listBySize2' value='/product/list-by-size/(37).htm' />
<c:url var='listBySize3' value='/product/list-by-size/(38).htm' />
<c:url var='listBySize4' value='/product/list-by-size/(39).htm' />
<c:url var='listBySize5' value='/product/list-by-size/(40).htm' />

</head>
<body style="overflow-x: hidden">
	<jsp:include page="/WEB-INF/views/layout/nav-user.jsp" />

	<div class="container" style="margin-top: 120px">
		<div class="row">
			<div class="col-lg-3 order-2 order-lg-1">
				<aside class="sidebar-wrapper">
					<!-- single sidebar start -->
					<div class="sidebar-single">
						<h6 class="sidebar-title">Price</h6>
						<a href="${listByPrice1}" class="list-group-item">$10.00 -
							$15.00</a> <a href="${listByPrice2}" class="list-group-item">$16.00
							- $20.00</a> <a href="${listByPrice3}" class="list-group-item">$21.00
							- $25.00</a> <a href="${listByPrice4}" class="list-group-item">$26.00
							- $30.00</a> <a href="${listByPrice5}" class="list-group-item">$31.00
							- $35.00</a>
					</div>
					<!-- single sidebar end -->

					<!-- single sidebar start -->
					<div class="sidebar-single">
						<h6 class="sidebar-title">Category</h6>
						<div class="sidebar-body">
							<ul class="checkbox-container search-list">
								<c:forEach items="${cate}" var="c">
									<c:url var='listByCategory'
										value='/product/list-by-category/${c.idCategory}.htm' />
									<a href="${listByCategory}" class="list-group-item">${c.name}</a>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!-- single sidebar end -->

					<!-- single sidebar start -->
					<div class="sidebar-single">
						<h6 class="sidebar-title">Color</h6>
						<a href="${listByColor1}" class="list-group-item">RED</a> <a
							href="${listByColor2}" class="list-group-item">WHITE</a> <a
							href="${listByColor3}" class="list-group-item">BROWN</a> <a
							href="${listByColor4}" class="list-group-item">GREEN</a> <a
							href="${listByColor5}" class="list-group-item">BLACK</a>
					</div>

					<!-- single sidebar start -->
					<div class="sidebar-single">
						<h6 class="sidebar-title">Size</h6>
						<a href="${listBySize1}" class="list-group-item">(36)</a> <a
							href="${listBySize2}" class="list-group-item">(37)</a> <a
							href="${listBySize3}" class="list-group-item">(38)</a> <a
							href="${listBySize4}" class="list-group-item">(39)</a> <a
							href="${listBySize5}" class="list-group-item">(40)</a>
					</div>

				</aside>
			</div>

			<!-- shop main wrapper start -->
			<div class="col-lg-9 order-1 order-lg-2">
				<div class="shop-product-wrapper">
					<!-- shop product top wrap start -->
					<div class="shop-top-bar">
						<div class="row align-items-center">
							<div class="col-lg-7 col-md-6 order-2 order-md-1">
								<div class="top-bar-left">

								</div>
							</div>
							<div class="col-lg-5 col-md-6 order-1 order-md-2">
								<div class="top-bar-right">
									<div class="product-short">
								
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- shop product top wrap start -->

					<!-- product item list wrapper start -->
					<div class="shop-product-wrap grid-view row mbn-30">

						<c:if test="${productsActive.size()==0}">
							<div class="container py-5" style="min-height: 80vh">
								<div class="col-sm-12 empty-cart-cls text-center">
									<img src="https://i.imgur.com/dCdflKN.png" width="130"
										height="130" class="img-fluid mb-4 mr-3">
									<h3>
										<strong>Không tồn tại sản phẩm</strong>
									</h3>
							
								</div>
							</div>
						</c:if>

						<c:if test="${productsActive.size() != 0 }">

							<c:forEach items="${productsActive}" var="product">
								<div class="col-md-4 col-sm-6">
									<!-- product grid start -->
									<div class="product-item">
										<div class="product-thumb">
											<a
												href='<c:url value='/product/detail.htm?id=${product.getIdProduct()}' />'>
												<img class="w-100"
												src="<c:url value="/resources/image/product/${product.getImage()}"/>"
												style="height: 200px; object-fit: cover">
											</a>
											<div class="button-group">
												<a data-bs-toggle="tooltip"
													data-bs-original-title="Add to Wishlist"
													aria-label="Add to Wishlist"><i
													class="fa-regular fa-heart"></i> </a> <a><span
													data-bs-toggle="tooltip" title=""
													data-bs-original-title="Quick View" aria-label="Quick View"><i
														class="fa fa-eye"></i></span></a>
											</div>
											<div class="product-label">
												<span>new</span>
											</div>

										</div>
										<div class="product-content">
											<div class="product-caption">
												<div style="min-height: 80px">
													<span class="product-name"> 
														<a>${product.getName()}</a>
													</span> 
													<span>- ${product.getSize()}</span>
												</div>
												<div class="price-box">
													<!-- <span class="price-old"><del>$90.00</del></span> -->
													<span class="price-regular">$${product.getCost()}</span>
												</div>
												<a class="add-to-cart"><i
													class="fa fa-shopping-cart text-white"></i></a>
											</div>
											<div class="ratings">
												<span><i class="fa fa-star"></i></span> <span><i
													class="fa fa-star"></i></span> <span><i class="fa fa-star"></i></span>
												<span><i class="fa fa-star"></i></span> <span><i
													class="fa fa-star"></i></span>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer-user.jsp" />
</body>
</html>

