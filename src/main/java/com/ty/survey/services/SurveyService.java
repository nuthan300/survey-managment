package com.ty.survey.services;

import java.util.List;

import com.ty.survey.dto.Survey;
import com.ty.survey.dao.SurveyDao;

public class SurveyService {
	SurveyDao dao = new SurveyDao();

	public Survey saveSurvey(int id, Survey survey) {
		return dao.saveSurvey(id, survey);
	}

	public boolean updateSurvey(Survey survey) {
		return dao.updateSurvey(survey);
	}

	public boolean deleteSurvey(int id) {
		return dao.deleteSurvey(id);
	}

	public Survey getSurveyById(int id) {
		return dao.getSurveyById(id);
	}

	public List<Survey> getAllSurvey() {
		return dao.getAllSurvey();
	}
}
