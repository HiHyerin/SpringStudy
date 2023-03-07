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
  		<table class="table">
  			<tr>
  			   <th width=20% class="text-center">번호</th>
  			   <td width=30% class="text-center">{{board_detail.no}}</td>
  			   <th width=20% class="text-center">작성일</th>
  			   <td width=30% class="text-center">{{board_detail.dbday}}</td>
  			</tr>
  			<tr>
  			   <th width=20% class="text-center">이름</th>
  			   <td width=30% class="text-center">{{board_detail.name}}</td>
  			   <th width=20% class="text-center">조회수</th>
  			   <td width=30% class="text-center">{{board_detail.hit}}</td>
  			</tr>
  			<tr>
  			   <th width=20% class="text-center">제목</th>
  			   <td colspan="3"></td>
  			</tr>
  			<tr>
  			  <td colspan="4" class="text-left"	valign="top" height="200"><pre style="white-space: pre-wrap;background-color: white;boarder:none">{{board_detail.content}}</pre></td>
  			</tr>
  			<tr>
  			  <td colspan="4" class="text-center">
  			    <a :href="'../board/update.do?no='+board_detail.no" class="btn btn-xs btn-danger">수정</a>
  			    <a :href="'../board/delete.do?no='+board_detail.no" class="btn btn-xs btn-success">삭제</a>
  			    <a href="../board/list.do" class="btn btn-xs btn-info">목록</a>
  			  </td>
  			</tr>
  		</table>	
  	</main>
  </div>
  <script>
    new Vue({
    	el:'.rows',
    	data:{
    		no:${no},
    		board_detail:{}
    	},
    	mounted:function(){
    		let _this = this
    		axios.get("http://localhost:8080/web/board/detail_vue.do",{
    			params:{
    				no:this.no
    			}
    		}).then(function(response){
    			_this.board_detail = response.data
    		})
    	}
    })
  </script>
</body>
</html>