/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.platform.configuration;

import com.archsynthe.platform.configuration.cdi.ConfigurableSpec;

import java.util.Map;

/**
 * The ConfigurationService interface ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConfigurationService {

	/**
	 * Uses the information contained in the {@link ConfigurableSpec} object to
	 * produce a {@link Map} of property values keyed by property name.
	 *
	 * @param spec A populated {@link ConfigurableSpec} instance.
	 * @return A {@link Map} of {@link Object} instances to bind, keyed by
	 * a {@link String} representing the property name.
	 */
	Map<String,Object> lookupConfigPropValues(ConfigurableSpec spec);

}
