<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<form:form action="${pageContext.request.contextPath}/books/add"
		modelAttribute="book" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>TITLE:</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" name="add" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>