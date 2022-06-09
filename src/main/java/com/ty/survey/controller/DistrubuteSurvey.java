package com.ty.survey.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.survey.dto.Survey;
import com.ty.survey.services.DistributedSurveyService;
import com.ty.survey.services.SurveyService;

@WebServlet(value = "/distribute")
public class DistrubuteSurvey extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		SurveyService service = new SurveyService();
		Survey survey = service.getSurveyById(id);
		survey.setDistribute(true);
		
		DistributedSurveyService service2 = new DistributedSurveyService();
		service2.saveDistributeSurvey(survey);
		resp.getWriter().write("<html><body><h1>Distributed Successfully</h1></body></html>");
		
		RequestDispatcher dispatch = req.getRequestDispatcher("LoginUser.jsp");
		dispatch.include(req, resp);
	}
}
