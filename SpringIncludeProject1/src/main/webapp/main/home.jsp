<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>믿고보는 맛집 리스트</h3>
	<hr>
	<c:forEach var="vo" items="${cList }" varStatus="s">
		<c:if test="${s.index>=0 and s.index<12 }">
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="../food/food_list.do?cno=${vo.cno }">
		        <img src="${vo.poster }" title="${vo.subject }" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
		</c:if>
	</c:forEach>
	<h3>지역별 인기 맛집</h3>
	<hr>
	<c:forEach var="vo" items="${cList }" varStatus="s">
		<c:if test="${s.index>=12 and s.index<18 }">
		  <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="../food/food_list.do?cno=${vo.cno }">
		        <img src="${vo.poster }" title="${vo.subject }" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
		</c:if>
	</c:forEach>
	<h3>메뉴별 인기 맛집</h3>
	<hr>
	<c:forEach var="vo" items="${cList }" varStatus="s">
		<c:if test="${s.index>=18 and s.index<30 }">
		  <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="../food/food_list.do?cno=${vo.cno }">
		        <img src="${vo.poster }" title="${vo.subject }" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
		</c:if>
	</c:forEach>
</body>
</html>