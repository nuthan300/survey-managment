package com.ty.survey.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.survey.services.SurveyService;

@WebServlet("/deletesurvey")
public class DeleteSurvery extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		SurveyService service = new SurveyService();
		service.deleteSurvey(id);

		resp.getWriter().write("<html><body><h1>Deleted successfully</h1></body></html>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("LoginUser.jsp");
		dispatcher.include(req, resp);

	}
}
