/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.model;

/**
 * The H1Element class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class H1Element extends Element {
	public H1Element() {
		super("h1");
	}

	public H1Element(String text) {
		super("h1");
		append(new TextElement(text));
	}
}
