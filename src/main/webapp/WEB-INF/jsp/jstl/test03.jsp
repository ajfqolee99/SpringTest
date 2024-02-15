<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>format library</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

</head>
<body>
	
	<div class="container">
		<h3>1. 후보자 득표율</h3>
		<table class="table text-center">
			<tr>
				<th>기호</th>
				<th>득표수</th>
				<th>득표율</th>
			</tr>
			<c:forEach var="candi" items="${candidates }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td><fmt:formatNumber value="${candi }" /></td>
					<td><fmt:formatNumber value="${candi / 1000000 }" type="percent"/></td>
				</tr>
			</c:forEach>
		</table>
		
		<h3>2. 카드 명세서</h3>
		<table class="table text-center">
			<tr>
				<th>사용처</th>
				<th>가격</th>
				<th>사용 날짜</th>
				<th>할부</th>
			</tr>
			<c:forEach var="card" items="${cardBills }">
				<tr>
					<td>${card.store }</td>
					<td><fmt:formatNumber value="${card.pay }" type="currency" /></td>
					<fmt:parseDate value="${card.date}" pattern="yyyy-MM-dd" var="date"/>
					<td><fmt:formatDate value="${date }" pattern="yyyy년 MM월 dd일"/></td>
					<td>${card.installment }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
	
</body>
</html>