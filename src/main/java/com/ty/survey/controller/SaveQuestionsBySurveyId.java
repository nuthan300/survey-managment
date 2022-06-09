package com.ty.survey.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.survey.dto.Options;
import com.ty.survey.dto.Question;
import com.ty.survey.services.QuestionService;

@WebServlet(value = "/createQuestion")
public class SaveQuestionsBySurveyId extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int s_id = Integer.parseInt(req.getParameter("s_id"));
		String question = req.getParameter("question");
		int type = Integer.parseInt(req.getParameter("type"));
		int number = Integer.parseInt(req.getParameter("numoption"));

		Question question2 = new Question();
		question2.setQuestion(question);
		question2.setType(type);

		QuestionService questionService = new QuestionService();
		Question question3 = questionService.saveQuestion(s_id, question2);

		if (type > 2) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("viewsurveyor.jsp");
			dispatcher.forward(req, resp);
		} else {
			String url = "options.jsp?options=" + number + "&qid=" + question3.getId();
			RequestDispatcher dispatcher = req.getRequestDispatcher(url);
			dispatcher.forward(req, resp);
		}
	}
}
