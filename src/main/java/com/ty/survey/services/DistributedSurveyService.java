package com.ty.survey.services;

import java.util.List;

import com.ty.survey.dao.DistributeSurveyDao;
import com.ty.survey.dto.DistributeSurvey;
import com.ty.survey.dto.Survey;

public class DistributedSurveyService {

	DistributeSurveyDao dao = new DistributeSurveyDao(); 
	public boolean saveDistributeSurvey(Survey survey) {
		return dao.saveDistributeSurvey(survey);
	}
	
	public boolean removeDistributeSurvey(int id) {
		return dao.removeDistributeSurvey(id);
	}
	
	public List<DistributeSurvey> getAllDistributeSurvey(){
		return dao.getAllDistributeSurvey();
	}
	
	public DistributeSurvey getDistributeSurveyById(int id){
		return dao.getDistributeSurveyById(id);
	}
	
	public boolean updateDistributeSurvey(DistributeSurvey survey) {
		return dao.updateDistributeSurvey(survey);
	}
}
