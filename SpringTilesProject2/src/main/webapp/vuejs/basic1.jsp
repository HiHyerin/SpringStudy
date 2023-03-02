<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	Front-End
	
	JQuery = Ajax(이전) = web 2.0
	VueJS, React => web3
	Vuejs => vuex => vue3
	jsp <=> mvc
	reactjs => Redux => mobx(배민), saga
	-----------------   ---------
	jsp			mvc		 spring
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#msg').keyup(function(){
		let value = $(this).val();
		$('#print').text(value);
	})
})
</script> -->
</head>
<body>
	<div id="app">
		<input type=text size=35 v-model="msg">
		<p >{{msg}}</p>
		<input type=text size=35 v-model="message">
		<p >{{message}}</p>
	</div>
	<div class="info">
		이름:{{name}}<br>
		성별:{{sex}}
	</div>
	<script>
		new Vue({
			el:'#app',
			data:{
				msg:'',
				message:'',
				name:'홍길동',
				sex:'남자'
			}
		})
		new Vue({
			el:'.info',
			data:{
				name:'심청이',
				sex:'여자'
			}
		})
	</script>
	
</body>
</html>