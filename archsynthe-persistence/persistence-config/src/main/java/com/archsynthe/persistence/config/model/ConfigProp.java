/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.config.model;

import javax.persistence.*;

/**
 * The ConfigProp class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Table(catalog = "archsynthe", name = "cfg_configprop")
public class ConfigProp {

	private Long id;
	private Component component;
	private String name;
	private String value;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "cfg_component")
	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
