/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * The Element class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Element implements Serializable {

	String type = "";
	String tag = "";
	IdAttribute id = new IdAttribute();
	Set<String> classes = new HashSet<String>();
	List<Element> children = new LinkedList<Element>();

	public Element(String tag) {
		this.type = "element";
		this.tag = tag;
	}

	public String getType() {
		return type;
	}

	public String getTag() {
		return tag;
	}

	public String getId() {
		return id.getValue();
	}

	public Element setId(String id) {
		this.id.setValue(id);
		return this;
	}

	public Set<String> getClasses() {
		return classes;
	}

	public void addClass(String classVal) {
		this.classes.add(classVal);
	}

	public List<Element> getChildren() {
		return children;
	}

	public void append(Element child) {
		children.add(children.size(),child);
	}

	public void prepend(Element child) {
		children.add(0,child);
	}

}
