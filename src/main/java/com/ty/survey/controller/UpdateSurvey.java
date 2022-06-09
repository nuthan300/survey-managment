package com.ty.survey.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.survey.dto.Options;
import com.ty.survey.dto.Question;
import com.ty.survey.dto.Survey;
import com.ty.survey.services.OptionService;
import com.ty.survey.services.QuestionService;
import com.ty.survey.services.SurveyService;

@WebServlet(value = "/updatesurvey")
public class UpdateSurvey extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Id: <input type="text" value = "<%=survey.getId() %>" name = "id" readonly><br><br>
//		Name: <input type="text" value = "<%=survey.getName() %>" name = "name" readonly><br><br>
//		Description : <input type="text" value = "<%=survey.getDescription() %>" name = "description" ><br><br>
//		<% List<Question> questionList = survey.getQuestionList();
//		int i=1, k=1;
//		for(Question question: questionList){%>
//			Question <%=i%> <input type="text" value = "<%=question.getQuestion() %>" name = "question<%=i%>" ><br><br>
//			Type: <input type="text" value = "<%=question.getType() %>" name = "type<%=i%>" readonly><br><br>
//			<% List<Options> optionsList = question.getOptions();
//			if(optionsList != null) {
//				int j = 1;
//				for(Options options : optionsList){%>
//					Option <%=j++%> <input type="text" value = "<%=options.getOptionDefination() %>" name = "option<%=k++%>" ><br><br>
//				<%} %>
//			<%}
//			i++;%>
//		<%} %>
		SurveyService service = new SurveyService();
		QuestionService questionService = new QuestionService();
		OptionService optionService = new OptionService();
		
		Survey survey = service.getSurveyById(Integer.parseInt(req.getParameter("id")));

		survey.setDescription(req.getParameter("description"));
		List<Question> questionList = survey.getQuestionList();
		int k=1,i=1;
		for(Question question : questionList) {
			question.setQuestion(req.getParameter("question"+i));
			List<Options> optionsList = question.getOptions();
			for(Options option : optionsList) {
				option.setOptionDefination(req.getParameter("option"+k++));
				optionService.updateOption(option);
			}
			questionService.updateQuestion(question);
			i++;
		}
		service.updateSurvey(survey);
		resp.getWriter().write("<html><body><h1>Update Successfull</h1></body></html>");
		RequestDispatcher dispatch = req.getRequestDispatcher("login.jsp");
		dispatch.include(req, resp);
	}
	
}
