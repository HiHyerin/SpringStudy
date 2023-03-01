<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<jsp:include page="${main_jsp }"></jsp:include>
		</div>
	</div>
	<div class="container">
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
	
	
</body>
</html>