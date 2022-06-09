package com.ty.survey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.survey.dto.Surveyor;

public class SurveyorDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public boolean saveSurveyor(Surveyor surveyor) {
		entityTransaction.begin();
		entityManager.persist(surveyor);
		entityTransaction.commit();
		return true;
	}
	
	public boolean deleteSurSurveyor(int id) {
		Surveyor surveyor = entityManager.find(Surveyor.class,id);
		entityTransaction.begin();
		entityManager.remove(surveyor);
		entityTransaction.commit();
		return true;
	}
	
	public boolean updateSurveyor(Surveyor surveyor) {
		entityTransaction.begin();
		entityManager.merge(surveyor);
		entityTransaction.commit();
		return true;
	}
	
	public Surveyor getSurveyorById(int id) {
		return entityManager.find(Surveyor.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Surveyor>getAllSurveyor() {
		Query query = entityManager.createQuery("SELECT s FROM Surveyor s");
		return query.getResultList();
	}
	
	public Surveyor validateSurveyor(String email, String password) {
		Query query = entityManager.createQuery("SELECT s FROM Surveyor s where email = ?1 and password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		return (Surveyor)query.getSingleResult();
	}
}
