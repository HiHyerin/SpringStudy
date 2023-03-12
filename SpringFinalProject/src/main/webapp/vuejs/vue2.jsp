<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<!-- Add this after vue.js -->
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div id="app">
	  <h1>{{message}}</h1>
	  <my-component1 v-bind:pdata="senddata"></my-component1>
	  <my-component2 v-bind:pdata="senddata2"></my-component2>
	</div>
	<template id="aaa">
		<h1>Hello 컴퍼넌트</h1>
		<h3>{{pdata2}}</h3>
	</template>
	<script>
		Vue.component('my-component2',{
			props:['pdata2'], /* props = 속성값 -> 속성으로 데이터 연결 */
			template:'#aaa'
		})
		
		
		Vue.component('my-component1',{
			props:['pdata'],
			template:'<h3>My-Component1:{{pdata}}</h3>'
		})
		
		
		new Vue({
			el:'#app',
			data:{
				message:'Vue Component',
				senddata:'my-component1 데이터 전송',
				senddata2:'my-component2 데이터 전송'
			}
		})
		
		
	</script>
</body>
</html>