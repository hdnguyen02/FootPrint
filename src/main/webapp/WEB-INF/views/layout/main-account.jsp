<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<div class="container">
	<div class="row py-5 gy-4">
	<div class="col-12 col-md-3">
		<jsp:include page="/WEB-INF/views/layout/sidebar-account.jsp" />
	</div>
	<div class="col-12 col-md-9">
		<div class="border border-1 p-4">
			<jsp:include page="/WEB-INF/views/${ bodyAccount }" />
		</div>
	</div>
</div>
</div>


<style>


	.ct-ul {
		padding-left: 0px;
		margin-bottom:0px;
	}
	
	li {
		list-style: none;
	}
	
	.ct-a {
		text-decoration: none;
		color: black;
		display: block; 
		padding:12px;
		cursor: pointer;
	} 
	
	.ct-a.active {
		background-color: #87b106;
		color: white !important;
	}
	
	.ct-input {
		width: 100%;  
		padding: 12px; 
		border: 1px solid #ccc;
		font-size: 14px;
   	    background-color: #f7f7f7;
	}
	.ct-input:focus {
		outline: 1px solid #87b106;
	}
	
	.ct-select { 
		border: 1px solid #ccc;
		font-size: 14px;
		background-color: #f7f7f7;
		padding: 12px;
	}
	
	.container-input {
		display: flex;
		flex-direction: column;
		gap: 12px;
		margin-bottom: 14px;
		
	}
	.container-input > label {
		 font-size: 14px;
	}
	
	
}
	
</style>