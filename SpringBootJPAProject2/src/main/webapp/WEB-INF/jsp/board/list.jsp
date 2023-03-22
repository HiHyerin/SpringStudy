<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
		<h1>게시판</h1>
		<div class="row">
		  <table class="table">
		  	<tr>
		  		<td>
		  			<a href="/insert" class="btn btn-sm btn-success">새글</a>
		  		</td>
		  	</tr>
		  </table>
			<table class="table table-striped">
				<tr class="success">
					<th width=10% class="text-center">번호</th>
					<th width=45% class="text-center">제목</th>
					<th width=15% class="text-center">이름</th>
					<th width=20% class="text-center">작성일</th>
					<th width=10% class="text-center">조회수</th>
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td width=10% class="text-center">${vo.no }</td>
						<td width=45% ><a href="/detail?no=${vo.no}">${vo.subject }</a></td>
						<td width=15% class="text-center">${vo.name }</td>
						<td width=20% class="text-center">${vo.regdate }</td>
						<td width=10% class="text-center">${vo.hit }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2">
					  <form method=post action="find.do">
						Search:
						<select name="fs" class="input-sm">
							<option value="name">이름</option>
							<option value="subject">제목</option>
							<option value="content">내용</option>
						</select>
						<input type=text name=ss class="input-sm" size=15>
						<input type=submit value = "검색" class="btn btn-sm btn-danger">
					  </form>
					</td>
				</tr>
				<tr>
					<td colspan="5" class="text-center">
						<a href="/list?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-info">이전</a>
						${curpage } page/ ${totalpage } pages
						<a href="/list?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-warning">다음</a>
					</td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>