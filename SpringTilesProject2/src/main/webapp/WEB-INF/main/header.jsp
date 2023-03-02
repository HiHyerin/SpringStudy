<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">WebSiteName</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="../main/main.do">Home</a></li>
	      <li><a href="../member/join.do">회원가입</a></li>
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">맛집
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="../food/food_search.do">맛집찾기</a></li>
	          <li><a href="../food/food_recommand.do">맛집추천</a></li>
	          <li><a href="../food/food_news.do">맛집뉴스</a></li>
	        </ul>
	      </li>
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">서울여행
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="../seoul/location.do">명소</a></li>
	          <li><a href="../seoul/nature.do">자연 & 관광</a></li>
	          <li><a href="../seoul/shop.do">쇼핑</a></li>
	        </ul>
	      </li>
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">제주여행
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="../seoul/location.do">명소</a></li>
	          <li><a href="../seoul/food.do">맛집</a></li>
	        </ul>
	      </li>
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">스토어
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="#">전체</a></li>
	          <li><a href="#">특가</a></li>
	          <li><a href="#">신상품</a></li>
	          <li><a href="#">베스트</a></li>
	        </ul>
	      </li>
	      <li><a href="#">실시간 채팅</a></li>
	    </ul>
	  </div>
	</nav>
</body>
</html>