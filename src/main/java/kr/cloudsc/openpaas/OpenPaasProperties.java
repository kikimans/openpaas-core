package kr.cloudsc.openpaas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import com.openshift.client.configuration.AbstractOpenshiftConfiguration;
import com.openshift.client.configuration.IOpenShiftConfiguration;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class OpenPaasProperties extends AbstractOpenshiftConfiguration {
	
	protected OpenPaasProperties(IOpenShiftConfiguration parentConfiguration)
			throws FileNotFoundException, IOException {
		super(parentConfiguration);
		// TODO Auto-generated constructor stub
	}

	private static final String BUNDLE_NAME="config/openshift/cloudsc";
	private ResourceBundle bundle;

	
	@Override
	protected Properties getProperties(File file, Properties defaultProperties)
			throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Properties properties = new Properties(defaultProperties);
		
		copyResouceBundleProperties(properties);
		
		return properties;
		
		
	}

	private void copyResouceBundleProperties(Properties properties) {
		// TODO Auto-generated method stub
		try {
			bundle = ResourceBundle.getBundle(BUNDLE_NAME);
			if(bundle != null){
				Enumeration<String> enumKey = bundle.getKeys();
				while(enumKey.hasMoreElements()){
					String keyName = enumKey.nextElement();
					String value = bundle.getString(keyName);
					properties.put(keyName, value);					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
	

}
