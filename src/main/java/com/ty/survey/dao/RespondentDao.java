package com.ty.survey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.survey.dto.Respondent;

public class RespondentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public boolean saveRespondent(Respondent respondent) {
		
		entityTransaction.begin();
		entityManager.persist(respondent);
		entityTransaction.commit();
		return true;
	}
	
	public boolean deleteRespondent(int id) {
		Respondent respondent = entityManager.find(Respondent.class, id);
		entityTransaction.begin();
		entityManager.remove(respondent);
		entityTransaction.commit();
		return true;
	}
	
	public boolean updateRespondent(Respondent respondent) {
		entityTransaction.begin();
		entityManager.merge(respondent);
		entityTransaction.commit();
		return true;
	}
	
	public Respondent getRespondentById(int id) {
		return entityManager.find(Respondent.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Respondent>getAllRespondent() {
		Query query = entityManager.createQuery("SELECT s FROM Respondent s");
		return query.getResultList();
	}
	
	public Respondent validateRespondent(String email, String password) {
		
		Query query = entityManager.createQuery("SELECT s FROM Respondent s WHERE s.email = ?1 and s.password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		return (Respondent)query.getSingleResult();
	}
	
}
