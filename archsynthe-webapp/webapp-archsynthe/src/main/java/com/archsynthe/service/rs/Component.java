/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.service.rs;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * The Component class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@XmlType(name = "component")
public class Component implements Serializable {

	@XmlAttribute
	Integer id;

	@XmlAttribute
	String name;

	@XmlAttribute
	String label;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
