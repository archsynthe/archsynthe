/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.paradigm;

import javax.persistence.*;
import java.util.Set;

/**
 * All modeling practices are based on a few simple concepts.  The model has to define some basic categories of "thing"
 * that can be created.  Instances of each "thing" must be unique in some way.  For example, in the context of writing
 * a book, the "things" of interest are: Chapters, Threads, Characters, Settings, Scenes, etc.  Archsynthe allows the
 * user to define custom classes of "things", and each of these classes of thing are represented as a
 * {@literal Component}.  Within a given modeling paradigm, the name of each Component must be unique.  However,
 * because the components for many paradigms are stored in the same table in a database, we use a separate
 * universally unique identifier (UUID) as a surrogate key, and do not require uniqueness as a constraint on the
 * mapped table.
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Table(schema = "archsynthe", name = "component")
public class Component {

	/**
	 * A unique identifier (surrogate key) which is modeled as a string-formatted {@link UUID} value.
	 */
	private String id;

	/**
	 * The paradigm (modeling namespace) which defines the component.
	 */
	private Paradigm paradigm;

	/**
	 *
	 */
	private String name;

	private Set<Attribute> attributes;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne
	public Paradigm getParadigm() {
		return paradigm;
	}

	public void setParadigm(Paradigm paradigm) {
		this.paradigm = paradigm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany
	public Set<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<Attribute> attributes) {
		this.attributes = attributes;
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
