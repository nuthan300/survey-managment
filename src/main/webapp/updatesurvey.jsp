<%@page import="com.ty.survey.dto.Options"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.survey.dto.Question"%>
<%@page import="com.ty.survey.dto.Survey"%>
<%@page import="com.ty.survey.services.SurveyService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	SurveyService service = new SurveyService();
	Survey survey = service.getSurveyById(id);
%>
<form action = "updatesurvey">
	Id: <input type="text" value = "<%=survey.getId() %>" name = "id" readonly><br><br>
	Name: <input type="text" value = "<%=survey.getName() %>" name = "name" readonly><br><br>
	Description : <input type="text" value = "<%=survey.getDescription() %>" name = "description" ><br><br>
	<% List<Question> questionList = survey.getQuestionList();
	int i=1, k=1;
	for(Question question: questionList){%>
		Question <%=i%> <input type="text" value = "<%=question.getQuestion() %>" name = "question<%=i%>" ><br><br>
		Type: <input type="text" value = "<%=question.getType() %>" name = "type<%=i%>" readonly><br><br>
		<% List<Options> optionsList = question.getOptions();
		if(optionsList != null) {
			int j = 1;
			for(Options options : optionsList){%>
				Option <%=j++%> <input type="text" value = "<%=options.getOptionDefination() %>" name = "option<%=k++%>" ><br><br>
			<%} %>
		<%}
		i++;%>
	<%} %>
	<input type="submit">
</form>
</body>
</html>