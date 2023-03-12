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
<style type="text/css">
.container{
	margin-top: 50px;
}

.row{
	margin: 0px auto;
	width: 900px;
}

h1{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
	  <h1>사원목록</h1>
	  <div class="row">
	    <template>
	      <div class="overflow-auto">
	        <b-pagination
	        	v-model="currentPage"
	        	:total-rows="rows"
	        	:per-page="perPage"
	        	aria-controls="emp-table"
	        >
	        </b-pagination>
	        <b-table
	        	id="emp-table"
	        	:items="emp_list"
	        	:per-page="perPage"
	        	:current-page="currentPage"
	        >
	        </b-table> 
	      </div>
	    </template>
	  </div>
	</div>
	<script>
	  new Vue({
		el:'.container',
		data:{
			emp_list:[],
			perPage:5,
			currentPage:1
		},
		mounted:function(){
			let _this = this
			axios.get("http://localhost:8080/web/emp/list.do").then(function(response){
				_this.emp_list = response.data
			})
		},
		computed:{
			rows(){
				return this.emp_list.length
			}
		}
	  })
	</script>
</body>
</html>