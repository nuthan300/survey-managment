<%@page import="com.ty.survey.services.DistributedSurveyService"%>
<%@page import="com.ty.survey.dto.Survey"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.survey.dto.DistributeSurvey"%>;
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<%	int id = Integer.parseInt(request.getParameter("id")); %>
	<div class="topnav">
	  <a href="create.jsp">respond</a>
	  <a href="viewresponses.jsp?id=<%=id%>">view your responses</a>
	  <a href="logout">Logout</a>
	</div>
	<h1></h1>


	<h1>List of Surveys to be Attended</h1>
	<%
		
		DistributedSurveyService service = new DistributedSurveyService();
		List<DistributeSurvey> surveys = service.getAllDistributeSurvey();
	%>
	<table border="5px solid black" align="center" cellpadding=20px>
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>Description</th>
	</tr>
	
	<%
		for(DistributeSurvey s: surveys){
			Survey survey = s.getSurvey1();
	%>
		<tr>
			<td><%= s.getId()%></td>
			<td><a href="viewsurvey.jsp?id=<%=survey.getId()%>&respid=<%=id%>"><%=survey.getName()%></a></td>
			<td><%=survey.getDescription()%></td>
		</tr>
	<%		
		}
	%>
	</table>

</body>
</html>