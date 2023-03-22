<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${result =='yes' }">
	<c:redirect url="/list"/>
</c:if>
<c:if test="${result =='no' }">
	<script>
	  alert("비밀번호가 틀립니다.");
	  history.back()
	</script>
</c:if>