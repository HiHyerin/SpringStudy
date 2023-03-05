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
.container-fluid{
   margin-top: 50px;
}

.row{
   margin: 0px auto;
   width: 100%;
}

h1{
   text-align: center
}
.ddd:hover{
  cursor: pointer
}


</style>
</head>
<body>
	<div class="container-fluid">
	<div class="col-md-8">
		<div class="col-md-3" v-for="vo in food_list">
			<div class="thumbnail">
		        <img :src="vo.poster" style="width:100%" v-on:click="foodDetail(vo.no)">
		        <div class="caption">
		          <p>{{vo.title}}</p>
		        </div>
		    </div>
		</div>
		<div class="row">
		<div class="text-center">
			<input type="button" class="btn btn-sm btn-warning" value="이전" @click="prev()">
			{{curpage}} page / {{totalpage}} pages
			<input type="button" class="btn btn-sm btn-info" value="다음" @click="next()">
		</div>
	</div>
     </div>
     
     
	<div class="col-md-4" v-show="isShow">
	  <table class="table">
        <tr>	
        	<td><img :src="vo2.poster" style="width:100%"></td>
        </tr>
       </table>
			  
       <div style="height: 20px"></div>
        <table class="table">
         <tr>
           <td colspan="2">
            <h3>{{vo2.title }}&nbsp;<span style="color:orange">{{vo2.score }}</span></h3>
           </td>
         </tr>
         <tr>
           <th width=10%>주소</th>
           <td width=90%>{{vo2.addr }}</td>
         </tr>
         <tr>
           <th width=10%>전화</th>
           <td width=90%>{{vo2.tel }}</td>
         </tr>
         <tr>
           <th width=10%>음식종류</th>
           <td width=90%>{{vo2.type }}</td>
         </tr>
         <tr>
           <th width=10%>주차</th>
           <td width=90%>{{vo2.parking }}</td>
         </tr>
         <tr>
           <th width=10%>영업시간</th>
           <td width=90%>{{vo2.time }}</td>
         </tr>
        
	         <tr v-if="vo2.menu!='no'">
	           <th width=10%>메뉴</th>
	           <td width=90%>
	            <ul>
	              <li v-for="m in menus">{{m }}</li>
	            </ul>
	           </td>
	         </tr>
        
        </table>
	</div>	
	
	</div>
	
	
	<script>
	  new Vue({
		  el:'.container-fluid',
		  data:{
			  food_list:[], 
			  curpage:1,
			  totalpage:0,
			  isShow:false,
			  vo2:{},
			  title:'',
			  menus:[]
			  
		  },
		  mounted:function(){
			  this.change()
		  },
		  methods:{
			  /*//////////////////// page///////////////////// */
			  prev:function(){
					this.curpage=this.curpage>1?this.curpage-1:this.curpage;
					this.change()
				},
				next:function(){
					this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
					this.change()
				},
				search:function(){
					this.curpage=1;
					this.change();
				},
				/*/////////////////////////////////////////////// ?no=1*/
			  change:function(){
				  let _this=this
				  axios.get('http://localhost:8080/web/jeju/food_list_vue.do',{
					params:{
						page:_this.curpage,
						
					}  
				  }).then(function(response){
					  console.log(response.data)
					  _this.food_list = response.data;
					  _this.title=response.data[0].title;
	        		  _this.subject=response.data[0].subject;
	        		  _this.curpage=response.data[0].curpage;
					  _this.totalpage=response.data[0].totalpage;
				  })
			  },
			  foodDetail:function(no){
				  this.isShow = true
				  let _this = this
				  axios.get('http://localhost:8080/web/jeju/food_detail_vue.do',{
					  params:{
						  no:no
					  }
				  }).then(function(response){
						console.log(response.data)
						_this.vo2=response.data;
						_this.menus=_this.vo2.menu.split("^")
				  	
				  	})
				  }
		  }
	  })
	</script>
</body>
</html>