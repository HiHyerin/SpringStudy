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
$(function(){
	$('#subBtn').hide();
	$('#pwd').keyup(function(){
		let pwd = $(this).val();
		let no = $('#no').val();
		$.ajax({
			type:'post',
			url:'pwd_check.do',
			data:{"pwd":pwd, "no":no},
			success:function(response){
				if(response == "yes"){
					$('#print').text("비밀번호가 맞습니다")
					$('#subBtn').show();
					$('#pwd').prop("disabled",true) // 비밀번호 비활성화
				}else{
					$('#print').text("비밀번호가 틀립니다!!")
					$('#subBtn').hide()
				}
					
			}
			
		})
	})
	
})
</script>
</head>
<body>
  <div class="container">
  	<h1>수정하기</h1>
	<div class="row">
	  <form method=post action="update_ok.do" >
		<table class="table">
		  <tr>
		  	<th width=15% class=text-right">이름</th>
		  	<td width=85%>
		  		<input type="text" name=name size=15 class="input-sm" value="${vo.name }">
		  		<input type="hidden" name=no value="${vo.no }" id="no">
		  	</td>
		  </tr>
		  <tr>
		  	<th width=15% class=text-right">제목</th>
		  	<td width=85%>
		  		<input type="text" name=subject size=50 class="input-sm" value="${vo.subject }">
		  	</td>
		  </tr>
		  <tr>
		  	<th width=15% class=text-right">내용</th>
		  	<td width=85%>
		  		<textarea rows="10" cols="80" name="content">${vo.content }</textarea>
		  	</td>
		  </tr>
		  <tr>
		  	<th width=15% class=text-right">비밀번호</th>
		  	<td width=85%>
		  		<input type="password" name=pwd size=10 class="input-sm" id="pwd">
		  		<span id="print" style="color:red"></span>
		  	</td>
		  </tr>
		  <tr>
		  	<td colspan="2" class="text-center">
		  		<input type="submit" value = "수정" class="btn btn-sm btn-danger" id="subBtn">
		  		<input type="button" value = "취소" class="btn btn-sm btn-warning" onclick="javascript:history.back()">
		  	</td>
		  </tr>
		</table>
	  </form>
	</div>
  </div>
</body>
</html>












