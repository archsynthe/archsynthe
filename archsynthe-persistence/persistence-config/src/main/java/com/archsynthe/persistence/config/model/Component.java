/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.config.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * The Component class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Table(catalog = "archsynthe", name = "cfg_component")
public class Component {

	private Long id;
	private String name;
	private String version;
	private Set<ConfigProp> configProps;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@OneToMany
	public Set<ConfigProp> getConfigProps() {
		return configProps;
	}

	public void setConfigProps(Set<ConfigProp> configProps) {
		this.configProps = configProps;
	}
}
