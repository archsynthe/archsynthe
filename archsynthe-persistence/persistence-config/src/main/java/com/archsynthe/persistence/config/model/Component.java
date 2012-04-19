/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.config.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Component class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Component {

	@Id
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Component component = (Component) o;

		if (!id.equals(component.id))
			return false;
		if (!name.equals(component.name))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + name.hashCode();
		return result;
	}
}
