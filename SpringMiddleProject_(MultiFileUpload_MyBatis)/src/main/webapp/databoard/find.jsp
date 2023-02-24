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
	width: 960px;
}

h1{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h1>검색결과</h1>
		<div class="row">
			<c:if test="${count<1 }">
			<table class="table">
				<tr>
					<td class="text-center">
						<h3>검색된 결과가 없습니다.</h3>
					</td>
				</tr>
			</table>
			</c:if>
			<c:if test="${count>0 }">
			<table class="table">
				<tr>
					<td class="text-right">
						총 ${count }건 검색
					</td>
				</tr>
			</table>
			<table class="table table-hover">
				<tr class="danger">
					<th width=5% class="text-center">번호</th>
					<th width=45% class="text-center">제목</th>
					<th width=15% class="text-center">이름</th>
					<th width=15% class="text-center">작성일</th>
					<th width=10% class="text-center">조회수</th>
					<th width=10% class="text-center"></th><!-- 파일 있는지 없는지 여부  -->
				</tr>
				<c:forEach var="vo" items="${list }">
				<tr>
					<td width=5% class="text-center">${vo.no }</td>
					<td width=45% ><a href="detail.do?no=${vo.no}">${vo.subject }</a></td>
					<td width=15% class="text-center">${vo.name }</td>
					<td width=15% class="text-center">${vo.dbday }</td>
					<td width=10% class="text-center">${vo.hit }</td>
					<td width=10% class="text-center">
						<c:if test="${vo.filecount>0 }">
							<img src="note.png" style="width: 20px; height: 20px;" title="파일이 ${vo.filecount }개 있습니다.">
						</c:if>
					</th><!-- 파일 있는지 없는지 여부  -->
				</tr>
				</c:forEach>
			</table>
			</c:if>
		</div>
	</div>
</body>
</html>