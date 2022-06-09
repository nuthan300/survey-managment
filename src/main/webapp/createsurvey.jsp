<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% int id = Integer.parseInt(request.getParameter("id"));%>
	<form action="survey">
	Surveyor_id:<input type="text" name="id" value = "<%=id%>" readonly>
	Name : <input type="text" name="name">
	Description	: <input type="text" name="description">
	<input type="submit" value="store">
	</form>

</body>
</html>