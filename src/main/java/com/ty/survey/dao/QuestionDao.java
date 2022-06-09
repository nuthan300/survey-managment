package com.ty.survey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.survey.dto.Survey;
import com.ty.survey.dto.Options;
import com.ty.survey.dto.Question;

public class QuestionDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Question saveQuestion(int id, Question question) {

		Survey survey = entityManager.find(Survey.class, id);
		question.setSurvey(survey);
		entityTransaction.begin();
		entityManager.persist(question);
		entityTransaction.commit();
		Query query = entityManager.createQuery("SELECT q FROM Question q WHERE q.question = '" + question.getQuestion()+"'");

		return (Question) query.getSingleResult();
	}

	public boolean updateQuestion(Question question) {
		entityTransaction.begin();
		entityManager.merge(question);
		entityTransaction.commit();
		return true;
	}

	public boolean deleteQuestion(int id) {
		Question question = entityManager.find(Question.class, id);
		entityTransaction.begin();
		entityManager.remove(question);
		entityTransaction.commit();
		return true;
	}

	public Question getQuestionById(int id) {
		return entityManager.find(Question.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestion() {
		Query query = entityManager.createQuery("SELECT s FROM Question s");
		return query.getResultList();
	}
}
