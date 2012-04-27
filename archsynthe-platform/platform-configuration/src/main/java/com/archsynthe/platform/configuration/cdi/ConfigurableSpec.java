/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.configuration.cdi;

import java.util.List;

/**
 * Immutable class which holds the specification data for a configurable object.
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConfigurableSpec {

	String getName();

	String getVersion();

	List<ConfigPropSpec> getConfigPropSpecs();

}
