package com.ty.survey.services;

import java.util.List;

import com.ty.survey.dto.Question;
import com.ty.survey.dao.QuestionDao;

public class QuestionService {
	
	QuestionDao dao = new QuestionDao();
	
	public Question saveQuestion(int id, Question question) {
		return dao.saveQuestion(id, question);
	}
	
	public boolean updateQuestion(Question question) {
		return dao.updateQuestion(question);
	}
	
	public boolean deleteQuestion(int id) {
		return dao.deleteQuestion(id);
	}
	
	public Question getQuestionById(int id) {
		return dao.getQuestionById(id);
	}
	public List<Question> getAllQuestion() {
		return dao.getAllQuestion();
	}
}
