<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div
	class="table-responsive container-fluid px-5 pt-5 pb-4 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Danh sách loại sản phẩm</h3>


	<table class="table table-hover table-striped shadow mt-4">
		<thead>
			<tr>
				<th class="col">Mã loại</th>
				<th class="col">Tên loại</th>
			</tr>
		</thead>
		<tbody id="body-table">
			<c:forEach items="${categoriesPerPage}" var="category">
				<%-- <div data-id-category="${ category.idCategory }"
					data-name-category="${ category.name }"
					data-diable-category="${ category.disable }" class="d-none"></div> --%>
				<tr>

					<td class="col py-2">${category.idCategory}</td>
					<td class="col py-2">${category.name}</td>
			
					<%-- <td class="col py-2"><c:choose>
							<c:when test="${category.disable == false}">
								<button class="btn btn-success btn-sm"
									data-disable-category="${category.idCategory}"
									style="border-radius: 0 !important; width: 80px !important">active</button>
							</c:when>
							<c:otherwise>
								<button class="btn btn-danger btn-sm"
									data-disable-category="${category.idCategory}"
									style="border-radius: 0 !important; width: 80px !important">disable</button>
							</c:otherwise>
						</c:choose>
					</td> --%>
					<td class="col py-2">
						<div>
							<a
								href='<c:url value='/staff/edit-category.htm?id=${category.idCategory}'/>'
								class="btn btn-secondary btn-sm"
								style="border-radius: 0 !important; width: 80px !important">
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
						href='<c:url value='/staff/category.htm?page=${ page }'/>'
						class="page-link">${ page }</a></li>
				</c:forEach>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div>
</div>


<jsp:include page="/WEB-INF/views/general/notification.jsp" />


