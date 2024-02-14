<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core library2</title>
</head>
<body>
	
	<h2>1. JSTL forEach</h2>
	
	<table border="1">
		<tr>
			<th>순위</th>
			<th>제목</th>
		</tr>
		<c:forEach var="music" items="${musicRanking }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${music }</td>
			</tr>
		</c:forEach>

	
	
	
	</table>
	
</body>
</html>