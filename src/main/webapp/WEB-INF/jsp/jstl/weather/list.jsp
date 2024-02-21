<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기상청 - 과거날씨</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/jstl/css/style.css" type="text/css">
</head>
<body>
	
	<div id="wrap">
		<section class="contents d-flex">
			<nav class="main-menu">
				<div class="d-flex mt-2 justify-content-center">
					<div class="col-2">
						<img width="25" src="data:image/png;base64,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">
					</div>
					<h4 class="text-white col-7">기상청</h4>
				</div>
				<ul class="nav flex-column">
					<li class="nav-item"><a href="/jstl/weather/list" class="nav-link text-white">날씨</a></li>
					<li class="nav-item"><a href="/jstl/weather/input" class="nav-link text-white">날씨입력</a></li>
					<li class="nav-item"><a href="/jstl/weather/list" class="nav-link text-white">테마날씨</a></li>
					<li class="nav-item"><a href="/jstl/weather/list" class="nav-link text-white">관측기후</a></li>
				</ul>
			</nav>	
			<article class="main-contents p-4">
				<h3>과거 날씨</h3>
				<table class="table text-center">
					<thead>
						<tr>
							<td>날짜</td>
							<td>날씨</td>
							<td>기온</td>
							<td>강수량</td>
							<td>미세먼지</td>
							<td>풍속</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="weather" items="${weatherList }">
						<tr>
							<td><fmt:formatDate value="${weather.date }" pattern="yyyy년 M월 d일" /></td>
							<td>
							<c:choose>
								<c:when test="${weather.weather eq '맑음' }">
									<img src="http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg">
								</c:when>
								<c:when test="${weather.weather eq '구름조금' }">
									<img src="http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg">
								</c:when>
								<c:when test="${weather.weather eq '흐림' }">
									<img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg">
								</c:when>
								<c:when test="${weather.weather eq '비' }">
									<img src="http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg">
								</c:when>
								<c:otherwise>
									${weather.weather }
								</c:otherwise>
							</c:choose>
							</td>
							<td>${weather.temperatures }ºC</td>
							<td>${weather.precipitation }mm</td>
							<td>${weather.microDust }</td>
							<td>${weather.windSpeed }km/h</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</article>
		</section>
		<footer class="d-flex">
			<div class="logo"></div>
			<div class="copyright"></div>
		</footer>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
	
</body>
</html>