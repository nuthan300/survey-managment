package com.ty.survey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.survey.dto.Options;
import com.ty.survey.dto.Question;


public class OptionDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveOption(int id, Options option) {
		Question question = entityManager.find(Question.class, id);
		option.setQuestion(question);
		entityTransaction.begin();
		entityManager.persist(option);
		entityTransaction.commit();
		return true;
	}

	public boolean updateOption(Options option) {
		entityTransaction.begin();
		entityManager.merge(option);
		entityTransaction.commit();
		return true;
	}

	public boolean deleteOption(int id) {
		Options options = entityManager.find(Options.class, id);
		entityTransaction.begin();
		entityManager.remove(options);
		entityTransaction.commit();
		return true;
	}

	public Options getOptionById(int id) {
		return entityManager.find(Options.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Options> getAllOption() {
		Query query = entityManager.createQuery("SELECT s FROM Option s");
		return query.getResultList();
	}
}
