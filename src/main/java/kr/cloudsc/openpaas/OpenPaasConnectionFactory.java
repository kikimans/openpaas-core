package kr.cloudsc.openpaas;

import java.io.IOException;

import com.openshift.client.IOpenShiftConnection;
import com.openshift.client.OpenShiftConnectionFactory;
import com.openshift.client.OpenShiftException;
import com.openshift.client.configuration.IOpenShiftConfiguration;
import com.openshift.client.configuration.OpenShiftConfiguration;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class OpenPaasConnectionFactory extends OpenShiftConnectionFactory {

	public OpenPaasConnectionFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IOpenShiftConnection getConnection(String clientId, String username,
			String password, String serverUrl) throws OpenShiftException {
		// TODO Auto-generated method stub
		IOpenShiftConfiguration configuration;
		try {
			configuration = new OpenPaasConfiguration();
		} catch (IOException e) {
			throw new OpenShiftException(e, "Failed to load OpenShift configuration file.");
		}
		return super.getConnection(clientId, username, password, configuration.getLibraServer());
	}

	
	
	

}
