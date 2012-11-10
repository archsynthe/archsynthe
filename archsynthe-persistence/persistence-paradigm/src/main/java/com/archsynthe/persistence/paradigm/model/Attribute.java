/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.paradigm.model;

import javax.persistence.*;

/**
 * The Attribute class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Table(schema = "archsynthe", name = "attribute")
public class Attribute {

	private String id;

	private Element element;

	private String name;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne
	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
