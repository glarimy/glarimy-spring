<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>Spring MVC | Glarimy</title>
</head>
<body>
	<h1>
		Glarimy Library
	</h1>
	<a href='add'>Add New Book</a> |
	<a href='find'>Find Books</a>
	<hr />
	<br />
	<h2>Find Book</h2>
	<f:form action="find" method="POST">
		<table>
			<tr>
				<td><spring:message code="glarimy.isbn"/></td>
				<td><f:input path="isbn" /></td>
			</tr>
			<tr>
				<td colspan='2'><input type='submit' value='Find' /></td>
			</tr>
		</table>
	</f:form>
</body>
</html>
