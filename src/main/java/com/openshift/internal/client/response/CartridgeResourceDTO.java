/******************************************************************************* 
 * Copyright (c) 2012 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package com.openshift.internal.client.response;

import java.net.URL;
import java.util.List;
import java.util.Map;

import com.openshift.client.Messages;
import com.openshift.internal.client.CartridgeType;

/**
 * @author Xavier Coulon
 * @author Andre Dietisheim
 * 
 */
public class CartridgeResourceDTO extends BaseResourceDTO {

	private final String name;
	private String displayName;
	private String description;
	private final CartridgeType type;
	private URL url;
	private CartridgeResourceProperties properties;
	
	private List<String> tags;

	protected CartridgeResourceDTO(final String name, final CartridgeType type, final CartridgeResourceProperties properties) {
		this(name, null, null, type, null, properties, null, null);
	}

	protected CartridgeResourceDTO(final String name, final String displayName, final String description,
			final String type, URL url, CartridgeResourceProperties properties, final Map<String, Link> links, final Messages messages) {
		this(name, displayName, description, CartridgeType.safeValueOf(type), url, properties, links, messages);
	}

	CartridgeResourceDTO(final String name, final String displayName, final String description,
			final CartridgeType type, URL url, CartridgeResourceProperties properties, final Map<String, Link> links,
			final Messages messages) {
		super(links, messages);
		this.name = name;
		this.displayName = displayName;
		this.description = description;
		this.type = type;
		this.url = url;
		this.properties = properties;
	}

	public CartridgeResourceDTO(String name2, String displayName2,
			String description2, CartridgeType type2, URL url2,
			CartridgeResourceProperties properties2, Map<String, Link> links,
			Messages messages, List<String> tags2) {
		// TODO Auto-generated constructor stub
		super(links, messages);
		this.name = name2;
		this.displayName = displayName2;
		this.description = description2;
		this.type = type2;
		this.url = url2;
		this.properties = properties2;
		this.tags = tags2;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getDescription() {
		return description;
	}

	public CartridgeType getType() {
		return type;
	}

	public URL getUrl() {
		return url;
	}
	
	

	public List<String> getTags() {
		return tags;
	}

	public CartridgeResourceProperties getProperties() {
		return properties;
	}

	@Override
	public String toString() {
		return "CartridgeResourceDTO ["
				+ " name=" + name
				+ ", description=" + description
				+ ", displayName=" + displayName
				+ ", type=" + type
				+ ", url=" + url
				+ ", tags=" + tags
				+ "]";
	}

}
