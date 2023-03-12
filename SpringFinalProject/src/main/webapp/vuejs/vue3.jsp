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
	width: 1300px;
}

h1{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
	  <h1>지니뮤직 Top100</h1>
	  <div class="row">
	  	<!-- <b-button id="show-btn" variant="outline-danger" @click="showMovie">MV</b-button> -->
	    <music v-bind:musicdata="music_list"></music>
	    <b-modal ref="my-modal" hide-footer :title="music_detail.title" v-if="isShow" id="modal-lg" size="lg">
     		<div class="text-center">
     		  <h4>{{music_detail.title}}</h4>
     		  <iframe :src="'http://youtube.com/embed/'+music_detail.key" style="width: 600px;height: 500px"></iframe>
     		</div>
	     </b-modal>
	  </div>
	</div>
	
	<script>
	  let eventBus = new Vue(); /* ???230310 12:34 */
	  Vue.component('music',{
		  props:['musicdata'],
		  template:'<table class="table">'
		  		+'<tr class="success">'
			  		+'<th class="text-center">순위</th>'
			  		+'<th class="text-center"></th>'
			  		+'<th class="text-center">곡명</th>'
			  		+'<th class="text-center">가수명</th>'
			  		+'<th class="text-center">앨범</th>'
			  		+'<th class="text-center">뮤직비디오</th>'
		  		+'</tr>'
		  		+'<tbody>'
		  		+'<tr v-for="m in musicdata">'
			  		+'<td class="text-center">{{m.no}}</td>'
			  		+'<td class="text-center"><img :src="m.poster" width="30" height="30"></td>'
			  		+'<td>{{m.title}}</td>'
			  		+'<td>{{m.singer}}</td>'
			  		+'<td>{{m.album}}</td>'
			  		+'<td class="text-center"><b-button id="show-btn" variant="outline-danger" @click="showMovie(m.no)">MV</b-button></td>'
		  		+'</tr>'
		  		+'</tbody>'
		  		+'</table>',
		  		methods:{
		  			showMovie:function(value){
		  				eventBus.$emit('showMovieEvent', value)
		  			}
		  		}
	  })
	  new Vue({
		  el:'.container',
		  data:{
			  music_list:[],
			  music_detail:{}
		  },
		  mounted:function(){
			  let _this = this;
			  axios.get("http://localhost:8080/web/music/list.do").then(function(response){
				  _this.music_list=response.data
			  })
		  },
		  
		  updated:function(){
			let _this = this;
			eventBus.$on('showMovieEvent',function(value){
				axios.get('http://localhost:8080/web/music/detail.do',{
					params:{
						no:value
					}
				}).then(function(response){
					console.log(response.data)
					_this.music_detail=response.data
				})
			})
			this.showMovie();
		  },
		  
		  methods:{
			  showMovie:function(){
				  this.$refs['my-modal'].show()
			  }
			  
		  }
	  })
	</script>
</body>
</html>




