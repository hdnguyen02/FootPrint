<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<nav
	class="navbar navbar-expand bg-light py-0 fixed-top ct-navbar shadow"
	style="height: 69.6px">
	<div class="container-fluid px-4">

		<!-- button sidebar-dashboard -->
		<button class="navbar-toggler d-block d-lg-none me-3" type="button"
			data-bs-toggle="offcanvas" data-bs-target="#sidebar-dashboard"
			aria-controls="offcanvasExample">
			<i class="bi bi-three-dots" data-bs-target="#sidebar-dashboard"></i>
		</button>
		<!-- button sidebar-dashboard -->


		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<ul class="navbar-nav ms-auto mb-2 mb-lg-0"> 
		
				<li class="d-flex align-items-center gap-3" style="padding-left: 160px">
					
					<div class="d-flex align-items-start flex-column ">
						<span class="fw-bolder" style="font-size: 14px">
							${sessionScope.nameAccount}
						</span>
						<span class="text-uppercase" style="font-size: 14px">
							role: ${sessionScope.role}
						</span>
						
					</div>
					<div>
						<img class="w-100" src="<c:url value="/resources/image/avatar/main.png"/>" width="40px" height="40px">
					</div>
					
				</li>
				
				
				
				<!-- <li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle d-flex gap-2 align-items-center" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				
					<span style="color: black">Đây là tên</span>
					<span style="color: black" class=""><i class="fa-solid fa-user fs-4"></i></span>
				</a>
					<ul class="dropdown-menu dropdown-menu-end">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul>
				</li> -->
			</ul>
		</div>


	</div>
</nav>

<style>
	.dropdown-toggle::after {
	content: "";
	display: none !important;
}
</style>