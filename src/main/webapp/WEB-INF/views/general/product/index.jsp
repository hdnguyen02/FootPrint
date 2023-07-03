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

<c:url var='listByPrice1' value='/product/list-by-price/10/15.htm'/>
<c:url var='listByPrice2' value='/product/list-by-price/16/20.htm'/>
<c:url var='listByPrice3' value='/product/list-by-price/21/25.htm'/>
<c:url var='listByPrice4' value='/product/list-by-price/26/30.htm'/>
<c:url var='listByPrice5' value='/product/list-by-price/31/35.htm'/>

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
                            	<a href="${listByPrice1}" class="list-group-item">$10.00 - $15.00</a>
                            	<a href="${listByPrice2}" class="list-group-item">$16.00 - $20.00</a>
                            	<a href="${listByPrice3}" class="list-group-item">$21.00 - $25.00</a>
                            	<a href="${listByPrice4}" class="list-group-item">$26.00 - $30.00</a>
                            	<a href="${listByPrice5}" class="list-group-item">$31.00 - $35.00</a>
						</div>               
						         
                        <!-- single sidebar end -->


                        <!-- single sidebar start -->
                        <div class="sidebar-single">
                            <h6 class="sidebar-title">Category</h6>
                            <div class="sidebar-body">
                                <ul class="checkbox-container search-list">
                                	<c:forEach items="${cate}" var="c">
                                	<c:url var='listByCategory' value='/product/list-by-category/${c.idCategory}.htm'/>
                                		<a href="${listByCategory}" class="list-group-item">${c.name}</a>
                                		<!--  
                                		<li>
                                        	<div class="custom-control custom-checkbox">
                                            	<input type="checkbox" class="custom-control-input" id="customCheck11"/>
                                            	<label class="custom-control-label" for="customCheck11">${c.name}</label>
                                        	</div>
                                    	</li>
                                    	-->
                                	</c:forEach>                                                                       
                                </ul>
                            </div>
                        </div>
                        <!-- single sidebar end -->

						<!-- single sidebar start -->
						<div class="sidebar-single">
                            <h6 class="sidebar-title">Color</h6>                            	
                            	<div class="sidebar-body">
                                <ul class="checkbox-container search-list">
                                	<c:forEach items="${color}" var="col">
                                	<c:url var='listByColor' value='/product/list-by-color/${col.idColor}.htm'/>
                                		<a href="${listByColor}" class="list-group-item">${col.nameColor}</a>                               		
                                	</c:forEach>                                                                       
                                </ul>
                            	</div>                           	
                        </div>
						<!-- single sidebar end -->
						
                        <!-- single sidebar start -->
                        <div class="sidebar-single">
                            <h6 class="sidebar-title">Size</h6>
                            <div class="sidebar-body">
                                <ul class="checkbox-container search-list">
                                	<c:forEach items="${size}" var="s">
                                		<c:url var='listBySize' value='/product/list-by-size/${s.idSize}.htm'/>
                                			<a href="${listBySize}" class="list-group-item">${s.nameSize}</a>                               		
                                	</c:forEach>          
                                </ul>
                            </div>
                        </div>
                        		<!--  
                                    <li>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck111">
                                            <label class="custom-control-label" for="customCheck111">35 (4)</label>
                                        </div>
                                    </li>
                                -->    
                     
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

									<div class="product-amount">
										<p>Showing 1–16 of 21 results</p>
									</div>
								</div>
							</div>
							<div class="col-lg-5 col-md-6 order-1 order-md-2">
								<div class="top-bar-right">
									<div class="product-short">
										<p>Sort By :</p>
										<select class="nice-select" name="sortby">
											<option value="trending">Relevance</option>
											<option value="sales">Name (A - Z)</option>
											<option value="sales">Name (Z - A)</option>
											<option value="rating">Price (Low &gt; High)</option>
											<option value="date">Rating (Lowest)</option>
											<option value="price-asc">Model (A - Z)</option>
											<option value="price-asc">Model (Z - A)</option>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- shop product top wrap start -->

					<!-- product item list wrapper start -->
					<div class="shop-product-wrap grid-view row mbn-30">
				
						
						
						<c:forEach items="${productsActive}" var="product">
						
						<div class="col-md-4 col-sm-6">
							<!-- product grid start -->
							<div class="product-item">
								<div class="product-thumb">
									<a href='<c:url value='/product/detail.htm?id=${product.getIdProduct()}' />'> 
										<img class="w-100" src="<c:url value="/resources/image/product/${product.getImageName()}"/>" style="height: 200px; object-fit: cover">
									</a>
									<div class="button-group">
										<a data-bs-toggle="tooltip"
											data-bs-original-title="Add to Wishlist"
											aria-label="Add to Wishlist"><i
											class="fa-regular fa-heart"></i>
										</a>
										<a><span
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
										<h6 class="product-name">
											<a>${product.getName()}</a>
										</h6>
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
										<span><i class="fa fa-star"></i></span> <span><i class="fa fa-star"></i></span>
									</div>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer-user.jsp" />
</body>
</html>

