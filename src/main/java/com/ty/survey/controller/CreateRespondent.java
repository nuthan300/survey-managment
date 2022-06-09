package com.ty.survey.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.survey.dto.Respondent;
import com.ty.survey.services.RespondentService;

@WebServlet(value = "/respondent")
public class CreateRespondent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Respondent respondent = new Respondent();
		respondent.setEmail(email);
		respondent.setName(name);
		respondent.setPassword(password);

		RespondentService service = new RespondentService();
		service.saveRespondent(respondent);
		PrintWriter p = resp.getWriter();
		p.println("<html><body><h1>Created New Respondent Account.. </h1></body></html>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("LoginUser.jsp");
		dispatcher.include(req, resp);

	}

}
