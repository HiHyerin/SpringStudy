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
		<h1>검색 결과</h1>
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-right">
						<a href="list.do" class="btn btn-sm btn-danger">목록</a>
					</td>
				</tr>
			</table>
			
			<c:if test="${count==0 }">
				<table class="table">
					<tr>
						<td class="text-center">검색 결과가 없습니다.</td>
					</tr>
				</table>
			</c:if>
			
			<c:if test="${count>0 }">
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
							<td width=45% ><a href="detail.do?no=${vo.no}">${vo.subject }</a></td>
							<td width=15% class="text-center">${vo.name }</td>
							<td width=20% class="text-center">${vo.dbday }</td>
							<td width=10% class="text-center">${vo.hit }</td>
						</tr>
					</c:forEach>
					
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>