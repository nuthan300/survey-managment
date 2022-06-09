package com.ty.survey.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.survey.dto.Respondent;
import com.ty.survey.dto.Surveyor;
import com.ty.survey.services.RespondentService;
import com.ty.survey.services.SurveyorService;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String user = req.getParameter("user");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		SurveyorService service = new SurveyorService();
		RespondentService rservice = new RespondentService();
		Respondent respondent;
		Surveyor surveyor;
		PrintWriter printWriter = resp.getWriter();
		RequestDispatcher dispatch = null;

		if (user.equals("admin")) {															 // Admin Login

			if (email.equals("admin@gmail.com") && password.equals("admin123")) {


				SurveyorService surveyorService = new SurveyorService();
				List<Surveyor> list = surveyorService.getAllSurveyor();
				RespondentService respondentService = new RespondentService();
				List<Respondent> list2 = respondentService.getAllRespondent();
				req.setAttribute("email", email);
				req.setAttribute("password", password);
				req.setAttribute("user", user);
				req.setAttribute("Surveyors", list);
				req.setAttribute("Respondents", list2);
				
				printWriter.write("<html><body><h1>logged in successfully</h1></body></html>");
				dispatch = req.getRequestDispatcher("viewadmin.jsp");

			} else {

				printWriter.write("<html><body><h1>Incorrect user/password</h1></body></html>");
				dispatch = req.getRequestDispatcher("login.jsp");
			}

		} else if (user.equals("surveyor")) { 												// Surveyor Login

			if ((surveyor = service.validateSurveyor(email, password)) != null) {
				
				printWriter.write("<html><body><h1>logged in successfully</h1></body></html>");
				dispatch = req.getRequestDispatcher("viewsurveyor.jsp?id1="+surveyor.getId());

			} else {

				printWriter.write("<html><body><h1>Incorrect user/password</h1></body></html>");
				dispatch = req.getRequestDispatcher("login.jsp");
			}

		} else if (user.equals("respondent")) { 											// Respondent Login

			if ((respondent = rservice.validateRespondent(email, password)) != null) {

				printWriter.write("<html><body><h1>logged in successfully</h1></body></html>");
				dispatch = req.getRequestDispatcher("viewrespondent.jsp?id="+respondent.getId());

			} else {
				
				printWriter = resp.getWriter();
				printWriter.write("<html><body><h1>Incorrect user/password</h1></body></html>");
				dispatch = req.getRequestDispatcher("login.jsp");
			}
		}
		dispatch.include(req, resp);
	}
}
