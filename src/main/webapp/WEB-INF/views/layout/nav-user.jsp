<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var='home' value='/' />
<c:url var='product' value='/product.htm' />
<c:url var='signIn' value='/sign-in.htm' />
<c:url var='SignOut' value='/sign-out.htm' />
<c:url var='account' value='/account.htm' />
<c:url var='register' value='/register.htm' /> 
<c:url var='staff' value='/staff.htm' />
<c:url var='admin' value='/admin.htm' />
<c:url var='cart' value='/cart.htm' />
<%-- <c:url var='order' value='/order.htm' /> --%>


<div class="fixed-top">
	<div style="background-color: #1a1a1a !important;">
		<nav class="navbar navbar-expand-lg container py-0"
			data-bs-theme="dark">
			<div class="container-fluid position-relative">
				<a class="d-flex align-items-center position-absolute top-0 ms-0"
					href="${home}" style="background-color: #87b106; left: 12px"> 
					<img src='<c:url value="/resources/image/nav/logo.webp"/>' class="w-100" style="padding: 24.5px 14px">
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent"
					style="margin-left: 220px">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex gap-4"
						style="font-size: 14px">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-uppercase d-flex gap-2"
							href="#" role="button" data-bs-toggle="dropdown"
							aria-expanded="false"> <span><i
									class="bi bi-translate"></i></span> <span>Ngôn ngữ</span> <span><i
									class="bi bi-chevron-down"></i></span>
						</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item"
									href='<c:url value="/?language=vi"/>'>Tiếng việt</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item"
									href='<c:url value="/?language=en"/>'>English</a></li>

							</ul></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-uppercase d-flex gap-2"
							href="#" role="button" data-bs-toggle="dropdown"
							aria-expanded="false"> <span><i
									class="fa-solid fa-dollar-sign"></i></span> <span>currency</span> <span><i
									class="bi bi-chevron-down"></i></span>
						</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">VND</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Dollar</a></li>

							</ul></li>


					</ul>
					<!-- icon  -->
					<div class="d-flex gap-5" style="color: #999999 !important;">
						<div class="d-flex gap-4">
							<span> <i class="fa-brands fa-facebook-f"></i></span> <span>
								<i class="fa-brands fa-twitter"></i>
							</span> <span><i class="fa-brands fa-instagram"></i></span> <span><i
								class="fa-brands fa-pinterest"></i></span>
						</div>
						<div class="d-flex gap-3" style="font-size: 14px !important">
							
							<%-- <c:if test="${ not empty sessionScope.idAccount && sessionScope.role == 'user' }">
								<a href="${order}">
									<span><i class="fa-sharp fa-regular fa-credit-card"></i></span>
									<span>Order</span>
								</a>
							</c:if> --%>

							<c:if test="${not empty sessionScope.idAccount && sessionScope.role == 'user'}">
								<div>
									<a href="${ account }"> <span><i
											class="bi bi-person-circle"></i></span> <span>My account</span>
									</a>
								</div>
							</c:if>
							<!-- Chỉ hiển thị khi đã đăng nhập -->
							

							<c:if test="${not empty sessionScope.idAccount }">
								<div>
									<a href="${SignOut}" style="color: #999999"> <span><i
											class="fa-solid fa-right-from-bracket"></i></span> <span>Sign out</span>
									</a>
								</div>
							</c:if>

							<c:if test="${empty sessionScope.idAccount }">
								<div>
									<a href="${register}" style="color: #999999"> <span><i
											class="fa-solid fa-address-card"></i></span> <span>Register</span>
									</a>
								</div>
							</c:if>


							<c:if test="${empty sessionScope.idAccount }">
								<div>
									<a href="${signIn}" style="color: #999999"> <span><i
											class="fa-solid fa-right-from-bracket"></i></span> <span>Sign in</span>
									</a>
								</div>
							</c:if>
						</div>

					</div>
				</div>
			</div>
		</nav>
	</div>


	<div style="background-color: #282828 !important;">
		<nav class="navbar navbar-expand-lg container py-2"
			data-bs-theme="dark">
			<div class="container-fluid position-relative">

				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent"
					style="margin-left: 220px">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex gap-4" >
						<li class="nav-item"><a href="${home}" 
							class="nav-link active text-uppercase text-white" aria-current="page" style="font-weight: 500">Home</a>
						</li>
						<li class="nav-item"><a href="${product}"
							class="nav-link active text-uppercase text-white" aria-current="page" style="font-weight: 500">product</a>
						</li>
						<li class="nav-item"><a
							class="nav-link active text-uppercase text-white" aria-current="page" style="font-weight: 500">blog</a></li>
						<li class="nav-item"><a
							class="nav-link active text-uppercase text-white" aria-current="page" style="font-weight: 500">contact us</a></li>
						<li>
							<form action="product.htm" method="post">
								<div class="form-group form-inline">
									<input value="${param.searchProductName}" placeholder="Nhập từ khóa" type="text" name="searchProductName" class="form-control form-inline"/>
									<input type="submit" name="submit" value="Tìm kiếm" class="form-control"/>
								</div>
							</form>
						</li>
						
							<c:if test="${ not empty sessionScope.idAccount && sessionScope.role == 'staff' }">
								<li class="nav-item"><a
								class="nav-link active text-uppercase text-white" aria-current="page" style="font-weight: 500"
								href="${staff}">Dashboard</a></li>
							</c:if>
							<c:if test="${ not empty sessionScope.idAccount && sessionScope.role == 'admin' }">
								<li class="nav-item"><a
								class="nav-link active text-uppercase text-white" aria-current="page" style="font-weight: 500"
								href="${admin}">Dashboard</a></li>
							</c:if>

					</ul>
					<!-- icon  -->
					<div class="d-flex gap-5" style="color: #fff !important;">
						<div class="d-flex gap-4">
							<span><i class="fa-solid fs-5 fa-magnifying-glass"></i></span>
							<c:if test="${not empty sessionScope.idAccount && sessionScope.role == 'user'}">
								<a href="${cart}"><span><i class="fa-solid fs-5 fa-cart-shopping text-white"></i></span></a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</div>
</div>

<style>
.dropdown-toggle::after {
	content: "";
	display: none !important;
}

i:hover {
	color: #87b106 !important;
}
a {

	color: #999999 !important;
}
</style>



