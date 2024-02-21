<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 입력</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

</head>
<body>
	
	<div class="container">
		<h3>날씨 입력</h3>
	
		<form method="get" action="/jstl/weather/insert">
			<div class="d-flex justify-content-between ml-3 mt-5">
				<label>날짜</label>
				<input type="text" class="form-control col-3" name ="date">
				<label>날씨</label>
				<select name="weather">
					<option value="">맑음</option>
					<option value="">구름조금</option>
					<option value="">흐림</option>
					<option value="">비</option>
				</select> 
				<label>미세먼지</label>
				<select name="microDust">
					<option value="">좋음</option>
					<option value="">보통</option>
					<option value="">나쁨</option>
					<option value="">최악</option>
				</select>
			</div>
			<label>기온</label>
			<div class="input-group">
				<input type="" class="form-control col-3" name ="temperatures">
				<div class="input-group-append">
					<span class="input-group-text">ºC</span>
				</div>
			</div>
			<label>강수량</label>
			<div class="input-group">
				<input type="" class="form-control col-3" name ="precipitation">
				<div class="input-group-append">
					<button class=" btn btn-secondary" readonly>mm</button>
				</div>
			</div>
			<label>풍속</label>
			<div class="input-group">
				<input type="" class="form-control col-3" name ="windSpeed">
				<div class="input-group-append">
					<button class=" btn btn-secondary" readonly>km/h</button>
				</div>
			</div>
			<button type="submit" class="btn btn-success">저장</button>
		</form>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
	
</body>
</html>