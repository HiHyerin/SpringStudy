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
		<h1>자료실</h1>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<a href="insert.do" class="btn btn-sm btn-primary">새글</a>
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
					</td><!-- 파일 있는지 없는지 여부  -->
				</tr>
				</c:forEach>
			</table>
			<table class="tabel">
				<tr>
					<td class="text-left">
					  <form method = "post" action="find.do">
						<input type="checkbox" name="fs" value="N">이름
						<input type="checkbox" name="fs" value="S">제목
						<input type="checkbox" name="fs" value="C">내용
						<input type=text name=ss size=15 class="input-sm">
						<input type=submit value="검색" class="btn btn-sm btn-danger">
					  </form>
					</td>
					<td class="text-right">
						<a href="#" class="btn btn-sm btn-info">이전</a>
						${curpage } page / ${totalpage } pages
						<a href="#" class="btn btn-sm btn-info">다음</a>
					
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>