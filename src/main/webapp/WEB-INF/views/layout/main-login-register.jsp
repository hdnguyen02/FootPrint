<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Foot Print</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
    <!-- <link rel="stylesheet" href="resources/css/global.css"/> -->

  </head>
  
<c:url var='home' value='/' />
  <body style="overflow-x: hidden">
  
  			<div class="body">
  				<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a class="d-flex gap-2" style="color:#87b106 !important" href="${home}">
			    <span><i class="fa-solid fa-house"></i></span>
			    <span>Home</span>
			    
			    </a></li>
			    <li class="breadcrumb-item active" aria-current="page">${ nameBreadcrumb }</li>
			  </ol>
			</nav>
  
  		<div class="row content bg-white  shadow-sm p-4">	
  			<div class="d-none col-0 d-lg-block col-lg-6" style="padding: 40px 70px;padding-top:80px">
  				<div>
  					<img class="w-100" src="resources/image/login/signin-image.jpg">
  				</div>
  			</div>
  			<div class="col-12 col-lg-6" style="padding-top: 20px;padding-bottom:20px;padding-left: 50px;padding-right:50px">
  				<jsp:include page="/WEB-INF/views/${ content }" />
  			</div>
  		
  		</div>
  			</div>
  	
  </body>
  <style>
  	.body {
  		min-height: 101vh; 
  		background-color: #f9f8f9; 
  		display: flex; 
  		flex-direction:column;
  		justify-content: center; 
  		align-items: center;
  	}
  
  	.content {
  		width: 900px;
  		min-height: 600px;
  		max-height: 1000px;
  	}
  	
  	@media screen and (max-width: 768px) {
	  .content {
  		width: 100%;
  	}
	}
  	
  	.ct-input {
		border: none; 
		padding-bottom: 6px;
		padding-left: 32px;
		outline: none;
		position: relative;
	}
	
	.ct-input:focus {
		border-bottom: 1.5px solid #87b106 !important;
	}

	.ct-icon {
		position: absolute;
		left: 0; 
		top: 4px;
	}
	
	.error {
		color: red;
		font-size: 14px;
	}
  	
  </style>
</html>


 