<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$('#logBtn').click(function(){
			let id=$('#id').val();
			if(id.trim()==""){
				$('#id').focus();
				return;
			}
			let pwd=$('#pwd').val();
			if(pwd.trim()==""){
				$('#pwd').focus();
				return;
			}
			
			$.ajax({
				type:'post',
				url:'../member/login_ok.do',
				data:{"id":id, "pwd":pwd},
				success:function(result){
					if(result=='NOID'){
						alert("ID가 존재하지 않습니다.");
						$('#id').val("");
						$('#pwd').val("");
						$('#pwd').focus();
						
					}else if(result=="NOPWD"){
						alert("비밀번호가 틀립니다.");
						$('#pwd').val("");
						$('#pwd').focus();
					}else{
						location.href="../main/main.do";
					}
				}
			})
		})
	})
</script>
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
          <li><a href="../jeju/location.do">명소</a></li>
          <li><a href="../jeju/food.do">맛집</a></li>
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
<c:if test="${sessionScope.id==null }">
	<div class="container-fluid">
		<div style="width: 100%">
			<div class="text-right">
				<!-- <form method=post action="../member/login_ok.do"> -->
					ID:<input type=text name="id" class="input-sm" size=15 id="id">
					&nbsp;
					Password:<input type=password name="pwd" class="input-sm" size=15 id="pwd">
					&nbsp;
					<input type=button value="로그인" class="btn btn-sm btn-danger" id="logBtn">
				<!-- </form> -->
			</div>
		</div>
	</div>
</c:if>
<c:if test="${sessionScope.id!=null }">
	<div class="container-fluid">
		<div style="width: 100%">
			<div class="text-right">
				<form method="post" action="../member/logout.do">
					${sessionScope.id }님 로그인되었습니다.
					&nbsp;
					<input type=submit value="로그아웃" class="btn btn-sm btn-primary" size=15>
				</form>
			</div>
		</div>
	</div>
</c:if>
</body>
</html>