<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="saveoption">
<% int i = Integer.parseInt(request.getParameter("qid")), j = Integer.parseInt(request.getParameter("options"));%>
number of options: <input type="text" value = <%= j %> name = "opt" readonly>
Question number : <input type = "text" value = <%= i %> name = "qids" readonly><br><br>
<% for(int k = 0 ; k<j; k++){ %>
	<textarea name = "k<%= k %>"></textarea><br><br>
<% } %>
	<input type="submit">
</form>
</body>
</html>