<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
	
}
.row{
	margin: 0px auto;
	width: 800px;
}

h1{
	text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let fileIndex = 0;
$(function(){
	$('#addBtn').click(function(){
		console.log("addBtn누름"),
		$('#user-table').append(
			'<tr id="m'+(fileIndex)+'">'
			+'<td width="20%">File '+(fileIndex+1)+'</td>'
			+'<td width="80%"><input type=file name=files['+fileIndex+']></td>'
			+'</tr>'
		)
		fileIndex++;
	})
	$('#removeBtn').click(function(){
		if(fileIndex>0){
			$('#m'+(fileIndex-1)).remove();
			fileIndex--;
		}
		
	})
})
</script>
</head>
<body>
  <div class="container">
  	<h1>글쓰기</h1>
	<div class="row">
	  <form method=post action="insert_ok.do" enctype="multipart/form-data">
		<table class="table">
		  <tr>
		  	<th width=15% class=text-right">이름</th>
		  	<td width=85%>
		  		<input type="text" name=name size=15 class="input-sm">
		  	</td>
		  </tr>
		  <tr>
		  	<th width=15% class=text-right">제목</th>
		  	<td width=85%>
		  		<input type="text" name=subject size=50 class="input-sm">
		  	</td>
		  </tr>
		  <tr>
		  	<th width=15% class=text-right">내용</th>
		  	<td width=85%>
		  		<textarea rows="10" cols="80" name="content"></textarea>
		  	</td>
		  </tr>
		  <tr>
		  	<th width=15% class=text-right">첨부파일</th>
		  	<td width=85%>
		  		<table class="table">
		  			<tr>
		  			  <td class="text-right">
		  			  	<input type=button value="추가" class="btn btn-xs btn-info" id="addBtn">
		  			  	<input type=button value="취소" class="btn btn-xs btn-warning" id="removeBtn">
		  			  </td>
		  			</tr>
		  		</table>
		  		<table class="table" id="user-table">
		  			
		  		</table>
		  	</td>
		  </tr>
		  <tr>
		  	<th width=15% class=text-right">비밀번호</th>
		  	<td width=85%>
		  		<input type="password" name=pwd size=10 class="input-sm">
		  	</td>
		  </tr>
		  <tr>
		  	<td colspan="2" class="text-center">
		  		<input type="submit" value = "전송" class="btn btn-sm btn-danger">
		  		<input type="button" value = "취소" class="btn btn-sm btn-warning" onclick="javascript:history.back()">
		  	</td>
		  </tr>
		</table>
	  </form>
	</div>
  </div>
</body>
</html>












