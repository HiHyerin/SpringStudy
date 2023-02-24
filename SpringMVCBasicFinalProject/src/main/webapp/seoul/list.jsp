<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 250px;
	
}

.row{
	margin : 0px auto;
	width: 1200px;
}
</style>
</head>
<body>
	<div class="container">
		<h2 style="text-center">서울명소</h2>
		<div class= "row">
			<c:forEach var="vo" items="${list }">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="../seoul/detail_before.do?no=${vo.no }"> 
						<img src="${vo.poster}" alt="Lights" style="width: 280px; height: 180px">
							<div class="caption">
								<p>${vo.title}</p>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
				<c:if test="${startPage>1 }"><%--startPage : 1, 6, 11, 16.. --%>
					<li><a href="../seoul/list.do?page=${startPage-1 }">&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<li ${curpage==i?"class=active":"" }><a href="../seoul/list.do?page=${i }">${i }</a></li>
				</c:forEach>
				<c:if test="${endPage<totalpage }">
				  <li><a href="../seoul/list.do?page=${endPage+1 }">&gt;</a></li>
				 </c:if>
				</ul>
			</div>
		</div>
		<div style="height: 20px"></div>
		<h3>최근 방문 장소</h3>
		<hr>
		<div class="row">
			<c:forEach var="vo" items="${sList }">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="../seoul/detail.do?no=${vo.no }"> 
						<img src="${vo.poster}" alt="Lights" style="width: 280px; height: 180px">
							<div class="caption">
								<p>${vo.title}</p>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>