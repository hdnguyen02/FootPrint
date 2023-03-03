<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg bg-dark navbar-dark fixed-top">
	<div class="container">
		<div class="navbar-brand d-flex align-items-center">
			 <span class="fw-bold fs-2 text-uppercase">FootPrint</span>
		</div>
		

		 <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navmenu">
           <span class="navbar-toggler-icon"></span>
        </button>
        
       
		<div class="collapse navbar-collapse" id="navmenu">
			<ul class="navbar-nav">
				<li class="nav-item d-flex align-items-center"><a href="#" class="nav-link text-uppercase text-green-hover">Trang chủ</a></li>
				<li class="nav-item d-flex align-items-center"><a href="#" class="nav-link text-uppercase text-green-hover">sản phẩm</a></li>
				<li class="nav-item d-flex align-items-center"><a href="#" class="nav-link text-uppercase text-green-hover">sale off</a>
				<!-- dropdown  -->
					<li class="nav-item dropdown">
				         <a class="nav-link" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            <span class="text-uppercase text-green-hover">Ngôn ngữ</span>
				         </a>
				         <ul class="dropdown-menu dropdown-menu-end">
				           <li><a class="dropdown-item" href="#">Action</a></li>
				           <li><a class="dropdown-item" href="#">Another action</a></li>
				         </ul>
			        </li>
		
			</ul>
			
			 <div class="navbar-nav ms-auto d-flex align-items-center gap-3">
				<span>
					<i class="bi bi-search text-white fs-4"></i>
				</span>
				
				<span>
					<i class="bi bi-cart3 text-white fs-4"></i>
				</span>
			</div> 
			 
		</div>
	</div>
</nav>


