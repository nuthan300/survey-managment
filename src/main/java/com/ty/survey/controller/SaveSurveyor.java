package com.ty.survey.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.survey.dto.Surveyor;
import com.ty.survey.services.SurveyorService;

@WebServlet(value = "/surveyor")
public class SaveSurveyor extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(name);
		Surveyor surveyor = new Surveyor();
		surveyor.setName(name);
		surveyor.setEmail(email);
		surveyor.setPassword(password);

		SurveyorService service = new SurveyorService();
		service.saveSurveyor(surveyor);

		PrintWriter p = resp.getWriter();
		p.write("<html><body><h1>Created New Surveyor Account</h1></body></html>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("LoginUser.jsp");
		dispatcher.include(req, resp);

	}
}
