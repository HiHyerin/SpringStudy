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
   margin: 0px auto;
   width:960px;
}
h1{
   text-align: center;
}
</style>
</head>
<body>
   <div class="container">
    <h3>믿고 보는 맛집 리스트</h3>
    <hr>
    <div class="row">
      <c:forEach var="vo" items="${list }" varStatus="s">
       <c:if test="${s.index>=0 and s.index<12 }">
           <div class="col-md-4">
          <div class="thumbnail">
            <a href="#">
              <img src="${vo.poster }"  style="width:100%">
              <div class="caption">
                <p>${vo.title }</p>
              </div>
            </a>
          </div>
       </c:if>
      </c:forEach>
    </div>
    <h3>지역별 맛집 리스트</h3>
    <hr>
    <div class="row">
           <c:forEach var="vo" items="${list }" varStatus="s">
       <c:if test="${s.index>=12 and s.index<18 }">
           <div class="col-md-4">
          <div class="thumbnail">
            <a href="#">
              <img src="${vo.poster }"  style="width:100%">
              <div class="caption">
                <p>${vo.title }</p>
              </div>
            </a>
          </div>
       </c:if>
      </c:forEach>
    </div>
    <h3>메뉴별 맛집 리스트</h3>
    <hr>
    <div class="row">
           <c:forEach var="vo" items="${list }" varStatus="s">
       <c:if test="${s.index>=18 and s.index<30 }">
           <div class="col-md-4">
          <div class="thumbnail">
            <a href="#">
              <img src="${vo.poster }"  style="width:100%">
              <div class="caption">
                <p>${vo.title }</p>
              </div>
            </a>
          </div>
       </c:if>
      </c:forEach>
    </div>
   </div>
</body>
</html>