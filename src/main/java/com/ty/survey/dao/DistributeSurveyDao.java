package com.ty.survey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.survey.dto.DistributeSurvey;
import com.ty.survey.dto.Survey;

public class DistributeSurveyDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveDistributeSurvey(Survey survey) {
		DistributeSurvey distributeSurvey = new DistributeSurvey();
		distributeSurvey.setSurvey1(survey);
		entityTransaction.begin();
		entityManager.persist(distributeSurvey);
		entityTransaction.commit();
		return true;
	}

	public boolean removeDistributeSurvey(int id) {

		Query query = entityManager.createQuery("SELECT s FROM DistributeSurvey s WHERE s.id = " + id);
		DistributeSurvey survey = (DistributeSurvey) query.getSingleResult();
		entityManager.remove(survey);
		entityTransaction.commit();
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<DistributeSurvey> getAllDistributeSurvey() {

		Query query = entityManager.createQuery("SELECT s FROM DistributeSurvey s");
		return query.getResultList();
	}

	public boolean updateDistributeSurvey(DistributeSurvey survey) {
		entityTransaction.begin();
		entityManager.merge(survey);
		entityTransaction.commit();
		return true;
	}
	
	public DistributeSurvey getDistributeSurveyById(int id) {

		Query query = entityManager.createQuery("SELECT s FROM DistributeSurvey s WHERE s.id = " + id);
		return (DistributeSurvey) query.getSingleResult();
	}
}
