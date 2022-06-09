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

import com.ty.survey.dto.DistributeSurvey;
import com.ty.survey.dto.Respondent;
import com.ty.survey.services.DistributedSurveyService;
import com.ty.survey.services.RespondentService;

@WebServlet(value = "/submitsurvey")
public class SubmitResponse extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("sid"));
		int respid = Integer.parseInt(req.getParameter("id"));
		DistributedSurveyService service = new DistributedSurveyService();
		DistributeSurvey survey = service.getDistributeSurveyById(id);

		RespondentService service2 = new RespondentService();
		Respondent respondent = service2.getRespondentById(respid);

		if (survey.getRespondents().isEmpty()) {
			List<Respondent> list = new ArrayList<Respondent>();
			list.add(respondent);
			survey.setRespondents(list);
		} else {
			survey.getRespondents().add(respondent);
		}

		service.updateDistributeSurvey(survey);
		
		resp.getWriter().write("<html><body><h3>Succesfully Submited Survey</h3></body></html>");
		RequestDispatcher dispatch = req.getRequestDispatcher("LoginServlet.jsp");
		dispatch.include(req, resp);
	}
}
