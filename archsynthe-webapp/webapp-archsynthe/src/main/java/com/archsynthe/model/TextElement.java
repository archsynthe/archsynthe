/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.model;

/**
 * The TextElement class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class TextElement extends Element {

	String text = "";

	public TextElement() {
		super("text");
	}

	public TextElement(String text) {
		super("text");
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
