<%@page import="com.ty.survey.services.SurveyorService"%>
<%@page import="com.ty.survey.dto.Surveyor"%>
<%@page import="com.ty.survey.dto.Survey"%>
<%@page import="com.ty.survey.services.SurveyService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <style>
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
</style> -->
</head>
<body>
<% int id = Integer.parseInt(request.getParameter("id1")); %>
	<div class="topnav">
		<a href="createsurvey.jsp?id=<%=id%>">create survey</a> 
		<a href="reviewsurvey">review survey</a> 
		<a href="logout">logout</a>
		
		<table border="5px solid black">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Description</th>
				<th>edit</th>
				<th>delete</th>
				<th>view_questions</th>
				<th>distribute</th>
			</tr>
			<% SurveyorService service = new SurveyorService();
			//SurveyService ss = new SurveyService();
			
	List<Survey> sys = service.getSurveyorById(id).getListSurvey();%>

			<%
			for (Survey s : sys) {
				if( !s.isDistribute() ){%>
				<tr>
					<td><%=s.getId()%></td>
					<td><%=s.getName()%></td>
					<td><%=s.getDescription()%></td>
					<td><a href="updatesurvey.jsp?id=<%=s.getId()%>">Edit</a></td>
					<td><a href="deletesurvey?id=<%=s.getId()%>">delete</a></td>
					<td><a href="allQuestion?id=<%=s.getId()%>">view</a></td>
					<td><a href = "distribute?id=<%=s.getId() %>">distribute</a></td>
				</tr><%
				} else {%>
					<tr>
					<td><%=s.getId()%></td>
					<td><%=s.getName()%></td>
					<td><%=s.getDescription()%></td>
					<td></td>
					<td></td>
					<td><a href="allQuestion?id=<%=s.getId()%>">view</a></td>
					<td> </td>
				</tr>
				<%} 
			}%>
		</table>
	</div>
	<h3> Edit your Profile: <a href="updatesurveyor.jsp?id=<%=id%>">Edit</a></h3>
	<h3> Delete your Profile:<a href="deletesurveyor?id=<%=id%>">delete</a></h3>
</body>
</html>
