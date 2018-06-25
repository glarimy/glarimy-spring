<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>Spring Security | Glarimy</title>
</head>
<body>
	<sec:authorize access="hasRole('ROLE_USER')">
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm"></form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<div style='float: right'>
				You are logged in as ${pageContext.request.userPrincipal.name}<br />
				<a href="javascript:formSubmit()"> Logout</a>
			</div>
		</c:if>
	</sec:authorize>
	<h1>Glarimy Calculator</h1>
	<a href='admin/add'>Add Numbers</a>
	<hr />
</body>
</html>