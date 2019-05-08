package com.cg.tripadvisorjpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbUtil {

	static EntityManager em =null;
	public static EntityManager getConnection() {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("tripadvisorjpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		return em;
	}
}
