<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
	<h3>Search Results</h3>
	<table>
		<tr>
			<td><spring:message code="glarimy.isbn" /></td>
			<td>${book.isbn }</td>
		</tr>
		<tr>
			<td><spring:message code="glarimy.title" /></td>
			<td>${book.title }</td>
	</table>
</body>
</html>
