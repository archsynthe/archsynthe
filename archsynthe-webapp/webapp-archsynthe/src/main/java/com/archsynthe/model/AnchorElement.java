/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.model;

/**
 * The AnchorElement class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class AnchorElement extends Element {

	String href = "";

	public AnchorElement() {
		super("a");
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
