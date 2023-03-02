<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table width=960 height="600" border="1" bordercolor=black>
			<tr>
				<td width=960 colspan="2" height="100" align=center>
					<tiles:insertAttribute name="header"/><!-- =include -->
				</td>
			</tr>
			<tr>
				<td width=200 height="400" align=center>
					<tiles:insertAttribute name="nav"/>
				</td>
				<td width=760 height="400" align=center>
					<tiles:insertAttribute name="content"/>
				</td>
			</tr>
			<tr>
				<td width=960 colspan="2" height="100" align=center>
					<tiles:insertAttribute name="footer"/>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>