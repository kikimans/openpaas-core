package kr.cloudsc.openpaas.hibernate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import kr.cloudsc.openpaas.model.User;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class HibernateConnectionTest {

	private SessionFactory factory;
	@Before
	public void setUp() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("config/hibernate/hibernate.cfg.xml");
		try {
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test_connection() {
		Configuration cfg = new Configuration();
		cfg.configure("config/hibernate/hibernate.cfg.xml");
		try {
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		assertThat(factory, is(notNullValue()));
		/*
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<User> users = session.createQuery("FROM TB_USER").list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		 
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_UserList(){
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List<User> users =(List<User>) session.createQuery("FROM User").list();
			
			for(Iterator<User> iter = users.iterator(); iter.hasNext();){
				User user = (User)iter.next();
				System.out.println(user.getEmail() + " : " + user.getPasswd());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
