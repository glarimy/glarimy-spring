<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>Spring Security | Glarimy</title>
</head>
<body>
	<h1>Glarimy Calculator</h1>
	<a href='add'>Add Numbers</a>
	<hr />
	<h2>Add Numbers</h2>
	<f:form action="add" method="POST">
		<table>
			<tr>
				<td>First Number</td>
				<td><f:input path="first" /></td>
			</tr>
			<tr>
				<td>Second Number</td>
				<td><f:input path="second" /></td>
			</tr>
			<tr>
				<td colspan='2'><input type='submit' value='Add' /></td>
			</tr>
		</table>
	</f:form>
</body>
</html>
