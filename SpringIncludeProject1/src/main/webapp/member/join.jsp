<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form method=post action="../member/join_ok.do">
	<table class="table">
		<tr>
		  <th width="15%">ID</th>
		  <td width=85%>
		  	<input type=text name=id id="id" size=20>
		  </td>
		</tr>
		<tr>
		  <th width="15%">Password</th>
		  <td width=85%>
		  	<input type=password name=pwd id="pwd" size=20>
		  </td>
		</tr>
		<tr>
		   <th width="15%">Name</th>
		   <td width=85%>
		       <input type=text name=name id="name" size=20>
		   </td>
		</tr>
		<tr>
			<td colspan="2" class="text-center">
				<input type=submit value="회원가입" class="btn btn-sm btn-danger">
				<input type=button value="취소" class="btn btn-sm btn-info">
			</td>
		</tr>
	</table>
  </form>
</body>
</html>