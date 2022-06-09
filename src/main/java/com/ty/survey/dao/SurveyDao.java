package com.ty.survey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.survey.dto.Surveyor;
import com.ty.survey.dto.Survey;

public class SurveyDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Survey saveSurvey(int id, Survey survey) {
		Surveyor surveyor = entityManager.find(Surveyor.class, id);
		System.out.println(surveyor.getName());
		survey.setSurveyor(surveyor);
		entityTransaction.begin();
		entityManager.persist(survey);
		entityTransaction.commit();
		Query query = entityManager.createQuery("SELECT s FROM Survey s WHERE s.name = '"+ survey.getName()+"'");
		
		return (Survey)query.getSingleResult();
	}

	public boolean updateSurvey(Survey survey) {
		entityTransaction.begin();
		entityManager.merge(survey);
		entityTransaction.commit();
		return true;
	}

	public boolean deleteSurvey(int id) {
		Survey survey = entityManager.find(Survey.class,id);
		entityTransaction.begin();
		entityManager.remove(survey);
		entityTransaction.commit();
		return true;
	}

	public Survey getSurveyById(int id) {
		return entityManager.find(Survey.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Survey> getAllSurvey() {
		Query query = entityManager.createQuery("SELECT s FROM Survey s");
		return query.getResultList();
	}
}
