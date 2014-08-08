package kr.cloudsc.openpaas;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.openshift.client.configuration.AbstractOpenshiftConfiguration;
import com.openshift.client.configuration.DefaultConfiguration;
import com.openshift.client.configuration.SystemConfiguration;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class OpenPaasConfiguration extends AbstractOpenshiftConfiguration {

	protected OpenPaasConfiguration() throws FileNotFoundException, IOException {
		super(new OpenPaasProperties(new DefaultConfiguration()));
		// TODO Auto-generated constructor stub
	}

}
