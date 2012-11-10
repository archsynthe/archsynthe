/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.paradigm.manager;

import com.archsynthe.persistence.paradigm.model.Attribute;
import com.archsynthe.persistence.paradigm.model.Element;

/**
 * The ParadigmManagerBean class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class ElementManagerBean
		implements ElementManager {

	@Override
	public Element create(String name) {
		Element element = new Element();
		element.setName(name);
		return element;
	}

	@Override
	public void associate(Element element, Attribute attribute) {
		attribute.setElement(element);
		element.getAttributes().add(attribute);
	}

	@Override
	public void disassociate(Element element, Attribute attribute) {
		attribute.setElement(null);
		element.getAttributes().remove(attribute);
	}

}
