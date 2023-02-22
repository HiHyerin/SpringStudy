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
	width: 900px;
}

h1{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h1>내용보기</h1>
		<div class="row">
			<table class="table">
				<tr>
					<td width=20% class="text-center danger">번호</td>
					<td width=30% class="text-center">${vo.no }</td>
					<td width=20% class="text-center danger">작성일</td>
					<td width=30% class="text-center">${vo.dbday }</td>
				</tr>
				<tr>
					<td width=20% class="text-center danger">이름</td>
					<td width=30% class="text-center" >${vo.name }</td>
					<td width=20% class="text-center danger">조회수</td>
					<td width=30% class="text-center">${vo.hit}</td>
				</tr>
				<tr>
					<td width=20% class="text-center danger">제목</td>
					<td colspan="3">${vo.subject }</td>
				</tr>
				<tr>
					<td colspan = "4" class="text-left" valign="top" height="200">
					<pre style="white-space: pre-wrap; background-color: white; border:none">
					${vo.content }</pre></td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<a href="update.do?no=${vo.no }" class="btn btn-xs btn-danger">수정</a>
						<a href="delete.do?no=${vo.no }" class="btn btn-xs btn-info">삭제</a>
						<a href="list.do" class="btn btn-xs btn-primary">목록</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>