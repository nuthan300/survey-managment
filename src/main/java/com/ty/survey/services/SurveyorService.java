package com.ty.survey.services;

import java.util.List;

import com.ty.survey.dao.SurveyorDao;
import com.ty.survey.dto.Surveyor;

public class SurveyorService {

	SurveyorDao dao = new SurveyorDao();
	public boolean saveSurveyor(Surveyor surveyor) {
		return dao.saveSurveyor(surveyor);
	}
	
	public boolean deleteSurSurveyor(int id) {
		return dao.deleteSurSurveyor(id);
	}
	
	public boolean updateSurveyor(Surveyor surveyor) {
		return dao.updateSurveyor(surveyor);
	}
	
	public Surveyor getSurveyorById(int id) {
		return dao.getSurveyorById(id);
	}
	
	public List<Surveyor>getAllSurveyor() {
		return dao.getAllSurveyor();
	}
	public Surveyor validateSurveyor(String email, String password) {
		return dao.validateSurveyor(email, password);
	}
}
