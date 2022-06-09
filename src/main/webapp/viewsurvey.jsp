<%@page import="com.ty.survey.dto.Options"%>
<%@page import="com.ty.survey.dto.Question"%>
<%@page import="java.util.List"%>
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
	int responid = Integer.parseInt(request.getParameter("respid"));
	SurveyService service = new SurveyService();
	Survey survey = service.getSurveyById(id);
%>
<form action = "submitsurvey">

	Your_id : <input type="text" value = "<%=responid %>" name = "id" readonly><br><br>
	Survey_ID : <input type="text" value = "<%=id %>" name = "sid" readonly><br><br>
	Name: <%=survey.getName() %><br><br>
	Description : <%=survey.getDescription() %><br><br>
	<% List<Question> questionList = survey.getQuestionList();
	int i=1;
	for(Question question: questionList){%>
		Question <%=i%> <%=question.getQuestion() %><br><br><%
		List<Options> optionsList = question.getOptions();
		if(optionsList != null) {
			int j = 1;
			for(Options options : optionsList){%>
				Option <%=j++%> <input type="radio"> <%=options.getOptionDefination() %> <br><br><%
			} 
		} else {%>
			<textarea></textarea><br><br><% 
		} i++; 
	} %>
	<input type = "submit">
</form>
</body>
</html>