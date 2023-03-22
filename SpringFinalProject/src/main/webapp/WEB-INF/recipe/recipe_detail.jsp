<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.datas:hover{
   cursor: pointer
}
</style>
</head>
<body>
<div class="wrapper row3 rows">
  <main class="container clear app"> 
    <div class="one_half first">
      <c:if test="${count==0 }">
        <table class="table">
          <tr>
            <td class="text-center"><h3>등록된 레시피정보가 없습니다</h3></td>
          </tr>
        </table>
      </c:if>
      <c:if test="${count>0 }">
        <table class="table">
          <tr>
           <td class="text-center" colspan="3">
             <img src="${vo.poster }" style="width: 100%">
           </td>
          </tr>
          <tr>
           <td class="text-center" colspan="3">${vo.title }</td>
          </tr>
          <tr>
           <td class="text-center" colspan="3">${vo.content }</td>
          </tr>
          <tr>
            <td class="text-center"><img src="../images/info1.png"></td>
            <td class="text-center"><img src="../images/info2.png"></td>
            <td class="text-center"><img src="../images/info3.png"></td>
          </tr>
          <tr>
            <td class="text-center">${vo.info1 }</td>
            <td class="text-center">${vo.info2 }</td>
            <td class="text-center">${vo.info3 }</td>
          </tr>
        </table> 
        <table class="table">
          <caption>재료</caption>
          <tr>
            <td>
              <ul>
                <c:forTokens items="${vo.data }" delims="," var="d">
                  <li><span class="datas" v-on:click="goodsData('${d }')">${d }</span></li>
                </c:forTokens>
              </ul>
            </td>
          </tr>
        </table>
        <table class="table">
          <caption>조리순서</caption>
          <c:forEach var="fm" items="${tList1 }" varStatus="s">
            <tr>
              <td width=70%>${fm }</td>
              <td width=30%><img src="${iList1[s.index]}" style="width: 200px;height: 100px"></td>
            </tr>
          </c:forEach>
        </table>
      </c:if>
    </div>
    <div class="one_half" v-if="isShow">
      <div>
       <div class="col-md-12" v-for="m in goods_list">
	    <div class="thumbnail">
	      <a href="#">
	        <img :src="m.goods_poster" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p>{{m.goods_name}}</p>
	          <p>{{m.goods_price}}</p>
	        </div>
	      </a>
	    </div>
	   </div>
      </div>
    </div>
  </main>
</div>
<script>
  new Vue({
	  el:'.rows',
	  data:{
		  goods_list:[],
		  isShow:false
	  },
	  methods:{
		  goodsData:function(goods){
			  //alert(goods);
			  this.isShow=true;
			  let _this=this;
			  axios.get("http://localhost:8080/web/recipe/goods_price_vue.do",{
				  params:{
					  goods_name:goods
				  }
			  }).then(function(response){
				  console.log(response.data)
				  _this.goods_list=response.data
			  })
		  }
	  }
  })
</script>
</body>
</html>