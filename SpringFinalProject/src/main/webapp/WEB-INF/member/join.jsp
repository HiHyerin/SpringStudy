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
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css"> -->
<!-- <script src="https://code.jquery.com/jquery.js"></script> -->
<!-- <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script> -->
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 500px;
}
h1{
   text-align: center;
}
.details:hover{
   cursor: pointer
}
</style>
</head>
<body>
	<div class="wrapper row3 rows">
	  <main class="container clear"> 
	    <div class="row">
	      <table class="table">
	      	<tr>
	      	  <th width=20% style="color: black">아이디</th>
	      	  <td width=80% class="inline" >
	      	    <input type=text ref="id" v-model="id" size=20 class="input-sm" v-bind:disabled="isDis">
	      	    <input type=button value="아이디 중복체크" class="btn btn-sm btn-danger" v-on:click="idCheck()">
	      	  </td>
	      	</tr>
	      	<tr>
	      	  <th width=20% style="color: black">비밀번호</th>
	      	  <td width=80%>
	      	  	<input type=password ref="pwd" v-model="pwd" size=20 class="input-sm" >
	      	  </td>
	      	</tr>
	      	<tr>
	      	  <th width=20% style="color: black">이름</th>
	      	  <td width=80%>
	      	  	<input type=text ref="name" v-model="name" size=20 class="input-sm">
	      	  </td>
	      	</tr>
	      	<tr>
	      	  <td colspan="2" class="text-center">
	      	  	<input type=button value="회원가입" class="btn btn-sm btn-success" v-on:click="memberJoin()">
	      	  	<input type=button value="취소" class="btn btn-sm btn-info" onclick="javascript:history.back()">
	      	  </td>
	      	</tr>
	      </table>
	    </div>
	    
	    <script>
	      new Vue({
	    	  el:'.rows',
	    	  data:{
	    		  id:'',
	    		  pwd:'',
	    		  name:'',
	    		  msg:'',
	    		  isDis:false
	    	  },
	    	  // 이벤트 처리
	    	  methods:{
	    		 idCheck:function(){
	    			  if(this.id === ''){
	    				  this.$refs.id.focus()
	    				  return
	    			  }
	    			  let _this = this
	    			  axios.get('http://localhost:8080/web/member/idcheck_vue.do',{
	    				  params:{
	    					  id:this.id
	    				  }
	    			  }).then(function(response){ // then안에서는 _this
	    				  let result = response.data
	    				  if(result === 'yes'){
	    					  alert(_this.id+" 는(은) 사용 가능한 아이디 입니다.")
	    					  _this.isDis=true //활성화 기능 사용 할 땐 v-bind
	    				  }else{
	    					  alert(_this.id+" 는(은) 이미 사용중인 아이디 입니다.")
	    					  _this.id=''
	    					  _this.$refs.id.focus()
	    				  }
	    			  })
	    		  },
	    		  memberJoin:function(){
	    			  if(this.id === ""){
	    				  alert("아이디 중복체크버튼을 클릭하세요")
	    				  this.$refs.id.focus();
	    				  return;
	    			  }
	    			  if(this.pwd ===""){
	    				  this.$refs.pwd.focus();
	    				  return;
	    			  }
	    			  if(this.name === ""){
	    				  this.$refs.name.focus();
	    				  return;
	    			  }
	    			  let _this = this
	    			  axios.get('http://localhost:8080/web/member/insert_vue.do',{
	    				  params:{
	    					  id:_this.id,
	    					  pwd:_this.pwd,
	    					  name:_this.name
	    				  }
	    			  }). then(function(response){
	    				  let result = response.data
	    				  if(result === "yes"){
	    					  alert(_this.id+"님 회원가입 되었습니다.")
	    					  location.href="../main/main.do"
	    				  }else{
	    					  alert("회원 가입에 실패하였습니다.")
	    					  _this.isDis = false;
	    					  _this.id = '';
	    					  _this.pwd = '';
	    					  _this.name = '';
	    					  _this.$refs.id.focus()
	    				  }
	    			  })
	    		  }
	    	  }
	      })
	    </script>
	  </main>
	</div>

</body>
</html>