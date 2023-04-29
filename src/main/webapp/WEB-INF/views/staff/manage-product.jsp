<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>



<div class="table-responsive container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Product</h3>
	<table class="table table-hover table-striped shadow mt-4">
		<thead>
			<tr>
				<th class="col">#</th>
				<th class="col">Name</th>
				<th class="col">Category</th>
				<th class="col">Cost</th>
				<th class="col">Create at</th>
				<th class="col">Update at</th>
				<th class="col">Status</th>
			</tr>
		</thead>
		<tbody id="body-table">
			<c:forEach items="${productsWithPage}" var="product">
				<tr>
					<td class="col py-2">${product.idProduct}</td>
					<td class="col py-2">${product.name}</td>
					<td class="col py-2">${product.category.name}</td>
					<td class="col py-2">${product.cost}</td>
					<td class="col py-2"> 
						<fmt:formatDate value="${product.createAt}" pattern="dd/MM/yyyy" />
					</td>
					<td class="col py-2"> 
						<fmt:formatDate value="${product.updateAt}" pattern="dd/MM/yyyy" />
					</td>
					<%-- <td class="col py-2"><c:choose>
							<c:when test="${product.updateAt}">
								<span>${product.updateAt}</span>
							</c:when>	
							<c:otherwise>
								<span>not update</span>
							</c:otherwise>
						</c:choose>
					</td> --%>
					<td class="col py-2">
					<c:choose>
							<c:when test="${product.disable == false}">active</c:when>
							<c:otherwise>disable</c:otherwise>
						</c:choose></td>
						
					<td class="col py-2">
						<div>
							<a href='<c:url value='/staff/product/detail.htm?id=${product.idProduct}'/>' class="btn btn-dark btn-sm" style="border-radius: 0 !important;width: 80px !important"> 
								<span class="button breadcrumb-item active px-2">detail</span>
							</a>
						</div>

					</td>	
					<td class="col py-2">
						<div>
							<a href='<c:url value='/staff/product/edit.htm?id=${product.idProduct}'/>' class="btn btn-secondary btn-sm" 
								style="border-radius: 0 !important;width: 80px !important"> <span
								class="button breadcrumb-item active px-2">edit</span>
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
						href='<c:url value='/staff/product/manage.htm?page=${ page }'/>'
						class="page-link">${ page }</a></li>	
				</c:forEach>
				 <li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div>
</div>








