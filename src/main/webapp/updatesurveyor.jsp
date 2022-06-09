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
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	SurveyorService service = new SurveyorService();
	Surveyor surveyor = service.getSurveyorById(id);%>
	<form action="updatesurveyor">


	Id : <input type="text" name="id" value="<%=surveyor.getId() %>" readonly="readonly"> <br><br>
	Name : <input type="text" name="name" value="<%=surveyor.getName() %>"><br><br>
	Email :	<input type="email" name="email" value="<%=surveyor.getEmail()%>"><br><br>
	Password :	<input type="tel" name="phone" value="<%=surveyor.getPassword()%>"><br><br>
			<input type="submit" value="update">
	</form>
</body>
</html>