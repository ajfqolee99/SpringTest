<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

</head>
<body>
	
	<div class="container">
		<h3>즐겨찾기 추가하기</h3>
		<label>제목</label><br>
		<input type="text" class="form-control" id="nameInput"><br>
		<label>주소</label><br>
		<div class="d-flex">
			<input type="text" class="form-control col-10 mr-1" id="urlInput">
			<button type="button" id="dupBtn" class="btn btn-info col-2">중복확인</button>
		</div><br>
		<h6 id="dupInfo" class="text-danger">중복된 url이 있습니다.</h6>
		<h6 id="checkInfo" class="text-success">저장가능한 url 입니다.</h6>
		<button type="button" id="addBtn" class="btn btn-success btn-block mt-3">추가</button>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function () {
			$("#dupInfo").hide();
			$("#checkInfo").hide();
			$("#dupBtn").on("click", function() {
				let url = $("#urlInput").val();
				if(url == "") {
					alert("url을 입력하세요");
					return;
				}
				$.ajax({
					type:"post"
					,url:"/ajax/site/dupUrl"
					,data:{"url":url}
					,success:function(data) {
						if(data.isDupUrl == true){
							$("#checkInfo").hide();
							$("#dupInfo").show();
						} else {
							$("#dupInfo").hide();
							$("#checkInfo").show();
						}
					}
					,error:function() {
						alert("ajax 저장에러");
					}
				});
				
			});
			
			$("#addBtn").on("click", function() {
				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				if(name == "") {
					alert("제목을 입력하세요");
					return;
				}
				if(url == "") {
					alert("주소를 입력하세요");
					return;
				}
				// 주소가 http:// 로 시작하지 않고, https:// 로 시작하지 않으면
				if(!url.startsWith("http://") && !url.startsWith("https://")) {
					alert("주소형식을 확인해주세요");
					return;
				}
				
				$.ajax({
				 	  type:"post"
					, url:"/ajax/site/create"
					, data:{"name":name, "url":url}
					, success:function(data) {
						if(data.result == "success") {
							location.href="/ajax/site/list";
						} else {
							alert("추가 실패");
						}
					}
					, error:function() {
						alert("추가 에러");
					}
				});
				
			});
			
		});
	
	</script>
	
</body>
</html>