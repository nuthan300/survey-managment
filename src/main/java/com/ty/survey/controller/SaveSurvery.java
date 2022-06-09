package com.ty.survey.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.survey.dto.Survey;
import com.ty.survey.services.SurveyService;

@WebServlet(value = "/survey")
public class SaveSurvery extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");

		Survey survey = new Survey();
		survey.setName(name);
		survey.setDescription(description);

		SurveyService service = new SurveyService();

		Survey survey2 = service.saveSurvey(id, survey);

		RequestDispatcher dispatcher = req.getRequestDispatcher("saveQuestion.jsp?id=" + survey2.getId());
		dispatcher.forward(req, resp);
	}

}
