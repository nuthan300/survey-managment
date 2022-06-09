package com.ty.survey.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.survey.dto.Surveyor;
import com.ty.survey.services.SurveyorService;

@WebServlet(value = "/updatesurveyor")
public class UpdateSurveyor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Surveyor surveyor = new Surveyor();
		surveyor.setId(id);
		surveyor.setName(name);
		surveyor.setEmail(email);
		surveyor.setPassword(password);

		SurveyorService service = new SurveyorService();
		service.updateSurveyor(surveyor);

		RequestDispatcher dispatcher = req.getRequestDispatcher("LoginUser.jsp");
		dispatcher.forward(req, resp);
	}
}
