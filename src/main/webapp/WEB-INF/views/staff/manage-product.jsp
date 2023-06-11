<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


 

<div class="table-responsive container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Danh sách sản phẩm</h3>
	<table class="table table-hover table-striped shadow mt-4">
		<thead>
			<tr>
				<th class="col">#</th>
				<th class="col">Tên</th>
				<th class="col">Giá</th>
				<th class="col">Size</th>
				<th class="col">Kho</th>
				<th class="col">Loại</th>
				<th class="col">Màu</th>
				<th class="col">Trạng thái</th>
			</tr>
		</thead>
		<tbody id="body-table" style="min-height:500px !important">
			<c:forEach items="${productsWithPage}" var="product">
				<tr>
					<td class="col py-y">${product.idProduct}</td>
					<td class="col py-2">${product.name}</td>
					<td class="col py-2">${product.cost}</td>
					<td class="col py-2">${product.size}</td>
					<td class="col py-2">${product.quantity}</td>
					<td class="col py-2">${product.category.name}</td>
					<td class="col py-2">${product.color}</td>
					
					
					
					<td class="col py-2">
					<c:choose>
							<c:when test="${product.disable == false}">active</c:when>
							<c:otherwise>disable</c:otherwise>
						</c:choose></td>
						
					<td class="col py-2">
						<div>
							<a href='<c:url value='/staff/edit-product.htm?id=${product.idProduct}'/>' class="btn btn-dark btn-sm" style="border-radius: 0 !important;width: 80px !important"> 
								<span class="button breadcrumb-item active px-2">edit</span>
							</a>
						</div>

					</td>	

			</c:forEach>

		</tbody>
	</table>


	<!-- Phân trang -->
	<div class="d-flex justify-content-end mb-2">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				 <li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<c:forEach var="page" begin="1" end="${totalPage }">
					<li data-page="${page}" class="page-item"><a
						href='<c:url value='/staff/list-product.htm?page=${ page }'/>'
						class="page-link">${ page }</a></li>	
				</c:forEach>
				 <li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div>
</div>

<jsp:include page="/WEB-INF/views/general/notification.jsp" />







