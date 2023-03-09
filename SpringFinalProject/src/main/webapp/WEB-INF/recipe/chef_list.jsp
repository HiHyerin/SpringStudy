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
.images:hover{
	cursor:pointer
}
</style>
</head>
<body>
	<div class="wrapper row3 rows">
	  <main class="container clear">
	   	<div class="one_half first">
	   		<chef_main v-bind:chefdata='chef_list' v-bind:chef_curpage="curpage" v-bind:chef_totalpage="totalpage"></chef_main>
	   		<!-- <table class="table">
	   		  <tr>
	   		    <td>
	   		      <table class="table" v-for="vo in chef_list">
	   		        <tr>
	   		          <td width=30% class="text-center" rowspan="2">
	   		            <img :src="vo.poster" style="width: 120px;height: 120px" class="img-circle">
	   		          </td>
	   		          <td colspan="4"><h3 style="color: orange">{{vo.chef}}</h3></td>
	   		        </tr>
	   		        <tr>
	   		          <td class="text-center"><img src="../images/mc1.png">&nbsp;{{vo.mc1}}</td>
	   		          <td class="text-center"><img src="../images/mc3.png">&nbsp;{{vo.mc3}}</td>
	   		          <td class="text-center"><img src="../images/mc7.png">&nbsp;{{vo.mc7}}</td>
	   		          <td class="text-center"><img src="../images/mc2.png">&nbsp;{{vo.mc2}}</td>
	   		        </tr>
	   		      </table>
	   		    </td>
	   		  </tr>
	   		  <tr>
	   		    <td class="text-center">
	   		       <input type=button class="btn btn-sm btn-danger" value="이전" v-on:click="prev()">
	   		       {{curpage}} page / {{totalpage}} pages
	   		       <input type=button class="btn btn-sm btn-success" value="다음" v-on:click="next()">
	   		    </td>
	   		  </tr>
	   		</table> -->
	   	</div>
        <div class="one_half">
        	<h3 class="text-center">{{chef_name}}님의 레시피</h3>
           <div class="col-md-6" v-for="m in chef_make">
			    <div class="thumbnail">
			      <a href="#">
			        <img :src="m.poster" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p>{{m.title}}</p>
			          <p>{{m.chef}}</p>
			        </div>
			      </a>
			    </div>
			  </div>
        </div>
	  </main>
	</div>

	<script>
	let eventBus = new Vue();
	Vue.component('chef_main',{
		props:['chefdata','chef_curpage','chef_totalpage'], // 변수 props(속성값)
		template:'<table class="table">'
 		  +'<tr>'
 		    +'<td>'
 		      +'<table class="table" v-for="vo in chefdata">'
 		        +'<tr>'
 		          +'<td width=30% class="text-center" rowspan="2">'
 		            +'<img :src="vo.poster" style="width: 120px;height: 120px" class="img-circle images" v-on:click="showChef(vo.chef)">'
 		          +'</td>'
 		          +'<td colspan="4"><h3 style="color: orange">{{vo.chef}}</h3></td>'
 		        +'</tr>'
 		        +'<tr>'
 		          +'<td class="text-center"><img src="../images/mc1.png">&nbsp;{{vo.mc1}}</td>'
 		          +'<td class="text-center"><img src="../images/mc3.png">&nbsp;{{vo.mc3}}</td>'
 		          +'<td class="text-center"><img src="../images/mc7.png">&nbsp;{{vo.mc7}}</td>'
 		          +'<td class="text-center"><img src="../images/mc2.png">&nbsp;{{vo.mc2}}</td>'
 		        +'</tr>'
 		      +'</table>'
 		    +'</td>'
 		  +'</tr>'
 		  +'<tr>'
 		    +'<td class="text-center">'
 		       +'<input type=button class="btn btn-sm btn-danger" value="이전" v-on:click="this.$parent.prev">'
 		       +'{{chef_curpage}} page / {{chef_totalpage}} pages' 
 		       +'<input type=button class="btn btn-sm btn-success" value="다음" v-on:click="this.$parent.next">'
 		    +'</td>'
 		  +'</tr>'
 		+'</table>',
 		methods:{
 			showChef:function(value){
 				eventBus.$emit('showChefEvent',value)
 			}
 		}
	})
	
	  new Vue({
		el:'.rows',
		data:{
			chef_list:[],
			curpage:1,
			totalpage:0,
			chef_name:'',
			chef_make:[]
		},
		mounted:function(){
			this.pageChange();
		},
		updated:function(){
			let _this=this;
			eventBus.$on('showChefEvent', function(value){
			
			_this.chef_name=value;
			axios.get("http://localhost:8080/web/recipe/chef_make_vue.do",{
				params:{
					chef:_this.chef_name
				}
			}).then(function(response){
				console.log(response.data)
				_this.chef_make=response.data
			})
		  })
		},
		methods:{
			pageChange:function(){
			let _this=this;
		    axios.get("http://localhost:8080/web/recipe/chef_list_vue.do",{
			params:{
				page:_this.curpage
			}
		}).then(function(response){
			_this.chef_list=response.data;
			_this.curpage = response.data[0].curpage;
			_this.totalpage = response.data[0].totalpage;
		})
			},
			prev:function(){
				this.curpage = this.curpage>1?this.curpage-1:this.curpage
				this.pageChange();
			},
			next:function(){
				this.curpage = this.curpage<this.totalpage?this.curpage+1:this.curpage
				this.pageChange();
			}
		}
	  })
	</script>
</body>
</html>