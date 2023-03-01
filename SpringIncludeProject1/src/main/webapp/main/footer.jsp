<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-sm-6">
	 	<ul>
	 		<c:forEach var="vo" items="${nList }">
				<li>${vo.no }.${vo.subject }(${vo.dbday })</li>
			</c:forEach>
	 	</ul>
			
	</div>
	<div class="col-sm-6">
		<ul>
	 		<c:forEach var="vo" items="${dList }">
				<li>${vo.no }.${vo.subject }(${vo.dbday })</li>
			</c:forEach>
	 	</ul>
	</div>
</body>
</html>