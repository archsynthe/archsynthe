/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.persistence.config.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The ComponentTest class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class ComponentTest {

	@Test
	public void testCreateComponent() {
		Component component = new Component();
		assertNotNull(component);
	}

}
