/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.config.manager;

import com.archsynthe.persistence.config.model.Component;

/**
 * The ComponentManagerBean class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class ComponentManagerBean implements ComponentManager {

	@Override
	public Component create(String name) {
		Component component = new Component();
		component.setName(name);
		return component;
	}

}
