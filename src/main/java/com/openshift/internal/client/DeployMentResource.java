/**
 * 
 */
package com.openshift.internal.client;

import java.util.List;
import java.util.Map;

import com.openshift.client.IDeployment;
import com.openshift.client.Message;
import com.openshift.client.Messages;
import com.openshift.client.OpenShiftException;
import com.openshift.internal.client.response.DeployMentResourceDTO;
import com.openshift.internal.client.response.Link;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * com.openshift.internal.client
 * DeployMentResource.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 9. 23.
 * @Version : 
 */
public class DeployMentResource extends AbstractOpenShiftResource implements
		IDeployment {

	/* (non-Javadoc)
	 * @see com.openshift.client.IOpenShiftResource#refresh()
	 *
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @Method : refresh * 
	 * @date   : 2014. 9. 23.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 9. 23.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @throws OpenShiftException
	 */

	private List<String> activations;	
	private String created_at;
	private boolean force_clean_build;
	private boolean hot_deploy;
	private String id;
	private String ref;
	private String sha1;
	

	protected DeployMentResource(DeployMentResourceDTO dto, ApplicationResource app) {
		// TODO Auto-generated constructor stub
		
		this(dto.getActivations(), dto.getCreated_at(), dto.isForce_clean_build(),
				dto.isHot_deploy(),dto.getId(),dto.getRef(), dto.getSha1(), app, dto.getMessages());
	}
	
	

	/**
	 * @param service
	 * @param activations
	 * @param created_at
	 * @param force_clean_build
	 * @param hot_deploy
	 * @param id
	 * @param ref
	 * @param sha1
	 */
	public DeployMentResource(final List<String> activations,
			final String created_at, final boolean force_clean_build, final boolean hot_deploy,
			final String id, final String ref, final String sha1,final ApplicationResource app, final Messages message) {
		super(app.getService(), null, message );
		this.activations = activations;
		this.created_at = created_at;
		this.force_clean_build = force_clean_build;
		this.hot_deploy = hot_deploy;
		this.id = id;
		this.ref = ref;
		this.sha1 = sha1;
	}



	@Override
	public void refresh() throws OpenShiftException {
		// TODO Auto-generated method stub

	}



	@Override
	public List<String> getActivations() {
		// TODO Auto-generated method stub
		return activations;
	}



	@Override
	public String getCreateAt() {
		// TODO Auto-generated method stub
		return created_at;
	}



	@Override
	public boolean isForce_clean_build() {
		// TODO Auto-generated method stub
		return force_clean_build;
	}



	@Override
	public boolean isHot_deploy() {
		// TODO Auto-generated method stub
		return hot_deploy;
	}



	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}



	@Override
	public String getRef() {
		// TODO Auto-generated method stub
		return ref;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeployMentResource [activations=");
		builder.append(activations);
		builder.append(", created_at=");
		builder.append(created_at);
		builder.append(", force_clean_build=");
		builder.append(force_clean_build);
		builder.append(", hot_deploy=");
		builder.append(hot_deploy);
		builder.append(", id=");
		builder.append(id);
		builder.append(", ref=");
		builder.append(ref);
		builder.append(", sha1=");
		builder.append(sha1);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see com.openshift.client.IDeployment#getActivations()
	 *
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 *
	 * @Method : getActivations * 
	 * @date   : 2014. 9. 23.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 9. 23.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @return
	 */
	
	

	
}
