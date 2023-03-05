<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}

.row{
	margin: 0px auto;
	width: 800px;
}

.h1{
	text-align: center
}
</style>
</head>
<body>
	<div class="container">
		<h1>Vue 생명주기</h1>
		<div class="row">
			<input type=text size=30 class="input-sm" v-model="message"><!-- id가 따로 필요없다, ref 속성 사용 -->
			<h3>{{message}}</h3>
		</div>
	</div>
	<script>
	  new Vue({
		el:'.container',
		data:{
			message :'Hello VueJS'
		},
		//생명주기 함수
		beforeCreate:function(){
			console.log("beforeCreate Call:인스턴스 초기화 전 상태 : 이벤트 등록.. ")
			// componentWillCreate() => react 함수들
		},
		created:function(){
			console.log("created Call:인스턴스 생성 완료 : 메모리 할당 완료.. ")
			// componentDidCreate()
		},
		beforeMount:function(){
			console.log("beforeMount Call:HTML을 저장할 가상 메모리 확인 : 서버에서 데이터 읽기=변수에 저장 ")
			// componentWillMount()
		},
		mounted:function(){
			console.log("mounted Call : HTML을 저장할 가상 메모리 저장 완료 : 실제 돔 비교 => 브라우저에 출력 ")
			// componentDidMount()
			// 다른 라이브러리 연동 => AJAX, JQUERY .. => $(function(){})
		},
		beforeUpdate:function(){
			console.log("beforeUpdate Call : 수정 전 상태")
		},
		updated:function(){
			console.log("updated Call : 수정 완료 => mounted")
		},
		beforeDestroy:function(){
			console.log("beforeDestroy Call : 메모리 해제 전 상태")
		},
		destroyed:function(){
			console.log("destroyed Call : 메모리 해제 상태")
		}
	  })
	</script>
</body>
</html>