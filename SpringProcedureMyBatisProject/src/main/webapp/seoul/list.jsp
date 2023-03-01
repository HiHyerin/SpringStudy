<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	width: 1200px
	margin: 0px auto;
}
</style>
</head>
<body>
  <div class="container">
  	<div class="row">
  		<c:forEach var="vo" items="${list }">
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="../seoul/seoul_detail.do?no=${vo.no }">
		        <img src="${vo.poster }" style="width:300;height: 220px">
		        <div class="caption">
		          <p style="font-size: 8px">${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
		</c:forEach>
		<div style="height:10px"></div>
  	 	<div class="text-center">
	  	 	<a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
	  	 	${curpage } page / ${totalpage } pages
	  	 	<a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-danger">다음</a>
  		</div>
  	</div>
  	 
  </div>
 
</body>
</html>