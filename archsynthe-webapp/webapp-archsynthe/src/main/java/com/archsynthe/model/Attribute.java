/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.model;

import java.io.Serializable;

/**
 * The Attribute class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Attribute implements Serializable {

	String type = "";
	String tag = "";
	String value = "";

	public Attribute(String tag) {
		this.type = "attribute";
		this.tag = tag;
	}

	public String getType() {
		return type;
	}

	public String getTag() {
		return tag;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
