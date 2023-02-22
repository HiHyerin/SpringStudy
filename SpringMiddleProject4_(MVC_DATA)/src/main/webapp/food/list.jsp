<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
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
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h3 class="text-center">${vo.title }</h3>
			<h4 class="text-center">${vo.subject }</h4>
		</div>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<c:forEach var="fvo" items="${list }">
							<table class="table">
								<tr>
									<td width=30% class="text-center" rowspan = "4">
										<img src="${fvo.poster }" style="width: 100%">
									</td>
									<td width=70%>
										<h3>${fvo.name }&nbsp;<span style="color:orange">${fvo.score }</span></h3>
									</td>
								</tr>
								<tr>
									<td width=70%>
										<h3>${fvo.address }</h3>
									</td>
								</tr>
								<tr>
									<td width=70%>
										<h3>${fvo.tel }</h3>
									</td>
								</tr>
								<tr>
									<td width=70%>
										<h3>${fvo.type }</h3>
									</td>
								</tr>
							</table>						
						</c:forEach>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>