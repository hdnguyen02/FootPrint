<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
            <c:forEach items="${users}" var="user">
                <div>
                    <div>${user.id}</div>
                    <div>${user.username}</div>
                </div>
            </c:forEach>
        </div>
</body>
</html>