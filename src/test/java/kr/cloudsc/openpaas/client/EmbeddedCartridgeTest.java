package kr.cloudsc.openpaas.client;

import static org.junit.Assert.*;

import java.util.List;

import kr.cloudsc.openpaas.OpenPaasConnectionFactory;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openshift.client.IOpenShiftConnection;
import com.openshift.client.cartridge.IEmbeddableCartridge;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class EmbeddedCartridgeTest {

	static final Logger logger = LoggerFactory.getLogger(EmbeddedCartridgeTest.class);
	
	@SuppressWarnings("unused")
	private IOpenShiftConnection conn;
	@Before
	public void setUp() throws Exception {
		conn = new OpenPaasConnectionFactory().getConnection("OpenPaas", "kikimans@jyes.co.kr", "alsgh@1716");
	}

	@Test
	public void test_Embedded_카트리지_검색() {
		List<IEmbeddableCartridge> embeddedCartridges =  conn.getEmbeddableCartridges();		
		for(IEmbeddableCartridge iemCart : embeddedCartridges){
			logger.info("a : " + iemCart);
			//logger.info("IEmbeddableCartList {}", index, iemCart.getName());
			//++index;
		}
	}

}
