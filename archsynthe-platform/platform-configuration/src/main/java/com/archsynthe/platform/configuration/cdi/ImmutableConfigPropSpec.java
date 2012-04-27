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
public class ImmutableConfigPropSpec implements ConfigPropSpec {

	private final InjectionType injectionType;

	private final String name;

	public ImmutableConfigPropSpec(InjectionType injectionType, String name) {
		this.injectionType = injectionType;
		this.name = name;
	}

	public InjectionType getInjectionType() {
		return injectionType;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ImmutableConfigPropSpec that = (ImmutableConfigPropSpec) o;

		return name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return "ImmutableConfigPropSpec{" +
				"name='" + name + '\'' +
				'}';
	}
}
