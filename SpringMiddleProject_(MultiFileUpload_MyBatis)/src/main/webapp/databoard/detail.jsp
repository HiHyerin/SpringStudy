<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
	let i=0;
	$(function(){ // window.onload => main
		$('#delSpan').click(function(){
			if(i==0){
				$('#del').show();
				$('#delSpan').text("취소");
				i=1;
			}
			else{
				$('#del').hide();
				$('#delSpan').text("삭제");
				i=0;
			}
		})

	
	$('#delBtn').on("click",function(){
		let pwd=$('#pwd').val();
		let no=$('#no').text();
		// let pwd = document.getQuerySelector("#pwd")
		if(pwd.trim()==""){
			$('#pwd').focus();
			return;
		}
		
		$.ajax({
			type:'post',
			url:'delete.do',
			data:{"no":no, "pwd":pwd},
			success:function(response){
				let res = response.trim();
				if(res=='yes'){
					location.href="list.do"
				}
				else{
					alert("비밀번호가 틀립니다!!\n다시입력하세요")
					$('#pwd').val("")
					$('#pwd').focus()
				}
			}
		})
	})
})

</script>
</head>
<body>
	<div class="container">
		<h1>상세보기</h1>
		<div class="row">
			<table class="table">
				<tr>
					<th width=20% class="text-center success">번호</th>
					<td width=30% class="text-center" id="no">${vo.no }</td>
					<th width=20% class="text-center success">작성일</th>
					<td width=30% class="text-center">${vo.dbday}
				</tr>
				<tr>
					<th width=20% class="text-center success">이름</th>
					<td width=30% class="text-center">${vo.name }</td>
					<th width=20% class="text-center success">조회수</th>
					<td width=30% class="text-center">${vo.hit }</td>
				</tr>
				<tr>
					<th width=20% class="text-center success">제목</th>
					<td colspan="3">${vo.subject }
				</tr>
				<c:if test="${vo.filecount>0 }">
					<tr>
						<th width=20% class="text-center success">첨부파일</th>
						<td colspan="3">
							<ul>
								<c:forEach var="fn" items="${nList }" varStatus="s">
									<li><a href="download.do?fn=${fn }">${fn }(${ sList[s.index]}Bytes)</li>
								</c:forEach>
							</ul>
							</td>
						</td>
					</tr>
				</c:if>
				<tr>
					<td colspan="4" class="text-left" valign="top" height="200"><pre style="white-space: pre-wrap;border: none;background-color:white">${vo.content }</pre></td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<a href="update.do?no=${vo.no }" class="btn btn-xs btn-info">수정</a>
						<span class="btn btn-xs btn-success" id="delSpan">삭제</span>
						<a href="list.do" class="btn btn-xs btn-warning">목록</a>
					</td>
				</tr>
				<tr id="del" style="display:none">
					<td colspan="4" class="text-right">
						비밀번호:<input type=password name = pwd size=10 class="input-sm" id="pwd">
						<input type=button class="btn btn-sm btn-danger" value="삭제" id="delBtn">
					</td>
 				</tr>
			</table>
		</div>
	</div>
</body>
</html>