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
	<div class="jumbotron">
		<h3 class="text-center">${vo.title }</h3>
		<h4 class="text-center">${vo.subject }</h4>
	</div>
	<div class="row">
		<table class="table">
			<tr>
				<td>
					<c:forEach var="fvo" items="${fList }">
						<table class="table">
							<tr>
								<td width=30% class="text-center" rowspan = "4">
									<a href="../food/food_detail.do?fno=${fvo.fno }&type=1"><img src="${fvo.poster }" style="width: 100%"></a>
								</td>
								<td width=70%>
									<h3><a href="../food/food_detail.do?fno=${fvo.fno }&type=1">${fvo.name }</a>&nbsp;<span style="color:orange">${fvo.score }</span></h3>
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
</body>
</html>