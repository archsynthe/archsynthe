/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.configuration.cdi;

import java.util.ArrayList;
import java.util.List;

/**
 * The ImmutableConfigurableSpec class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public class ImmutableConfigurableSpec implements ConfigurableSpec {

	private final String name;
	private final String version;
	private final List<ConfigPropSpec> configPropSpecs;

	public ImmutableConfigurableSpec(String name, String version, List<ConfigPropSpec> configPropSpecs) {
		this.name = name;
		this.version = version;
		this.configPropSpecs = new ArrayList<ConfigPropSpec>(configPropSpecs.size());
		this.configPropSpecs.addAll(configPropSpecs);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public List<ConfigPropSpec> getConfigPropSpecs() {
		return configPropSpecs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ImmutableConfigurableSpec that = (ImmutableConfigurableSpec) o;

		if (!configPropSpecs.equals(that.configPropSpecs))
			return false;
		if (!name.equals(that.name))
			return false;
		if (!version.equals(that.version))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + version.hashCode();
		result = 31 * result + configPropSpecs.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "ImmutableConfigurableSpec{" +
				"name='" + name + '\'' +
				", version='" + version + '\'' +
				", configPropSpecs=" + configPropSpecs +
				'}';
	}

}
