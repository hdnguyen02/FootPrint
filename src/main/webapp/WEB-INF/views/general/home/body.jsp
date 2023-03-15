<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<style>
	.item-col {
		padding-left: 5px; 
		padding-right: 5px;
		height: 350px;
		width: 24%;
		background-color: #fff;
		display: flex; 
		flex-direction:column;
		justify-content: center; 
		align-items: center;
		
	 }
	 
	 .item-row { 
	 	background-color: #f8f8f8; 
	 	display: flex; 
	 	justify-content: space-between; 

	 }
	 .sub-item { 
	 	background-color: #87b106;
	 	width: 80px;
	 	height: 80px;
	 	border-radius: 50%;
	 	display: flex; 
	 	justify-content: center; 
	 	align-items: center;
	 	margin-bottom: 30px;
	 }
	
</style>


<section  style="background-color: #f8f8f8;padding-top: 100px">
	<div class="container"> 
		<div class="item-row text-center">
			<div class="item-col shadow">
					<div class="sub-item">
					<span><i class="fa-regular fa-heart fs-1 text-white"></i></span>
					</div>
					<h3 >Great Value</h3>
					<p class="px-3">Nunc id ante quis tellus faucibus dictum in eget metus.</p>
			</div>
			<div class="item-col shadow">
				<div class="sub-item">
					<span><i class="fa-solid fa-truck fs-2 text-white"></i></span>
				</div>
				<h3 class="text-center">Worlwide Delivery</h3>
				<p>Nunc id ante quis tellus faucibus dictum in eget metus.</p>
			</div>
			<div class="item-col shadow">
				<div class="sub-item">
					<span><i class="fa-sharp fa-regular fs-2 text-white fa-credit-card"></i></span>
				</div>
			
				<h3 class="text-center">Safe Payment</h3>
				<p>Nunc id ante quis tellus faucibus dictum in eget metus.</p>
			</div>
			<div class="item-col shadow">
			<i class=""></i>
				<div class="sub-item">
					<span><i class="fa-solid fa-headphones fs-1 text-white"></i></span>
				</div>
				<h3 class="text-center">24/7 Help Center</h3>
				<p>Nunc id ante quis tellus faucibus dictum in eget metus.</p>
			</div>
		</div>
	</div> 
	
	<div class="container" style="margin-top: 80px;padding-bottom: 80px">
		<div class="row">
			<div class="col-12 col-md-6">
				<img class="w-100" src="resources/image/home/body/about.webp">
			</div>
			<div class="col-12 col-lg-6">
				<div>
					<h2 class="text-uppercase fw-bolder fs-2">PULLMAN SNEAKER ABOUT US.</h2>
					<h4 class="mt-4">Investigationes demonstraverunt lectores legere me.</h4>
					<p>Quisque consequat venenatis rutrum. Quisque posuere enim augue, in rhoncus diam dictum non.Nunc id ante quis tellus faucibus</p>
				</div>
				<hr>
				<div>
					<div>
						<span><i class="fa-solid fa-house-chimney"></i></span>
						<span>Manchester Road 123-78B, Silictown 7854MD, Great Country</span>
					</div>
					<div>
						<span><i class="fa-solid fa-phone"></i></span>
						<span>+46 123 456 789</span>
					</div>
					<div>
						<span><i class="fa-solid fa-envelope"></i></span>
						<span>Email: hello@sitename.com</span>
					</div>
				</div>
				
			</div>
			
		</div>
	</div>

</section>

