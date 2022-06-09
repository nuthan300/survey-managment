package com.ty.survey.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.survey.dto.Options;
import com.ty.survey.services.OptionService;

@WebServlet(value = "/saveoption")
public class SaveOptions extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int qid = Integer.parseInt(req.getParameter("qids"));
		int opt = Integer.parseInt(req.getParameter("opt"));
		
		OptionService optionService = new OptionService();
		
		for(int i=0;i<opt;i++) {
			Options options = new Options();
			String s = req.getParameter("k"+i);
			System.out.println(s+qid);
			options.setOptionDefination(s);
			optionService.saveOption(qid, options);
		}
		
		PrintWriter p = resp.getWriter();
		p.write("<html><body><h3>Created Questions with options</h3></body></html>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("LoginUser.jsp");
		dispatcher.include(req, resp);
	}
}
