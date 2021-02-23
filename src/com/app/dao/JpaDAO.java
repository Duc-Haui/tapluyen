package com.app.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDAO<E> {

	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("db");
	}
	
	public void close() {
		entityManagerFactory.close();
	}
	
	public E create(E e) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(e);
		entityManager.refresh(e);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return e;
	}

	public E update(E e) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(e);
		entityManager.getTransaction().commit();
		entityManager.close();
		return e;
	}

	public E find(Class<E> class1, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		E e = entityManager.find(class1, id);
		entityManager.close();
		return e;
	}

	public void delete(Class<E> class1, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		E e = entityManager.getReference(class1, id);
		entityManager.remove(e);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<E> findWithNameQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		List<E> lst = query.getResultList();
		entityManager.close();
		return lst;
	}

	public List<E> findWithNameQuery(String queryName,Map<String, Object> para){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		Set<Entry<String, Object>> setPara = para.entrySet();
		for(Map.Entry<String, Object> entry : setPara) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		List<E> lst = query.getResultList();
		entityManager.close();
		return lst;
	}
	
	public long count(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		Long result = (long)query.getSingleResult();
		entityManager.close();
		return result;
	}
	
	

}
