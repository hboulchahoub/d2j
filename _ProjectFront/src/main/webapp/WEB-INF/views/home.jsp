<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- 
		0) Class fille de TagSupport
		0) Redefinir la methode doStartTag Class A
		0) La classe A <=> balise dispaly
uri <==> 1) TLD: Tag Lib Description
			  2) On le trouve dans META-INF
			  3) Identifiant unique
			  4) Il peut etre remplace par le path du TLD 
 -->


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>

<body>

<sec:authorize access="isAuthenticated()">
	  Welcome  <sec:authentication property="name" />
		<a href="<c:url value="/logout" />">Logout</a>
</sec:authorize>
	<form:form action="${pageContext.request.contextPath}/books/crud"
		modelAttribute="book" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><font color="red"> <form:errors path="id"></form:errors></font></td>
			</tr>
			<tr>
				<td>TITLE:</td>
				<td><form:input path="title" /></td>
			</tr>

			<tr>
				<td><font color="red"> <form:errors path="title"></form:errors></font></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add" name="add" /></td>
				<td><input type="submit" value="Update" name="update" /></td>
			</tr>
		</table>
	</form:form>
	<!-- 	display List -->
	<table>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.title}</td>
				<td><a
					href='${pageContext.request.contextPath}/books/v2/<c:out value="${book.id}"/>'>Update</a></td>
				<td><a
					href='${pageContext.request.contextPath}/books/delete/<c:out value="${book.id}"/>'>Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>