<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>



<div class="table-responsive container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Danh sách sản phẩm</h3>
	<table class="table table-hover table-striped shadow mt-4">
		<thead>
			<tr>
				<th class="col">#</th>
				<th class="col">Firstname</th>
				<th class="col">LastName</th>
				<th class="col">CCCD</th>
				<th class="col">Email</th>
				<th class="col">Phone</th>
				<th class="col">address</th>
				<th class="col">Diasble</th>
			</tr>
		</thead>
		<tbody id="body-table">
			<c:forEach items="${staffs}" var="staff">
				<tr>
					<td class="col py-y">${staff.idEmployee}</td>
					<td class="col py-2">${staff.firstName}</td>
					<td class="col py-2">${staff.lastName}</td>
					<td class="col py-2">${staff.cccd}</td>
					<td class="col py-2">${staff.email}</td>
					<td class="col py-2">${staff.phone}</td>
					<td class="col py-2">${staff.address}</td>
					<td class="col py-2">${staff.disable}</td>	
					
				
					<td class="col py-2">
						<div>
							<a href='<c:url value='/admin/edit-staff.htm?id=${staff.idEmployee}'/>' class="btn btn-dark btn-sm" style="border-radius: 0 !important;width: 80px !important"> 
								<span class="button breadcrumb-item active px-2">edit</span>
							</a>
						</div>

					</td>	

			</c:forEach>

		</tbody>
	</table>


<%-- 	<!-- Phân trang -->
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
	</div> --%>
</div>

<jsp:include page="/WEB-INF/views/general/notification.jsp" />







