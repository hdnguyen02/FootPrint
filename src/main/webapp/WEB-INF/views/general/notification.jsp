<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test="${ not empty result }">
			<c:choose>
			<c:when test="${result == true }">
				<div style="bottom: 24px;right:24px" class="position-fixed  alert alert-success alert-dismissible shadow mt-4" style="width: 300px" role="alert">
					 <div>${success}</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:when>
			<c:otherwise>
				<div style="bottom: 24px;right:24px" class="position-fixed fixed-right-3 alert alert-danger alert-dismissible shadow mt-4" style="width: 300px" role="alert">
					 <div>${failure}</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>