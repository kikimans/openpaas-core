package kr.cloudsc.openpaas.client;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import kr.cloudsc.openpaas.OpenPaasConnectionFactory;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openshift.client.IDomain;
import com.openshift.client.IOpenShiftConnection;
import com.openshift.client.IUser;
import com.openshift.client.OpenShiftConnectionFactory;
import com.openshift.client.cartridge.IStandaloneCartridge;
import com.openshift.client.cartridge.StandaloneCartridge;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class OpenShiftConnectionTest {

	static final Logger logger = LoggerFactory.getLogger(OpenShiftConnectionTest.class);
	
	private IOpenShiftConnection conn;

	@Before
	public void setUp() throws Exception {
		conn = new OpenPaasConnectionFactory().getConnection("openpaas","kikimans@jyes.co.kr","alsgh@1716");
	}

	@Test
	public void test_OpenShiftOrigin_Connection_Test() {		
		IOpenShiftConnection conn = new OpenShiftConnectionFactory().getConnection("openpaas", "kikimans@jyes.co.kr", "alsgh@1716");
		
		assertThat(conn, is(notNullValue()));
	}
	
	@Test
	public void test_OpenPaas_Connection_Test(){		
		assertThat(conn, is(notNullValue()));
	}
	
	

}
