<%@page import="java.util.List"%>
<%@page import="com.ty.survey.dto.Surveyor"%>
<%@page import="com.ty.survey.dto.Respondent"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="mynavbar.jsp" %>
<%
	List<Surveyor> surveyors = (List) request.getAttribute("Surveyors");
	List<Respondent> respondents = (List) request.getAttribute("Respondents");
	%>

	<h1>Surveyor</h1>
	<table border="5px solid black" align="center" cellpadding=20px>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<!--  <th>Servey's</th> -->
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>

		<%
		for (Surveyor s : surveyors) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getEmail()%></td>
			<!--  <td><a href="getServey?id=<%=s.getId()%>">view</a></td>	-->
			<!--  <td><a href="surveyorid?id=<%=s.getId()%>">>edit</a></td> -->
			<td><a href="viewSurveysById.jsp?id=<%=s.getId()%>">edit</a></td>
			<td><a href="deletesurveyor?id=<%=s.getId()%>">delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<br>
	<h1>Respondent</h1>
	<br>
	<br>
	<table border="5px solid black" align="center" cellpadding=20px>
		<tr></tr>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>

		<%
		for (Respondent s : respondents) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getEmail()%></td>
			<td><a href="respondentid?id=<%=s.getId()%>">edit</a></td>
			<td><a href="deleteRespondent?id=<%=s.getId()%>">delete</a></td>
		</tr>
		<%
		}
		%>
	</table>


</body>
</html>