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
   width: 1300px;
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
     <div class="inline text-center">
	     <button class="btn btn-lg btn-danger" v-on:click="change(1)">상황</button>
	     <button class="btn btn-lg btn-success" v-on:click="change(2)">감성</button>
	     <button class="btn btn-lg btn-info" v-on:click="change(3)">스타일</button>
	     <button class="btn btn-lg btn-warning" v-on:click="change(4)">날씨/계절</button>
     </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <div class="inline text-center">
        <span class="btn btn-lg btn-primary" v-for="r in recommand_list" style="margin-left: 15px" v-on:click="recommandData(r)">{{r}}</span>
      </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <recommand_result v-bind:redata="recommand_data"></recommand_result>
    </div>
    <div class="dialog" title="맛집 상세보기" v-if="isShow">
     <div class="row">
      <table class="table">
       <tr>
         <td v-for="img in food_detail.poster">
           <img :src="img" style="width: 100%">
         </td>
       </tr>
      </table>
    </div>
    <div style="height: 20px"></div>
    <div class="two_third first">
      <table class="table">
        <tr>
          <td colspan="2">
            <h3><span id="name">{{food_detail.name}}</span>&nbsp;<span style="color:orange">{{food_detail.score}}</span></h3>
          </td>
        </tr>
        <tr>
          <td width=20%>주소</td>
          <td width=80%>
            {{food_detail.addr1}}<br>
            <sub>지번:{{food_detail.addr2}}</sub>
          </td>
        </tr>
        <tr>
          <td width=20%>전화</td>
          <td width=80%>{{food_detail.tel}}</td>
        </tr>
        <tr>
          <th width=20%>음식종류</th>
          <td width=80%>{{food_detail.type}}</td>
        </tr>
        <tr>
          <td width=20%>가격대</td>
          <td width=80%>{{food_detail.price}}</td>
        </tr>
        <tr>
          <td width=20%>영업시간</td>
          <td width=80%>{{food_detail.time}}</td>
        </tr>
        <tr>
          <td width=20%>주차</td>
          <td width=80%>{{food_detail.parking}}</td>
        </tr>
        <tr v-if="food_detail.menu!='no'">
          <td width=20%>메뉴</td>
          <td width=80%>
           <ul>
            <li v-for="m in food_detail.menu">{{m}}원</li>
           </ul>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-right">
           <a href="javascript:history.back()" class="btn btn-xs btn-danger">목록</a>
          </td>
        </tr>
      </table>
    </div>
    <div class="one_third">
      <div id="map" style="width:100%;height:350px;"></div>
    </div>
    </div>
  </main>
</div>
<script>
 Vue.component("recommand_result",{
	 props:['redata'],
	 template:'<div class="text-center">'
	           +'<div class="col-md-3" v-for="vo in redata">'
	           +'<div class="thumbnail">'
	           +'<img :src="vo.poster" style="width:250px;height: 180px" class="details" v-on:click="recommandDetail(vo.fno)">'
	           +'<div class="caption">'
	           +'<p><h4 class="details" v-on:click="recommandDetail(vo.fno)">{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></h4></p>'
	           +'</div>'
	           +'</div>'
	           +'</div>'
	           +'</div>'
	           +'</div>',
	  methods:{
		  recommandDetail:function(fno){
			  this.$parent.recommandDetail(fno,true)
			  /*$('.dialog').dialog({
					 autoOpen:false,
					 modal:true,
					 width:1200,
					 height:800
				 }).dialog("open")*/
			 //this.$refs.dialog.show()
		  }  
	  }
	 
 })
 new Vue({
	 el:'.rows',
	 data:{
		 recommand_list:[],
		 recommand_data:[],
		 food_detail:{},
		 isShow:false
	 },
	/*  mounted:function(){
		  
	 }, */
	 methods:{
		 
		 change:function(no){
			 let _this=this;
			 axios.get("http://localhost:8080/web/food/recommand_change.do",{
				 params:{
					 no:no 
				 }
			 }).then(function(response){
				 console.log(response.data)
				 _this.recommand_list=response.data;
			 })
		 },
		 recommandData:function(r){
			 let _this=this;
			 axios.get("http://localhost:8080/web/food/recommand_result.do",{
				 params:{
					 ss:r
				 }
			 }).then(function(response){
				 console.log(response.data)
				 _this.recommand_data=response.data
			 })
		 },
		 recommandDetail:function(fno,show){
			 //alert("fno="+fno)
			 let _this=this;
			 this.isShow=show
			 axios.get("http://localhost:8080/web/food/food_location_detail_vue.do",{
				 params:{
					 fno:fno
				 }
			 }).then(function(response){
				 console.log(response.data)
				 _this.food_detail=response.data
				 
				 if(window.kakao && window.kakao.maps)
				  {
					  _this.initMap(_this.food_detail.name);
				  }
				  else
				  {
					  _this.addScript();
				  }
				 
			 })
		 }
	 }
 })
</script>
</body>
</html>









