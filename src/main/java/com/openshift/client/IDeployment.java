/**
 * 
 */
package com.openshift.client;

import java.util.List;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * com.openshift.client
 * IDeployment.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 9. 23.
 * @Version : 
 */
public interface IDeployment extends IOpenShiftResource{

	public List<String> getActivations();
	
	public String getCreateAt();
	
	public boolean isForce_clean_build();
	
	public boolean isHot_deploy();
	
	public String getId();
	
	public String getRef();
	
}
