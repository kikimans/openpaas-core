/**
 * 
 */
package com.openshift.internal.client.response;

import java.util.List;
import java.util.Map;

import com.openshift.client.Messages;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * com.openshift.internal.client.response
 * DeployMentResourceDTO.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 9. 23.
 * @Version : 
 */
public class DeployMentResourceDTO extends BaseResourceDTO {

	private List<String> activations;	
	private String created_at;
	private boolean force_clean_build;
	private boolean hot_deploy;
	private String id;
	private String ref;
	private String sha1;
	/**
	 * @param activations
	 * @param created_at
	 * @param force_clean_build
	 * @param hot_deploy
	 * @param id
	 * @param ref
	 * @param sha1
	 */
	DeployMentResourceDTO(final List<String> activations, final String created_at,
			final boolean force_clean_build,final boolean hot_deploy, final String id,
			final String ref, final String sha1,final Map<String, Link> links, Messages messages) {
		super(links, messages);
		this.activations = activations;
		this.created_at = created_at;
		this.force_clean_build = force_clean_build;
		this.hot_deploy = hot_deploy;
		this.id = id;
		this.ref = ref;
		this.sha1 = sha1;
	}
	public List<String> getActivations() {
		return activations;
	}
	public String getCreated_at() {
		return created_at;
	}
	public boolean isForce_clean_build() {
		return force_clean_build;
	}
	public boolean isHot_deploy() {
		return hot_deploy;
	}
	public String getId() {
		return id;
	}
	public String getRef() {
		return ref;
	}
	public String getSha1() {
		return sha1;
	}
	
	
	
	
	
	
}
