<%@page import="com.ty.survey.services.SurveyorService"%>
<%@page import="com.ty.survey.dto.Surveyor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="createQuestion" >
		<%
		int id = Integer.parseInt(request.getParameter("id"));
		%>
		Survey_Id : <input type="number" name="s_id" value=<%=id%> readonly> <br>
		Question Title : <input type="text" name="question"><br>
		Type : <input type="text" name="type"><br>
		Number of Options (if it is there): <input type = "text" name = "numoption"><br><br>
		 <input type="submit" name="create">
	</form>
</body>
</html>