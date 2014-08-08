package kr.cloudsc.openpaas.client;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import kr.cloudsc.openpaas.OpenPaasConnectionFactory;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openshift.client.IApplication;
import com.openshift.client.IDomain;
import com.openshift.client.IOpenShiftConnection;
import com.openshift.client.IUser;
import com.openshift.client.cartridge.IStandaloneCartridge;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class DomainTest {

	static final Logger logger = LoggerFactory.getLogger(DomainTest.class);
	
	@SuppressWarnings("unused")
	private IOpenShiftConnection conn;
	
	@Before
	public void setUp() throws Exception {
		conn = new OpenPaasConnectionFactory().getConnection("openpaas", "kikimans@jyes.co.kr", "alsgh@1716");
	}
	
	@Test
	public void test_도메인_리스트(){
		List<IDomain> domains = conn.getDomains();
		
		assertThat(domains.isEmpty(), is(false));
		
		for(IDomain domain : domains){
			logger.info("Domain list" + domain);
		}
	}

	@Test
	public void test_도메인여부() {
		IUser _user = conn.getUser();
		assertThat(_user.hasDomain(), is(true));
		logger.info("default Domain : " + _user.getDefaultDomain());
	}
	
	@Test
	public void test_도메인_추가(){
		IUser _user = conn.getUser();
		IDomain domain = _user.createDomain("test2");
		
		assertThat(domain.getId(), is("test2"));
	}
	
	@Test
	public void test_도메인가능에_생성된_Application_여부(){
		IUser _user = conn.getUser();		
		IDomain domain = _user.getDomain("test1");
		List<IApplication> apps = domain.getApplications(); 	
		assertThat(apps.isEmpty(), is(false));	
	}
	
	

}
