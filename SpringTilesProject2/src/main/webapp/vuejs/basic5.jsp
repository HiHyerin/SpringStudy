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
      <div class="col-sm-4">
        <div class="text-center">
          <button class="btn btn-sm btn-info" v-on:click="change(1)">믿고 보는 맛집 리스트</button>
          <button class="btn btn-sm btn-success" v-on:click="change(2)">지역별 맛집 리스트</button>
          <button class="btn btn-sm btn-warning" v-on:click="change(3)">메뉴별 맛집 리스트</button>
        </div>
   
        <div style="height: 10px"></div>
         <div class="col-md-6" v-for="vo in cate_list">
		    <div class="thumbnail">
		        <img :src="vo.poster" style="width:200px;height: 150px" v-on:click="foodList(vo.cno)">
		        <div class="caption">
		          <p>{{vo.title}}</p>
		        </div>
		    </div>
		  </div>
      </div>
      <div class="col-sm-3">
        <div class="jumbotron">
         <h4 class="text-center">{{title }}</h4>
         <h5 class="text-center">{{subject }}</h5>
        </div>
        
        <table class="table">
        <tr>
          <td>
             <table class="table" v-for="fvo in food_list">
               <tr>
                 <td width=30% class="text-center" rowspan="4">
                   <img :src="fvo.poster" style="width: 100%" class="img-rounded ddd" v-on:click="foodDetail(fvo.fno)">
                 </td>
                 <td width=70%>
                   <h3 v-on:click="foodDetail(fvo.fno)" class="ddd">{{fvo.name }}&nbsp;<span style="color:orange">{{fvo.score }}</span></h3>
                 </td>
               </tr>
               <tr>
                 <td width=70%>{{fvo.address }}</td>
								   
			  
               </tr>
               <tr>
                 <td width=70%>{{fvo.tel }}</td>
							   
			  
               </tr>
               <tr>
                 <td width=70%>{{fvo.type}}</td>
								
			  
               </tr>
             </table>
          </td>
        </tr>
      </table>
      </div>
      <div class="col-sm-5" v-show="isShow">
        <table class="table">
        <tr>
          
            <td v-for="img in posters" ><img :src="img" style="width: 100%"></td>
         
        </tr>
       </table>
			  
       <div style="height: 20px"></div>
        <table class="table">
         <tr>
           <td colspan="2">
            <h3>{{vo2.name }}&nbsp;<span style="color:orange">{{vo2.score }}</span></h3>
           </td>
         </tr>
         <tr>
           <th width=10%>주소</th>
           <td width=90%>{{vo2.address }}</td>
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
           <th width=10%>가격대</th>
           <td width=90%>{{vo2.price }}</td>
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
	              <li v-for="m in menus">{{m }}원</li>
	            </ul>
	           </td>
	         </tr>
        
        </table>
     </div>
     
      </div>
      </div>
    <script>
     new Vue({
    	 el:'.container-fluid',
    	 data:{
    		 cate_list:[],
    		 food_list:[],
    		 vo2:{},
    		 title:'',
    		 subject:'',
    		 isShow:false,
    		 posters:[],
    		 menus:[]
    	 },
    	 // http://localhost/web/food/category_vue.do?no=1
    	 mounted:function(){
    		 let _this=this
    		 axios.get('http://localhost:8080/web/food/category_vue.do',{
    			 params:{
    				 no:1
	  
    			 }
    		 // then => success:function(response)
    		 }).then(function(response){
    			 // response=>json
    			 console.log(response.data)
    			 _this.cate_list=response.data;
    			 
    		 })
    	 },
    	 methods:{
    		 change:function(no){
    			 let _this=this
        		 axios.get('http://localhost:8080/web/food/category_vue.do',{
        			 params:{
        				 no:no
	   
        			 }
        		 // then => success:function(response)
        		 }).then(function(response){
        			 // response=>json
        			 console.log(response.data)
        			 _this.cate_list=response.data;
        			 
        		 })
    		 },
																		 
    		 foodList:function(cno){
    			 let _this=this
        		 axios.get('http://localhost:8080/web/food/food_list_vue.do',{
        			 params:{
        				 no:cno
	   
        			 }
        		 // then => success:function(response)
        		 }).then(function(response){
        			 // response=>json
        			 console.log(response.data)
        			 _this.food_list=response.data;
        			 _this.title=response.data[0].title;
        			 _this.subject=response.data[0].subject;
        		 })
    		 },
																		 
    		 foodDetail:function(fno){
    			 this.isShow=true
    			 let _this=this
        		 axios.get('http://localhost:8080/web/food/food_detail_vue.do',{
        			 params:{
        				 fno:fno
	   
        			 }
        		 // then => success:function(response)
        		 }).then(function(response){
        			 // response=>json
        			 console.log(response.data)
        			 _this.vo2=response.data;
        			 _this.posters=_this.vo2.poster.split('^')
        		     _this.menus=_this.vo2.menu.split("원")
        		 })
    		 }
    		 
    	 }
     })
    </script>
</body>
</html>






