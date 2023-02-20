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
	margin-top:50px;
}
.row{
	margin: 0px auto;
	width:1200px
}
</style>
</head>
<body>
	<div class="container">
      <div class="row">
      	<c:forEach var="vo" items="${list }"> 
      	  <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="/w3images/lights.jpg">
		        <img src="${vo.poster }" alt="Lights" style="width:300px;height:200px">
		        <div class="caption">
		          <p>${vo.title }</p>
                </div>
              </a>
           </div>
        </div>
      	</c:forEach>
      </div>
      <div class="row">
       <div class="text-center">
        <a href="location.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
         ${curpage} page/${totalpage } pages
        <a href="location.do?page=${curpage<1?curpage+1:curpage}" class="btn btn-sm btn-primary">다음</a>
       </div>
      </div>
	</div>
</body>
</html>



















