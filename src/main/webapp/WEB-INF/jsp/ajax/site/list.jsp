<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

</head>
<body>
	
	<h2>즐겨찾기 목록</h2>
	
	<div class="container">
		<table class="table text-center">
			<thead>
				<tr>
					<th>NO.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="site" items="${siteList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${site.name }</td>
					<td>${site.url }</td>
					<td class="btn btn-danger p-1 mt-1 delBtn">삭제</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$(".delBtn").on("click", function() {
				// 삭제 대상 id 얻어오기
				// $(this)
				let id = ;
				$.ajax({
					type:"get"
					,url:"/ajax/site/delete"
					,data:{"id":id}
					,success:function(data) {
						if(data.result == "success") {
							alert("삭제되었습니다.");
						} else {
							alert("삭제 실패");
						}
					}
					,error:function() {
						alert("ajax 에러");
					}
				});
			});
		});
	</script>
	
</body>
</html>