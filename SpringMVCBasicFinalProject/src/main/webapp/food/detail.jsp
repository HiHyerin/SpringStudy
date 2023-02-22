<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
	width: 1200px;
}

h1{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<c:forTokens items="${vo.poster }" delims="^" var="img">
						<td><img src="${img }" style="width: 100%"></td>
					</c:forTokens>
				</tr>
			</table>
		</div>
		
		<div style="height: 20px"></div>
		
		<div class="row">
			<div class="col-sm-8">
				<table class="table">
				  <tr>
				  	<td colspan="2">
				  	  <h3>${vo.name }&nbsp;<span style="color: orange">${vo.score }</span></h3>
				  	</td>
				  </tr>
				  <tr>
				    <th width= 10%>주소</th>
				    <td width= 90%>${vo.address }</td>
				  </tr>
				  <tr>
				    <th width= 10%>전화</th>
				    <td width= 90%>${vo.tel }</td>
				  </tr>
				  <tr>
				    <th width= 10%>음식종류</th>
				    <td width= 90%>${ vo.type}</td>
				  </tr>
				  <tr>
				    <th width= 10%>가격대</th>
				    <td width= 90%>${vo.price }</td>
				  </tr>
				  <tr>
				    <th width= 10%>주차</th>
				    <td width= 90%>${vo.parking }</td>
				  </tr>
				  <tr>
				    <th width= 10%>영업시간</th>
				    <td width= 90%>${vo.time }</td>
				  </tr>
				  <tr>
				    <th width= 10%>메뉴</th>
				    <td width= 90%>${vo.menu }</td>
				  </tr>
				  <tr>
				  	<td colspan="2" class="text-right">
				  		<b>맛있다(${vo.good })&nbsp; 괜찮다(${vo.soso })&nbsp; 별로(${vo.bad })</b>&nbsp;
				  		<input type=button class="btn btn-xs btn-danger" value="목록" onclick="javascript:history.back()">
				  	</td>
				  </tr>
				</table>
			</div>
			
			<div class="col-sm-4">
			
			</div>
		</div>
	</div>
</body>
</html>