<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
		<h1>관광지&레저</h1>
		<div class="row">
			<c:forEach var="vo" items="${list }">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="../jeju/detail.do?no=${vo.no }"> 
						<img src="${vo.poster}" alt="Lights" style="width: 280px; height: 180px">
							<div class="caption">
								<p>${vo.title}</p>
								<p>입장료: ${vo.price}원</p>
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
					<li><a href="../jeju/list.do?page=${startPage-1 }">&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<li ${curpage==i?"class=active":"" }><a href="../jeju/list.do?page=${i }">${i }</a></li>
				</c:forEach>
				<c:if test="${endPage<totalpage }">
				  <li><a href="../jeju/list.do?page=${endPage+1 }">&gt;</a></li>
				 </c:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>