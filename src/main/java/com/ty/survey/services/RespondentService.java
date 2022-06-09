package com.ty.survey.services;

import java.util.List;

import com.ty.survey.dao.RespondentDao;
import com.ty.survey.dto.Respondent;

public class RespondentService {

	RespondentDao dao = new RespondentDao();
	public boolean saveRespondent(Respondent respondent) {
		return dao.saveRespondent(respondent);
	}
	
	public boolean deleteRespondent(int id) {
		return dao.deleteRespondent(id);
	}
	
	public boolean updateRespondent(Respondent respondent) {
		return dao.updateRespondent(respondent);
	}
	
	public Respondent getRespondentById(int id) {
		return dao.getRespondentById(id);
	}
	
	public List<Respondent>getAllRespondent() {
		return dao.getAllRespondent();
	}
	
	public Respondent validateRespondent(String email, String password) {
		return dao.validateRespondent(email, password);
	}
}
