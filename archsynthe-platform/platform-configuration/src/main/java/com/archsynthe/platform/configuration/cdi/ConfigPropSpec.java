/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.configuration.cdi;

/**
 * Immutable class which holds the specification data for a configurable property.
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConfigPropSpec {

	public enum InjectionType {
		FIELD, METHOD
	}

	InjectionType getInjectionType();

	String getName();

}
