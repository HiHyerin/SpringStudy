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
        <td class="text-right">
          <a href="../board/insert.do" class="btn btn-sm btn-primary">새글</a>
        </td>
      </tr>
    </table>
    <table class="table">
     <thead>
      <tr>
        <th width="10%" class="text-center">번호</th>
        <th width="45%" class="text-center">제목</th>
        <th width="15%" class="text-center">이름</th>
        <th width="20%" class="text-center">작성일</th>
        <th width="10%" class="text-center">조회수</th>
      </tr>
     </thead>
     <tbody>
       <tr v-for="vo in board_list">
        <td width="10%" class="text-center">{{vo.no}}</td>
        <td width="45%"><a :href="'../board/detail.do?no='+vo.no">{{vo.subject}}</a></td>
        <td width="15%" class="text-center">{{vo.name}}</td>
        <td width="20%" class="text-center">{{vo.dbday}}</td>
        <td width="10%" class="text-center">{{vo.hit}}</td>
      </tr>
      <tr>
        <td colspan="5" class="text-center">
          <input type="button" value="이전"class="btn btn-sm btn-danger" v-on:click=prev()>
            {{curpage}} page / {{totalpage}} pages
          <input type="button" value="다음"class="btn btn-sm btn-warning" v-on:click=next()>
        </td>
      </tr>
     </tbody>
    </table>
  </main>
</div>
<script>
  new Vue({
     el:'.rows',
     data:{
        board_list:[],
        curpage:1,
        totalpage:0 //값을 못받았기 때문에 0으로 초기화
     },
     mounted:function(){
        this.send()
     },
     methods:{
        send:function(){
           let _this=this
           axios.get("http://localhost:8080/web/board/list_vue.do",{
              params:{
                 page:this.curpage
              }
           }).then(function(response){
              console.log(response.data)
              _this.board_list=response.data
              _this.curpage=response.data[0].curpage
              _this.totalpage=response.data[0].totalpage
           })
        },
        prev:function(){
           this.curpage=this.curpage>1?this.curpage-1:this.curpage;
           this.send()
        },
        next:function(){
           this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
           this.send()
        }
     }
  })
</script>
</body>
</html>