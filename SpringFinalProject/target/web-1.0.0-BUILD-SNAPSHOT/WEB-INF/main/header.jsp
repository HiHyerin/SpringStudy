<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="wrapper row1">
  <header id="header" class="clear"> 
    <div id="logo" class="fl_left">
      <h1><a href="index.html">Gravity</a></h1>
    </div>
    <div class="fl_right">
    <c:if test="${sessionScope.id==null }">
      <ul class="inline">
        <li>ID:<input type=text name="id" size=15 class="input-sm" v-model="id" ref="id"></li>
        <li>PWD:<input type=password name="pwd" size=15 class="input-sm" v-model="pwd" ref="pwd"></li>
        <li><input type=button value="로그인" class="btn btn-sm btn-danger" v-on:click="login()"></li>
      </ul>
      </c:if>
      <c:if test="${sessionScope.id!=null} ">
	      <ul class="inline">
	        <li>${sessionScope.name }님 로그인 중입니다.</li>
	        <li><input type=button value="로그아웃" class="btn btn-sm btn-success" v-on:click="logout()"></li>
	      </ul>
      </c:if>
    </div>
  </header>
</div>
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    <ul class="clear">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li><a class="drop" href="#">회원</a>
        <ul>
          <li><a href="../pages/gallery.html">회원가입</a></li>
          <li><a href="../pages/full-width.html">아이디 찾기</a></li>
          <li><a href="../pages/sidebar-left.html">비밀번호 찾기</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="../pages/gallery.html">지역별 찾기</a></li>
          <li><a href="../pages/full-width.html">맛집 추천</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="../pages/gallery.html">레시피 목록</a></li>
          <li><a href="../pages/full-width.html">쉐프</a></li>
          <li><a href="../pages/sidebar-left.html">가격비교</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="../pages/gallery.html">게시판</a></li>
          <li><a href="../pages/full-width.html">공지사항</a></li>
        </ul>
      </li>
      <c:if test="${sessionScope.id!=null }">
      	<li><a href="../chat/chat.do">채팅</a></li>
      	<li><a href="#">마이페이지</a></li>
      </c:if>
      
    </ul>
  </nav>
</div>
<script>
	new Vue({
		el:'#header',
		data:{
			id:'',
			pwd:'',
			msg:''
		},
		methods:{
			login:function(){/* 참조할 땐 ref사용 */
				if(this.id.trim()==""){
					this.$refs.id.focus();
					return
				}
				if(this.pwd.trim()==""){
					this.$refs.pwd.focus();
					return
				}
				let _this=this
				axios.get('http://localhost/web/member/login_vue.do',{
					params:{
						id:this.id,
						pwd:this.pwd
					}
				}).then(function(response){
					let res=response.data.trim();
					if(ress==='NOID'){
						alert("id가 존재하지 않습니다.")
						id='';
						pwd='';
						this.$refs.id.focus();
					}else if(res==='NOPWD'){
						alert("비밀번호가 틀립니다.")
						pwd='';
						this.$refs.pwd.focus();
					}else{
						location.href="../main/main.do"
					}
				})
					
			},
			logout:function(){
				
			}
		}
	})
</script>
</body>
</html>