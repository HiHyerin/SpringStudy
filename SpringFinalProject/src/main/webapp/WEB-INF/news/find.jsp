<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.pagination li{
  display:inline-block;
}
</style>
</head>
<body>
	<div class="wrapper row3 rows">
  	  <main class="container clear">
  	    <div class="row">
  	    	<table class="table"> <!-- 검색기 -->
  	    	  <tr>
  	    	    <td class="inline">
  	    	    	<input type="text" size=25 class="input-sm" ref="ss" v-model="ss">
  	    	    	<input type="button" value="검색" class="btn btn-sm btn-primary" v-on:click="find()">
  	    	    </td>
  	    	  </tr>
  	    	</table>
  	    </div>
  	    
  	    <div style="height: 20px"></div>
  	    
  	    <div class="row">
  	    	<table class="table">
  	    	  <tr>
  	    	    <td>
  	    	      <table class="table" v-for="vo in news_list">
  	    	        <tr>
  	    	        	<td class="text-left"><span style="color: orange" v-html="vo.title"></span></td>
  	    	        	<td class="text-right">{{vo.pubDate}}</td>
  	    	        </tr>
  	    	        <tr>
  	    	        	<td colspan="2"><a :href="vo.link" v-html="vo.description"></a></td>
  	    	        </tr>
  	    	      </table>
  	    	    </td>
  	    	  </tr>
  	    	</table>
  	    </div>
  	 </main>
   </div>
   
   <script>
   	new Vue({
   		el:'.rows',
   		data:{
   			news_list:[],
   			ss:'맛집'
   		},
   		mounted:function(){
   			let _this = this;
   			axios.get("http://localhost:8080/web/news/find_vue.do",{
   				params:{
   					ss:this.ss
   				}
   			}).then(function(response){
   				console.log(response.data)
   				_this.news_list=response.data
   			})
   		},
   		methods:{
   			find:function(){
   				let _this = this;
   	   			axios.get("http://localhost:8080/web/news/find_vue.do",{
   	   				params:{
   	   					ss:this.ss
   	   				}
   	   			}).then(function(response){
   	   				console.log(response.data)
   	   				_this.news_list=response.data
   	   			})
   			}
   		}
   	})
   </script>
</body>
</html>