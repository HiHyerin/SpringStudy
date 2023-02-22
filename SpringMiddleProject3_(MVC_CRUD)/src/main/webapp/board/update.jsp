<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>수정하기</h1>
		<div class="row">
		<form method="post" action="update_ok.do">
			<table>
		     <tr>
		       <th width =15% class="text-right">이름</th>
		       <td width =80%>
		         <input type =text name =name size=20 class="input-sm" value="${vo.name }">
		         <input type=hidden name=no value="${vo.no }">
		       </td>
		     </tr>
		     <tr>
		       <th width =15% class="text-right">제목</th>
		       <td width =80%>
		         <input type =text name =subject size=60 class="input-sm" value="${vo.subject }">
		       </td>
		     </tr>
		     <tr>
		       <th width =15% class="text-right">내용</th>
		       <td width =80%>
		         <textarea rows="10" cols="60" name ="content">${vo.content }</textarea>
		       </td>
		     </tr>
		     <tr>
		       <th width =15% class="text-right">비밀번호</th>
		       <td width =80%>
		         <input type =password name =pwd size=15 class="input-sm">
		       </td>
		     </tr>
		     <tr>
		        <td colspan="2" class="text-center">
		          <input type =submit value="수정" class="btn btn-sm btn-danger">
		          <input type =button value="취소" class="btn btn-sm btn-danger" onclick="javascript:history.back()">
		         </td>
		     </tr>
		   </table>
		  </form>
		</div>
	</div>
</body>
</html>