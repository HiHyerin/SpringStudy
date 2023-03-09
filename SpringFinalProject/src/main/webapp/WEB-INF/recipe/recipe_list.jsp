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
</head>
<body>
	<div class="wrapper row3 rows">
	  <main class="container clear"> 
	    <!-- main body --> 
	    <!-- ################################################################################################ -->
	    <div class="content"> 
	      <!-- ################################################################################################ -->
	      <div id="gallery">
	        <figure>
	          <header class="heading">총 <span style="color:green;font-size: 35px">{{count}}</span>개의 맛있는 레시피가 있습니다.</header>
	          <ul class="nospace clear">
	            <li class="one_quarter first" v-for="(vo,index) in recipe_list" v-if="index%4==0">
	              <a href="#"><img :src="vo.poster" :title="vo.title"></a>
	            </li>
	            <li class="one_quarter" v-else>
	              <a href="#"><img :src="vo.poster" :title="vo.title"></a>
	            </li>
	          </ul>
	        </figure>
	      </div>
	      <!-- ################################################################################################ --> 
	      <!-- ################################################################################################ -->
	      <nav class="pagination">
	        <ul>
	          <li v-if="startPage>1"><a v-on:click="prev()">&laquo; Previous</a></li>
	          <li class="current" v-for="i in range(startPage,endPage)" v-if="i===curpage"><a v-on:click="pageClick(i)">{{i}}</a></li>
	          <li v-else><a v-on:click="pageClick(i)">{{i}}</a></li>
	          <li v-if="endPage<totalpage"><a v-on:click="next()">Next &raquo;</a></li>
	        </ul>
	        <!-- 
	        	range 함수 없기때문에 script에 만들기
	        	v-if / v-else
	         -->
	      </nav>
	      <!-- ################################################################################################ --> 
	    </div>
	    <!-- ################################################################################################ --> 
	    <!-- / main body -->
	    <div class="clear"></div>
	  </main>
	</div>	
	<script>
	new Vue({
		el:'.rows',
		data:{ /* 멤버변수 = this */
			recipe_list:[],
			curpage:1,
			totalpage:0,
			startPage:0,
			endPage:0,
			count:0
		},
		// _vue.do?page=1
		mounted:function(){
			this.pageChange();
		},
		methods:{
			pageChange:function(){
				let _this = this;
				axios.get("http://localhost:8080/web/recipe/recipe_list_vue.do",{
					params:{
						page:this.curpage
					}
				}).then(function(response){
					console.log(response.data);
					_this.recipe_list = response.data;
					_this.curpage = response.data[0].curpage
					_this.totalpage = response.data[0].totalpage
					_this.startPage = response.data[0].startPage
					_this.endPage = response.data[0].endPage
					_this.count = response.data[0].count
				})
			},
			
			range: function(min,max){
		    	   let array = [],
		    	   j = 0;
		    	   for(let i=min; i<=max; i++){
		    		   array[j] = i;
		    		   j++;
		    	   }
		    	   return array;
		       },
		       prev:function(){
		    	   // startPage => 1, 11m 21...
		    	   this.curpage = this.startPage-1;
		    	   this.pageChange();
		       },
		       next:function(){
		    	// endPage => 10,20,30,...
		    	   this.curpage = this.endPage +1;
		    	   this.pageChange();
		       },
		       pageClick:function(page){
		    	   this.curpage=page
		    	   this.pageChange();
		       }
		}
	 })
	</script>			
</body>
</html>