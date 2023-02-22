<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
	
}
.row{
	margin: 0px auto;
	width: 1200px;
}

h1{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="text-center">
				<a href="category.do?sno=1" class="btn btn-lg btn-danger">믿고보는 맛집 리스트</a>
				<a href="category.do?sno=2" class="btn btn-lg btn-success">지역별 인기 맛집</a>
				<a href="category.do?sno=3" class="btn btn-lg btn-primary">메뉴별 인기 맛집</a>
			</div>
		</div>
		<div style="height: 20px"></div>
		<div class="row">
			<c:forEach var="vo" items="${list }"> 
				<div class="col-md-4">
				    <div class="thumbnail">
				      <a href="list.do?cno=${vo.cno }">
				        <img src="${vo.poster }" title="${ vo.subject}" style="width:100%">
				        <div class="caption">
				          <p>${vo.title }</p>
				        </div>
				      </a>
				    </div>
				  </div>
			</c:forEach>
		</div>
	</div>
</body>
</html>