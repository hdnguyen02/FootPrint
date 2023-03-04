<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class="container-fluid py-3 bg-white shadow-lg">
	<form class="mt-4 row gy-4">
	
		<div class="col-12 col-md-6">
			<div>
			  <label for="exampleFormControlInput1" class="form-label">Tên giày</label>
			  <input type="email" class="form-control" id="exampleFormControlInput1">
			</div>
		
			<div class="mt-4">
				<label for="exampleFormControlTextarea1" class="form-label">Mô tả</label>
	  			<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
			
			<div class="row"> 
			
			
				<div class="mt-4 col-12 col-md-6">
					<label for="exampleFormControlTextarea1" class="form-label">Loại giày</label>
					<select class="form-select" aria-label="Default select example">
					  <option selected>Open this select menu</option>
					  <option value="1">cổ điển</option>
					  <option value="2">hiện đại</option>
					  <option value="3">quê mùa</option>
					</select>
				</div>
				
				<div class="mt-4 col-12 col-md-6">
					<label for="exampleFormControlTextarea1" class="form-label">Màu</label>
					<select class="form-select" aria-label="Default select example">
					  <option selected>Open this select menu</option>
					  <option value="1">Xanh</option>
					  <option value="2">Đỏ</option>
					  <option value="3">Vàng</option>
					</select>
				</div>
			
			</div>
			
			<div class="mt-4"> 
				<label for="exampleFormControlInput1" class="form-label">Giá tiền</label>
			   <input type="email" class="form-control" id="exampleFormControlInput1">
			</div>
			
			<div class="row mt-4">
				<div class="col-6">
					<label for="exampleFormControlInput1" class="form-label">main image</label>
					<input type="file" id="exampleFormControlInput1">
				</div>
				<div class="col-6">
					<label for="exampleFormControlInput1" class="form-label">thumbnail images</label>
					<input type="file" multiple id="exampleFormControlInput1">
				</div>
			</div>
			
			
			 
		</div>
		
		<div class="col-12 col-md-6">
			
			<div class="row gx-3 gy-5">
			
			 <label for="exampleFormControlInput1" class="form-label">Số lượng</label>
			 

			 	
			 	<c:forEach var = "i" begin = "35" end = "46">
         			
         			
	         		<div class="col-3 col-md-4 col-xl-3">
				 		<div class="form-floating">
						  <input type="number" class="form-control" min="0" id="floatingInput" placeholder="size-${i}">
						  <label for="floatingInput"><c:out value = "size ${i}"/></label>
						</div>
				 	</div>
      			</c:forEach>
			 </div>
			 
			 <div class="mt-4">
			 	
			 </div>
				
		</div>
		<div class="col-12 mt-4">
			<button style="background-color:#4e73df !important" type="submit" class="btn btn-success btn-block w-100 fw-bolder">Thêm</button>
		</div>
		
	
	</form>
	
	
	
</div>