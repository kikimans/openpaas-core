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

import com.openshift.client.IOpenShiftConnection;
import com.openshift.client.cartridge.IStandaloneCartridge;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class StandAloneCartridgeTest {

	static final Logger logger = LoggerFactory.getLogger(StandAloneCartridgeTest.class);
	
	private IOpenShiftConnection conn;
	
	@Before
	public void setUp() throws Exception {
		conn = new OpenPaasConnectionFactory().getConnection("OpenPaas", "kikimans@jyes.co.kr", "alsgh@1716");
	}

	@Test
	public void test_StandAlone_카트리지리스트() {
		List<IStandaloneCartridge> standaloneCartridges = conn.getStandaloneCartridges();
		
		assertThat(standaloneCartridges.isEmpty(), is(false));
	}
	
	@Test
	public void test_StandAlone_카트리지_Tag_리스트(){
		List<IStandaloneCartridge> standaloneCartridges = conn.getStandaloneCartridges();
		List<String> allTagsList = new ArrayList<String>();
		for(IStandaloneCartridge cartridge : standaloneCartridges){			
			if(cartridge.getTags() == null){
				continue;
			}else{
				for(String tag : cartridge.getTags()){
					allTagsList.add(tag);
				}
			}
						
		}
		List<String> uniqueTags = new ArrayList<String>(new HashSet<String>(allTagsList));	
		assertThat(allTagsList.isEmpty(), is(false));
		assertThat(uniqueTags.isEmpty(), is(false));			
	}
	
	@Test
	public void test_StandAlone_카트리지_Tag_검색(){		
		String tag = "python";
		List<IStandaloneCartridge> searchCartridge = conn.getSearchTagStandaloneCartridges(tag);		
		assertThat(searchCartridge.size(), is(2));	
	}

}
