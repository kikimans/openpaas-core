package kr.cloudsc.openpaas.hibernate.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import kr.cloudsc.openpaas.entity.User;

import org.junit.Before;
import org.junit.Test;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class HibernateTest {
	
	private EntityManagerFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = Persistence.createEntityManagerFactory("mysql-ds");
	}

	@Test
	public void test_하이버네이트테스트() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<User> result = manager.createQuery("from User").getResultList();
		
		System.out.println("Result Size : " + result.size());
		
		for(User user : result){
			System.out.println(user);
		}
		manager.getTransaction().commit();
		factory.close();
	}
	
	

}
