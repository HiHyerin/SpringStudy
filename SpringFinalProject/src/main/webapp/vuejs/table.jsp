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
	  <h1>사원 목록</h1>
	  <div class="row">
	    <template>
	    	<div>
	    	 	<b-table striped hover :items="emp_list" :fields="fields"></b-table>
	    	</div>
	    	<div>
	    		<b-button variant="danger" v-b-modal.modal-1>클릭</b-button>
	    		<b-modal id="modal-1" title="상세보기">
	    			<p class="my-4">Hello</p>
	    		</b-modal>
	    	</div>
	    </template>
	  </div>
	</div>
	
	<script>
		new Vue({
			el:'.container',
			data:{
				fields:['empno','ename','job','hiredate','sal','dname','loc'],
				emp_list:[]
			},
			mounted:function(){
				let _this = this
				axios.get("http://localhost:8080/web/emp/list.do").then(function(response){
					_this.emp_list = response.data;
				})
			}
		})
	</script>
</body>
</html>