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
		  <h1>총 ${count }건 검색</h1>
		</div>
		<div style="height: 20px"></div>
		<div class="row">
		  <c:forEach var="vo" items="${list}">
			<div class="col-md-3">
			    <div class="thumbnail">
			      <a href="#">
			        <img src="${vo.poster }" style="width:100%">
			        <div class="caption">
			          <p>${vo.name }</p>
			        </div>
			      </a>
			    </div>
			  </div>
			 </c:forEach>
		</div>
	</div>
</body>
</html>