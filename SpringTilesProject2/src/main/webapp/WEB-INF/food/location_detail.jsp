<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="container" id="app">
     <div class="row">
       <table class="table">
        <tr>
           <td v-for="img in vo.poster.split('^')"><img :src="img" style="width: 100%"></td>
        </tr>
       </table>
     </div>
     <div style="height: 20px"></div>
     <div class="row">
      <div class="col-sm-8">
        <table class="table">
         <tr>
           <td colspan="2">
            <h3>{{vo.name }}&nbsp;<span style="color:orange">{{vo.score }}</span></h3>
           </td>
         </tr>
         <tr>
           <th width=10%>주소</th>
           <td width=90%>{{vo.address }}</td>
         </tr>
         <tr>
           <th width=10%>전화</th>
           <td width=90%>{{vo.tel }}</td>
         </tr>
         <tr>
           <th width=10%>음식종류</th>
           <td width=90%>{{vo.type }}</td>
         </tr>
         <tr>
           <th width=10%>가격대</th>
           <td width=90%>{{vo.price }}</td>
         </tr>
         <tr>
           <th width=10%>주차</th>
           <td width=90%>{{vo.parking }}</td>
         </tr>
         <tr>
           <th width=10%>영업시간</th>
           <td width=90%>{{vo.time }}</td>
         </tr>
         <tr>
         <tr v-if="vo.menu!='no'">
          <th width=10%>메뉴</th>
          <td width=90%>
          <ul>
             <li v-for="m in vo.menu.split('원')">{{m }}원</li>
          </ul>
          </td>
        </tr>
        </table>
        </div>
     <div class="col-sm-4">
     </div>
 </div>
</div>
<script>
      <%-- 
      Vue 동작 생명주기
      1. created => new Vue()
      2. mounted => onload() =>$(function())
      3. updated => 수정시
      4. destoryed => 종료
      --%>
   new Vue({
      el:'#app', //el : element (어디서부터 제어할지!)
      data:{
         fno:${fno}, //model.addAttribute("fno",fno); 
         vo:{}
      },
      mounted:function(){
         let _this=this;
         axios.get("http://localhost:8080/web/food/location_detail_vue.do",{
            params:{
               fno:_this.fno
            }
         }).then(function(response){
            console.log(response.data)
            _this.vo=response.data;
         })
      }
   })
</script>
</body>
</html>