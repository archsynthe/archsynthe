/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.paradigm.manager;

import com.archsynthe.persistence.paradigm.model.Attribute;

/**
 * The ParadigmManagerBean class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class AttributeManagerBean
		implements AttributeManager {

	@Override
	public Attribute create(String name) {
		Attribute attribute = new Attribute();
		attribute.setName(name);
		return attribute;
	}
}
